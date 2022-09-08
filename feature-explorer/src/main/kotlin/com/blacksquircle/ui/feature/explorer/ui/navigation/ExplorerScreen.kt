/*
 * Copyright 2022 Squircle CE contributors.
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

package com.blacksquircle.ui.feature.explorer.ui.navigation

import com.blacksquircle.ui.core.ui.navigation.Screen
import com.blacksquircle.ui.feature.explorer.data.utils.Operation

sealed class ExplorerScreen(route: String) : Screen<String>(route) {

    class RestrictedDialog(action: String, data: String) : ExplorerScreen(
        route = "blacksquircle://explorer/restricted?action=$action&data=$data"
    )
    class DeleteDialog(fileName: String, fileCount: Int) : ExplorerScreen(
        route = "blacksquircle://explorer/delete?fileName=$fileName&fileCount=$fileCount"
    )
    class RenameDialog(fileName: String) : ExplorerScreen(
        route = "blacksquircle://explorer/rename?fileName=$fileName"
    )
    class ProgressDialog(totalCount: Int, operation: Operation) : ExplorerScreen(
        route = "blacksquircle://explorer/progress?totalCount=$totalCount&operation=${operation.value}"
    )
    class PropertiesDialog(data: String) : ExplorerScreen(
        route = "blacksquircle://explorer/properties?data=$data"
    )

    object CreateDialog : ExplorerScreen("blacksquircle://explorer/create")
    object CompressDialog : ExplorerScreen("blacksquircle://explorer/compress")
}