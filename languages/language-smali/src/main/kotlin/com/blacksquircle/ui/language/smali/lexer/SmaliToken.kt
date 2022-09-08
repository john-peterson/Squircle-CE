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

package com.blacksquircle.ui.language.smali.lexer

enum class SmaliToken {
    LONG_LITERAL,
    INTEGER_LITERAL,
    FLOAT_LITERAL,
    DOUBLE_LITERAL,

    DOTDOT,
    ARROW,
    EQUAL,
    COLON,
    SEMICOLON,
    COMMA,
    DOT,
    OPEN_BRACE,
    CLOSE_BRACE,
    OPEN_PAREN,
    CLOSE_PAREN,
    AT,

    TRUE,
    FALSE,
    NULL,

    CLASS_DIRECTIVE,
    SUPER_DIRECTIVE,
    IMPLEMENTS_DIRECTIVE,
    SOURCE_DIRECTIVE,
    FIELD_DIRECTIVE,
    END_FIELD_DIRECTIVE,
    SUBANNOTATION_DIRECTIVE,
    END_SUBANNOTATION_DIRECTIVE,
    ANNOTATION_DIRECTIVE,
    END_ANNOTATION_DIRECTIVE,
    ENUM_DIRECTIVE,
    METHOD_DIRECTIVE,
    END_METHOD_DIRECTIVE,
    REGISTERS_DIRECTIVE,
    LOCALS_DIRECTIVE,
    ARRAY_DATA_DIRECTIVE,
    END_ARRAY_DATA_DIRECTIVE,
    PACKED_SWITCH_DIRECTIVE,
    END_PACKED_SWITCH_DIRECTIVE,
    SPARSE_SWITCH_DIRECTIVE,
    END_SPARSE_SWITCH_DIRECTIVE,
    CATCH_DIRECTIVE,
    CATCHALL_DIRECTIVE,
    LINE_DIRECTIVE,
    PARAMETER_DIRECTIVE,
    END_PARAMETER_DIRECTIVE,
    LOCAL_DIRECTIVE,
    END_LOCAL_DIRECTIVE,
    RESTART_LOCAL_DIRECTIVE,
    PROLOGUE_DIRECTIVE,
    EPILOGUE_DIRECTIVE,

    PRIMITIVE_TYPE,
    VOID_TYPE,
    CLASS_TYPE,

    ANNOTATION_VISIBILITY,
    ACCESS_SPEC,
    HIDDENAPI_RESTRICTION,
    VERIFICATION_ERROR_TYPE,

    INLINE_INDEX,
    VTABLE_INDEX,
    FIELD_OFFSET,

    METHOD_HANDLE_TYPE_FIELD,
    METHOD_HANDLE_TYPE_METHOD,

    INSTRUCTION_FORMAT10t,
    INSTRUCTION_FORMAT10x,
    INSTRUCTION_FORMAT10x_ODEX,
    INSTRUCTION_FORMAT11n,
    INSTRUCTION_FORMAT11x,
    INSTRUCTION_FORMAT12x_OR_ID,
    INSTRUCTION_FORMAT12x,
    INSTRUCTION_FORMAT20bc,
    INSTRUCTION_FORMAT20t,
    INSTRUCTION_FORMAT21c_FIELD,
    INSTRUCTION_FORMAT21c_FIELD_ODEX,
    INSTRUCTION_FORMAT21c_STRING,
    INSTRUCTION_FORMAT21c_TYPE,
    INSTRUCTION_FORMAT21c_METHOD_HANDLE,
    INSTRUCTION_FORMAT21c_METHOD_TYPE,
    INSTRUCTION_FORMAT21ih,
    INSTRUCTION_FORMAT21lh,
    INSTRUCTION_FORMAT21s,
    INSTRUCTION_FORMAT21t,
    INSTRUCTION_FORMAT22b,
    INSTRUCTION_FORMAT22c_FIELD,
    INSTRUCTION_FORMAT22c_FIELD_ODEX,
    INSTRUCTION_FORMAT22c_TYPE,
    INSTRUCTION_FORMAT22cs_FIELD,
    INSTRUCTION_FORMAT22s_OR_ID,
    INSTRUCTION_FORMAT22s,
    INSTRUCTION_FORMAT22t,
    INSTRUCTION_FORMAT22x,
    INSTRUCTION_FORMAT23x,
    INSTRUCTION_FORMAT30t,
    INSTRUCTION_FORMAT31c,
    INSTRUCTION_FORMAT31i_OR_ID,
    INSTRUCTION_FORMAT31i,
    INSTRUCTION_FORMAT31t,
    INSTRUCTION_FORMAT32x,
    INSTRUCTION_FORMAT35c_CALL_SITE,
    INSTRUCTION_FORMAT35c_METHOD,
    INSTRUCTION_FORMAT35c_METHOD_OR_METHOD_HANDLE_TYPE,
    INSTRUCTION_FORMAT35c_METHOD_ODEX,
    INSTRUCTION_FORMAT35c_TYPE,
    INSTRUCTION_FORMAT35mi_METHOD,
    INSTRUCTION_FORMAT35ms_METHOD,
    INSTRUCTION_FORMAT3rc_CALL_SITE,
    INSTRUCTION_FORMAT3rc_METHOD,
    INSTRUCTION_FORMAT3rc_METHOD_ODEX,
    INSTRUCTION_FORMAT3rc_TYPE,
    INSTRUCTION_FORMAT3rmi_METHOD,
    INSTRUCTION_FORMAT3rms_METHOD,
    INSTRUCTION_FORMAT45cc_METHOD,
    INSTRUCTION_FORMAT4rcc_METHOD,
    INSTRUCTION_FORMAT51l,

    DOUBLE_QUOTED_STRING,
    SINGLE_QUOTED_STRING,
    LINE_COMMENT,

    IDENTIFIER,
    WHITESPACE,
    BAD_CHARACTER,
    EOF
}