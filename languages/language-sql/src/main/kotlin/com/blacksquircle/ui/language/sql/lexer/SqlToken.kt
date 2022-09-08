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

package com.blacksquircle.ui.language.sql.lexer

enum class SqlToken {
    INTEGER_LITERAL,
    FLOAT_LITERAL,
    DOUBLE_LITERAL,

    ADD,
    ALL,
    ALTER,
    AND,
    ANY,
    AS,
    ASC,
    AUTOINCREMENT,
    AVA,
    BETWEEN,
    BINARY,
    BIT,
    BLOB,
    BOOLEAN,
    BY,
    BYTE,
    CHAR,
    CHARACTER,
    COLUMN,
    CONSTRAINT,
    COUNT,
    COUNTER,
    CREATE,
    CURRENCY,
    DATABASE,
    DATE,
    DATETIME,
    DELETE,
    DESC,
    DISALLOW,
    DISTINCT,
    DISTINCTROW,
    DOUBLE,
    DROP,
    EXISTS,
    FLOAT,
    FLOAT4,
    FLOAT8,
    FOREIGN,
    FROM,
    GENERAL,
    GROUP,
    GUID,
    HAVING,
    INNER,
    INSERT,
    IGNORE,
    IF,
    IMP,
    IN,
    INDEX,
    INT,
    INTEGER,
    INTEGER1,
    INTEGER2,
    INTEGER4,
    INTO,
    IS,
    JOIN,
    KEY,
    LEFT,
    LEVEL,
    LIKE,
    LOGICAL,
    LONG,
    LONGBINARY,
    LONGTEXT,
    MAX,
    MEMO,
    MIN,
    MOD,
    MONEY,
    NOT,
    NULL,
    NUMBER,
    NUMERIC,
    OLEOBJECT,
    ON,
    OPTION,
    OR,
    ORDER,
    OUTER,
    OWNERACCESS,
    PARAMETERS,
    PASSWORD,
    PERCENT,
    PIVOT,
    PRIMARY,
    REAL,
    REFERENCES,
    RIGHT,
    SELECT,
    SET,
    SHORT,
    SINGLE,
    SMALLINT,
    SOME,
    STDEV,
    STDEVP,
    STRING,
    SUM,
    TABLE,
    TABLEID,
    TEXT,
    TIME,
    TIMESTAMP,
    TOP,
    TRANSFORM,
    TYPE,
    UNION,
    UNIQUE,
    UPDATE,
    USER,
    VALUE,
    VALUES,
    VAR,
    VARBINARY,
    VARCHAR,
    VARP,
    VIEW,
    WHERE,
    WITH,
    YESNO,
    AVG,
    CURRENT_DATE,
    CURRENT_TIME,
    CURRENT_TIMESTAMP,
    CURRENT_USER,
    SESSION_USER,
    SYSTEM_USER,
    BIT_LENGTH,
    CHAR_LENGTH,
    EXTRACT,
    OCTET_LENGTH,
    POSITION,
    CONCATENATE,
    CONVERT,
    LOWER,
    SUBSTRING,
    TRANSLATE,
    TRIM,
    UPPER,

    GTEQ,
    LTEQ,
    LTGT,
    GT,
    LT,
    EQ,
    PLUS,
    MINUS,
    MULT,
    DIV,
    BACKTICK,

    LPAREN,
    RPAREN,
    LBRACK,
    RBRACK,
    SEMICOLON,
    COMMA,
    DOT,

    DOUBLE_QUOTED_STRING,
    SINGLE_QUOTED_STRING,

    LINE_COMMENT,
    BLOCK_COMMENT,

    IDENTIFIER,
    WHITESPACE,
    BAD_CHARACTER,
    EOF
}