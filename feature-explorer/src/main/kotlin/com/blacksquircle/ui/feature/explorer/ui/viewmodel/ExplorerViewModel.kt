/*
 * Copyright 2022 Squircle IDE contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blacksquircle.ui.feature.explorer.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blacksquircle.ui.core.data.storage.keyvalue.SettingsManager
import com.blacksquircle.ui.core.domain.resources.StringProvider
import com.blacksquircle.ui.core.ui.viewstate.ViewEvent
import com.blacksquircle.ui.feature.explorer.R
import com.blacksquircle.ui.feature.explorer.data.utils.FileSorter
import com.blacksquircle.ui.feature.explorer.data.utils.Operation
import com.blacksquircle.ui.feature.explorer.data.utils.appendList
import com.blacksquircle.ui.feature.explorer.data.utils.replaceList
import com.blacksquircle.ui.feature.explorer.domain.repository.ExplorerRepository
import com.blacksquircle.ui.feature.explorer.ui.navigation.ExplorerScreen
import com.blacksquircle.ui.feature.explorer.ui.viewstate.DirectoryViewState
import com.blacksquircle.ui.feature.explorer.ui.viewstate.ExplorerViewState
import com.blacksquircle.ui.filesystem.base.exception.DirectoryExpectedException
import com.blacksquircle.ui.filesystem.base.exception.RestrictedException
import com.blacksquircle.ui.filesystem.base.model.FileModel
import com.blacksquircle.ui.filesystem.base.model.FileType
import com.blacksquircle.ui.filesystem.base.utils.isValidFileName
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ExplorerViewModel @Inject constructor(
    private val stringProvider: StringProvider,
    private val settingsManager: SettingsManager,
    private val explorerRepository: ExplorerRepository,
) : ViewModel() {

    private val _explorerViewState = MutableStateFlow<ExplorerViewState>(ExplorerViewState.Stub)
    val explorerViewState: StateFlow<ExplorerViewState> = _explorerViewState.asStateFlow()

    private val _directoryViewState = MutableStateFlow<DirectoryViewState>(DirectoryViewState.Stub)
    val directoryViewState: StateFlow<DirectoryViewState> = _directoryViewState.asStateFlow()

    private val _refreshState = MutableStateFlow(false)
    val refreshState: StateFlow<Boolean> = _refreshState.asStateFlow()

    private val _viewEvent = Channel<ViewEvent>(Channel.BUFFERED)
    val viewEvent: Flow<ViewEvent> = _viewEvent.receiveAsFlow()

    private val _customEvent = MutableSharedFlow<ExplorerViewEvent>()
    val customEvent: SharedFlow<ExplorerViewEvent> = _customEvent.asSharedFlow()

    var viewMode: Int = settingsManager.viewMode.toInt()
        private set
    var sortMode: Int = settingsManager.sortMode.toInt()
        private set
    var showHidden: Boolean = settingsManager.showHidden
        private set

    private val breadcrumbs = mutableListOf<FileModel>()
    private val selection = mutableListOf<FileModel>()
    private val buffer = mutableListOf<FileModel>()
    private val files = mutableListOf<FileModel>()
    private var operation = Operation.CREATE
    private var query = ""

    init {
        obtainEvent(ExplorerIntent.OpenFolder())
    }

    fun obtainEvent(event: ExplorerIntent) {
        when (event) {
            is ExplorerIntent.SearchFiles -> searchFiles(event)
            is ExplorerIntent.SelectFiles -> selectFiles(event)
            is ExplorerIntent.SelectTab -> selectTab(event)
            is ExplorerIntent.Refresh -> refreshList()

            is ExplorerIntent.Cut -> cutButton()
            is ExplorerIntent.Copy -> copyButton()
            is ExplorerIntent.Create -> createButton()
            is ExplorerIntent.Rename -> renameButton()
            is ExplorerIntent.Delete -> deleteButton()
            is ExplorerIntent.SelectAll -> selectAllButton()
            is ExplorerIntent.Properties -> propertiesButton()
            is ExplorerIntent.CopyPath -> copyPathButton()
            is ExplorerIntent.Compress -> compressButton()

            is ExplorerIntent.OpenFolder -> listFiles(event)
            is ExplorerIntent.OpenFileWith -> openFileAs(event)
            is ExplorerIntent.OpenFile -> openFile(event)
            is ExplorerIntent.CreateFile -> createFile(event)
            is ExplorerIntent.RenameFile -> renameFile(event)
            is ExplorerIntent.DeleteFile -> deleteFile()
            is ExplorerIntent.CutFile -> cutFile()
            is ExplorerIntent.CopyFile -> copyFile()
            is ExplorerIntent.CompressFile -> compressFile(event)
            is ExplorerIntent.ExtractFile -> extractFile(event)

            is ExplorerIntent.ShowHidden -> showHidden()
            is ExplorerIntent.HideHidden -> hideHidden()
            is ExplorerIntent.SortByName -> sortByName()
            is ExplorerIntent.SortBySize -> sortBySize()
            is ExplorerIntent.SortByDate -> sortByDate()
        }
    }

    fun handleOnBackPressed(): Boolean {
        return when {
            selection.isNotEmpty() -> {
                _explorerViewState.value = ExplorerViewState.ActionBar(
                    breadcrumbs = breadcrumbs,
                    selection = selection.replaceList(emptyList()),
                    operation = operation,
                )
                true
            }
            breadcrumbs.size > 1 -> {
                _explorerViewState.value = ExplorerViewState.ActionBar(
                    breadcrumbs = breadcrumbs.replaceList(breadcrumbs - breadcrumbs.last()),
                    selection = selection.replaceList(emptyList()),
                    operation = operation,
                )
                listFiles(ExplorerIntent.OpenFolder(breadcrumbs.lastOrNull()))
                true
            }
            else -> false
        }
    }

    private fun listFiles(event: ExplorerIntent.OpenFolder) {
        viewModelScope.launch {
            try {
                if (!refreshState.value && query.isEmpty()) { // SwipeRefresh
                    _directoryViewState.value = DirectoryViewState.Loading
                }
                val fileTree = explorerRepository.listFiles(event.fileModel)
                _explorerViewState.value = ExplorerViewState.ActionBar(
                    breadcrumbs = breadcrumbs.appendList(fileTree.parent),
                    selection = selection,
                    operation = operation,
                )
                if (fileTree.children.isNotEmpty()) {
                    _directoryViewState.value = DirectoryViewState.Files(fileTree.children)
                } else {
                    _directoryViewState.value = DirectoryViewState.Empty
                }
                files.replaceList(fileTree.children)
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
                restoreState()
            } finally {
                _refreshState.value = false
            }
        }
    }

    private fun searchFiles(event: ExplorerIntent.SearchFiles) {
        viewModelScope.launch {
            query = event.query
            val searchList = files.filter { it.name.contains(query, ignoreCase = true) }
            if (searchList.isNotEmpty()) {
                _directoryViewState.value = DirectoryViewState.Files(searchList)
            } else {
                _directoryViewState.value = DirectoryViewState.Empty
            }
        }
    }

    private fun selectFiles(event: ExplorerIntent.SelectFiles) {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                selection = selection.replaceList(event.selection),
                operation = operation,
            )
        }
    }

    private fun selectTab(event: ExplorerIntent.SelectTab) {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs.replaceList(breadcrumbs.take(event.position + 1)),
                selection = selection.replaceList(emptyList()),
                operation = operation,
            )
            listFiles(ExplorerIntent.OpenFolder(breadcrumbs.lastOrNull()))
        }
    }

    private fun refreshList() {
        viewModelScope.launch {
            _refreshState.value = true
            listFiles(ExplorerIntent.OpenFolder(breadcrumbs.lastOrNull()))
        }
    }

    private fun cutButton() {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                operation = Operation.CUT.also { type ->
                    buffer.replaceList(selection)
                    operation = type
                },
                selection = selection.replaceList(emptyList()),
            )
        }
    }

    private fun copyButton() {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                operation = Operation.COPY.also { type ->
                    buffer.replaceList(selection)
                    operation = type
                },
                selection = selection.replaceList(emptyList()),
            )
        }
    }

    private fun createButton() {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                operation = Operation.CREATE.also { type ->
                    buffer.replaceList(emptyList()) // empty buffer for Operation.CREATE
                    operation = type
                },
                selection = selection.replaceList(emptyList()),
            )
            val screen = ExplorerScreen.CreateDialog
            _viewEvent.send(ViewEvent.Navigation(screen))
        }
    }

    private fun renameButton() {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                operation = Operation.RENAME.also { type ->
                    buffer.replaceList(selection)
                    operation = type
                },
                selection = selection.replaceList(emptyList()),
            )
            val screen = ExplorerScreen.RenameDialog(buffer.first().name)
            _viewEvent.send(ViewEvent.Navigation(screen))
        }
    }

    private fun deleteButton() {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                operation = Operation.DELETE.also { type ->
                    buffer.replaceList(selection)
                    operation = type
                },
                selection = selection.replaceList(emptyList()),
            )
            val screen = ExplorerScreen.DeleteDialog(buffer.first().name, buffer.size)
            _viewEvent.send(ViewEvent.Navigation(screen))
        }
    }

    private fun selectAllButton() {
        viewModelScope.launch {
            _customEvent.emit(ExplorerViewEvent.SelectAll)
        }
    }

    private fun propertiesButton() {
        viewModelScope.launch {
            try {
                val fileModel = selection.first()
                val properties = explorerRepository.propertiesOf(fileModel)
                val data = Gson().toJson(properties) // TODO better way
                val screen = ExplorerScreen.PropertiesDialog(data)
                _viewEvent.send(ViewEvent.Navigation(screen))
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun copyPathButton() {
        viewModelScope.launch {
            val fileModel = selection.first()
            _customEvent.emit(ExplorerViewEvent.CopyPath(fileModel))
            restoreState()
        }
    }

    private fun compressButton() {
        viewModelScope.launch {
            _explorerViewState.value = ExplorerViewState.ActionBar(
                breadcrumbs = breadcrumbs,
                operation = Operation.COMPRESS.also { type ->
                    buffer.replaceList(selection)
                    operation = type
                },
                selection = selection.replaceList(emptyList()),
            )
            val screen = ExplorerScreen.CompressDialog
            _viewEvent.send(ViewEvent.Navigation(screen))
        }
    }

    private fun openFileAs(event: ExplorerIntent.OpenFileWith) {
        viewModelScope.launch {
            val fileModel = event.fileModel ?: selection.first()
            _customEvent.emit(ExplorerViewEvent.OpenFileWith(fileModel))
            restoreState()
        }
    }

    private fun openFile(event: ExplorerIntent.OpenFile) {
        viewModelScope.launch {
            when (event.fileModel.type) {
                FileType.ARCHIVE -> extractFile(ExplorerIntent.ExtractFile(event.fileModel))
                FileType.DEFAULT,
                FileType.TEXT -> _customEvent.emit(ExplorerViewEvent.OpenFile(event.fileModel))
                else -> openFileAs(ExplorerIntent.OpenFileWith(event.fileModel))
            }
        }
    }

    private fun createFile(event: ExplorerIntent.CreateFile) {
        viewModelScope.launch {
            try {
                val isValid = event.fileName.isValidFileName()
                if (!isValid) {
                    _viewEvent.send(
                        ViewEvent.Toast(stringProvider.getString(R.string.message_invalid_file_name))
                    )
                    return@launch
                }
                val parent = breadcrumbs.last()
                val child = parent.copy(
                    path = parent.path + "/" + event.fileName,
                    isFolder = event.isFolder
                )
                explorerRepository.createFile(child)
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(1, Operation.CREATE)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun renameFile(event: ExplorerIntent.RenameFile) {
        viewModelScope.launch {
            try {
                val isValid = event.fileName.isValidFileName()
                if (!isValid) {
                    _viewEvent.send(
                        ViewEvent.Toast(stringProvider.getString(R.string.message_invalid_file_name))
                    )
                    return@launch
                }

                val oldFile = buffer.first()
                val newFile = oldFile.copy(
                    path = oldFile.path.substringBeforeLast('/') + "/" + event.fileName,
                    isFolder = oldFile.isFolder
                )
                explorerRepository.renameFile(oldFile, newFile)
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(1, Operation.RENAME)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun deleteFile() {
        viewModelScope.launch {
            try {
                explorerRepository.deleteFiles(buffer)
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(buffer.size, Operation.DELETE)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun cutFile() {
        viewModelScope.launch {
            try {
                explorerRepository.cutFiles(buffer, breadcrumbs.last())
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(buffer.size, Operation.CUT)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun copyFile() {
        viewModelScope.launch {
            try {
                explorerRepository.copyFiles(buffer, breadcrumbs.last())
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(buffer.size, Operation.COPY)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun compressFile(event: ExplorerIntent.CompressFile) {
        viewModelScope.launch {
            try {
                val isValid = event.fileName.isValidFileName()
                if (!isValid) {
                    _viewEvent.send(
                        ViewEvent.Toast(stringProvider.getString(R.string.message_invalid_file_name))
                    )
                    return@launch
                }
                val parent = breadcrumbs.last()
                val child = parent.copy(parent.path + "/" + event.fileName)
                explorerRepository.compressFiles(buffer, child)
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(buffer.size, Operation.COMPRESS)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun extractFile(event: ExplorerIntent.ExtractFile) {
        viewModelScope.launch {
            try {
                explorerRepository.extractFiles(event.fileModel, breadcrumbs.last())
                _viewEvent.send(
                    ViewEvent.Navigation(
                        ExplorerScreen.ProgressDialog(-1, Operation.EXTRACT)
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                handleError(e)
            } finally {
                restoreState()
            }
        }
    }

    private fun showHidden() {
        settingsManager.showHidden = true
        showHidden = true
        refreshList()
    }

    private fun hideHidden() {
        settingsManager.showHidden = false
        showHidden = false
        refreshList()
    }

    private fun sortByName() {
        sortMode = FileSorter.SORT_BY_NAME.also {
            settingsManager.sortMode = it.toString()
            refreshList()
        }
    }

    private fun sortBySize() {
        sortMode = FileSorter.SORT_BY_SIZE.also {
            settingsManager.sortMode = it.toString()
            refreshList()
        }
    }

    private fun sortByDate() {
        sortMode = FileSorter.SORT_BY_DATE.also {
            settingsManager.sortMode = it.toString()
            refreshList()
        }
    }

    private suspend fun handleError(e: Throwable) {
        when (e) {
            is RestrictedException -> {
                _directoryViewState.value = DirectoryViewState.Restricted
            }
            is DirectoryExpectedException -> {
                _viewEvent.send(
                    ViewEvent.Toast(stringProvider.getString(R.string.message_directory_expected))
                )
            }
            else -> {
                _viewEvent.send(
                    ViewEvent.Toast(stringProvider.getString(R.string.message_unknown_exception))
                )
            }
        }
    }

    private fun restoreState() {
        _explorerViewState.value = ExplorerViewState.ActionBar(
            breadcrumbs = breadcrumbs,
            operation = Operation.CREATE.also { type ->
                buffer.replaceList(emptyList())
                operation = type
            },
            selection = selection.replaceList(emptyList()),
        )
    }

    companion object {
        private const val TAG = "ExplorerViewModel"
    }
}