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

package com.blacksquircle.ui.language.markdown.lexer;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")

/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.8.2
 * from the specification file <tt>markdown.flex</tt>
 */
public class MarkdownLexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\10\u2f00\31\u1f00\1\u0100\1\u3000\1\u3100\1\u0100\1\u3200"+
    "\1\u3300\1\u3400\1\u3500\1\u3600\1\u3700\1\u3800\1\u3900\3\u1f00"+
    "\1\u3a00\1\u3b00\1\u3c00\1\u3d00\1\u3e00\3\u1f00\1\u3f00\1\u4000"+
    "\4\u1f00\1\u4100\11\u1f00\3\u0100\1\u4200\1\u4300\13\u1f00\4\u0100"+
    "\1\u4400\63\u1f00\2\u0100\1\u4500\4\u1f00\1\u4600\100\u1f00\1\u4700"+
    "\40\u1f00\1\u4800\1\u4900\1\u1f00\1\u4a00\1\u4b00\1\u4c00\1\u4d00"+
    "\26\u1f00\1\u4e00\21\u1f00\246\u0100\1\u4f00\20\u0100\1\u5000\1\u5100"+
    "\77\u1f00\2\u0100\1\u5100\u0b05\u1f00\1\u5200\1\u5300\u02fe\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\4\1\5\16\0\4\6"+
    "\1\7\1\10\1\6\1\11\1\12\3\13\1\14\1\15"+
    "\1\16\1\17\1\13\1\20\1\21\1\22\12\23\1\24"+
    "\1\13\1\25\1\26\1\27\2\13\32\12\1\30\1\31"+
    "\1\32\1\6\1\33\1\34\4\12\1\35\1\36\1\12"+
    "\1\37\1\40\2\12\1\41\3\12\1\42\2\12\1\43"+
    "\1\44\2\12\1\45\3\12\1\46\1\6\1\47\1\50"+
    "\6\0\1\51\32\0\2\6\4\52\4\6\1\52\2\6"+
    "\1\0\7\6\1\52\4\6\1\52\5\6\27\52\1\6"+
    "\37\52\1\6\u01ca\52\4\6\14\52\16\6\5\52\7\6"+
    "\1\52\1\6\1\52\21\6\160\0\5\52\1\6\2\52"+
    "\2\6\4\52\10\6\1\52\1\6\3\52\1\6\1\52"+
    "\1\6\24\52\1\6\123\52\1\6\213\52\1\6\5\0"+
    "\2\6\236\52\11\6\46\52\2\6\1\52\7\6\47\52"+
    "\7\6\1\52\1\6\55\0\1\6\1\0\1\6\2\0"+
    "\1\6\2\0\1\6\1\0\10\6\33\52\5\6\3\52"+
    "\15\6\5\0\6\6\1\52\4\6\13\0\5\6\53\52"+
    "\37\0\4\6\2\52\1\0\143\52\1\6\1\52\10\0"+
    "\1\6\6\0\2\52\2\0\1\6\4\0\2\52\12\0"+
    "\3\52\2\6\1\52\17\6\1\0\1\52\1\0\36\52"+
    "\33\0\2\6\131\52\13\0\1\52\16\6\12\0\41\52"+
    "\11\0\2\52\4\6\1\52\5\6\26\52\4\0\1\52"+
    "\11\0\1\52\3\0\1\52\5\0\22\6\31\52\3\0"+
    "\104\6\1\52\1\6\13\52\67\6\33\0\1\6\4\0"+
    "\66\52\3\0\1\52\22\0\1\52\7\0\12\52\2\0"+
    "\2\6\12\0\1\6\7\52\1\6\7\52\1\6\3\0"+
    "\1\6\10\52\2\6\2\52\2\6\26\52\1\6\7\52"+
    "\1\6\1\52\3\6\4\52\2\6\1\0\1\52\7\0"+
    "\2\6\2\0\2\6\3\0\1\52\10\6\1\0\4\6"+
    "\2\52\1\6\3\52\2\0\2\6\12\0\4\52\7\6"+
    "\1\52\5\6\3\0\1\6\6\52\4\6\2\52\2\6"+
    "\26\52\1\6\7\52\1\6\2\52\1\6\2\52\1\6"+
    "\2\52\2\6\1\0\1\6\5\0\4\6\2\0\2\6"+
    "\3\0\3\6\1\0\7\6\4\52\1\6\1\52\7\6"+
    "\14\0\3\52\1\0\13\6\3\0\1\6\11\52\1\6"+
    "\3\52\1\6\26\52\1\6\7\52\1\6\2\52\1\6"+
    "\5\52\2\6\1\0\1\52\10\0\1\6\3\0\1\6"+
    "\3\0\2\6\1\52\17\6\2\52\2\0\2\6\12\0"+
    "\1\6\1\52\17\6\3\0\1\6\10\52\2\6\2\52"+
    "\2\6\26\52\1\6\7\52\1\6\2\52\1\6\5\52"+
    "\2\6\1\0\1\52\7\0\2\6\2\0\2\6\3\0"+
    "\10\6\2\0\4\6\2\52\1\6\3\52\2\0\2\6"+
    "\12\0\1\6\1\52\20\6\1\0\1\52\1\6\6\52"+
    "\3\6\3\52\1\6\4\52\3\6\2\52\1\6\1\52"+
    "\1\6\2\52\3\6\2\52\3\6\3\52\3\6\14\52"+
    "\4\6\5\0\3\6\3\0\1\6\4\0\2\6\1\52"+
    "\6\6\1\0\16\6\12\0\11\6\1\52\7\6\3\0"+
    "\1\6\10\52\1\6\3\52\1\6\27\52\1\6\12\52"+
    "\1\6\5\52\3\6\1\52\7\0\1\6\3\0\1\6"+
    "\4\0\7\6\2\0\1\6\2\52\6\6\2\52\2\0"+
    "\2\6\12\0\22\6\2\0\1\6\10\52\1\6\3\52"+
    "\1\6\27\52\1\6\12\52\1\6\5\52\2\6\1\0"+
    "\1\52\7\0\1\6\3\0\1\6\4\0\7\6\2\0"+
    "\7\6\1\52\1\6\2\52\2\0\2\6\12\0\1\6"+
    "\2\52\17\6\2\0\1\6\10\52\1\6\3\52\1\6"+
    "\51\52\2\6\1\52\7\0\1\6\3\0\1\6\4\0"+
    "\1\52\10\6\1\0\10\6\2\52\2\0\2\6\12\0"+
    "\12\6\6\52\2\6\2\0\1\6\22\52\3\6\30\52"+
    "\1\6\11\52\1\6\1\52\2\6\7\52\3\6\1\0"+
    "\4\6\6\0\1\6\1\0\1\6\10\0\22\6\2\0"+
    "\15\6\60\52\1\0\2\52\7\0\4\6\10\52\10\0"+
    "\1\6\12\0\47\6\2\52\1\6\1\52\2\6\2\52"+
    "\1\6\1\52\2\6\1\52\6\6\4\52\1\6\7\52"+
    "\1\6\3\52\1\6\1\52\1\6\1\52\2\6\2\52"+
    "\1\6\4\52\1\0\2\52\6\0\1\6\2\0\1\52"+
    "\2\6\5\52\1\6\1\52\1\6\6\0\2\6\12\0"+
    "\2\6\4\52\40\6\1\52\27\6\2\0\6\6\12\0"+
    "\13\6\1\0\1\6\1\0\1\6\1\0\4\6\2\0"+
    "\10\52\1\6\44\52\4\6\24\0\1\6\2\0\5\52"+
    "\13\0\1\6\44\0\11\6\1\0\71\6\53\52\24\0"+
    "\1\52\12\0\6\6\6\52\4\0\4\52\3\0\1\52"+
    "\3\0\2\52\7\0\3\52\4\0\15\52\14\0\1\52"+
    "\17\0\2\6\46\52\1\6\1\52\5\6\1\52\2\6"+
    "\53\52\1\6\115\52\1\6\4\52\2\6\7\52\1\6"+
    "\1\52\1\6\4\52\2\6\51\52\1\6\4\52\2\6"+
    "\41\52\1\6\4\52\2\6\7\52\1\6\1\52\1\6"+
    "\4\52\2\6\17\52\1\6\71\52\1\6\4\52\2\6"+
    "\103\52\2\6\3\0\40\6\20\52\20\6\125\52\14\6"+
    "\u016c\52\2\6\21\52\1\6\32\52\5\6\113\52\3\6"+
    "\3\52\17\6\15\52\1\6\4\52\3\0\13\6\22\52"+
    "\3\0\13\6\22\52\2\0\14\6\15\52\1\6\3\52"+
    "\1\6\2\0\14\6\64\52\40\0\3\6\1\52\3\6"+
    "\2\52\1\0\2\6\12\0\41\6\3\0\2\6\12\0"+
    "\6\6\130\52\10\6\51\52\1\0\1\52\5\6\106\52"+
    "\12\6\35\52\3\6\14\0\4\6\14\0\12\6\12\0"+
    "\36\52\2\6\5\52\13\6\54\52\4\6\21\0\7\52"+
    "\2\0\6\6\12\0\46\6\27\52\5\0\4\6\65\52"+
    "\12\0\1\6\35\0\2\6\13\0\6\6\12\0\15\6"+
    "\1\52\130\6\5\0\57\52\21\0\7\52\4\6\12\0"+
    "\21\6\11\0\14\6\3\0\36\52\15\0\2\52\12\0"+
    "\54\52\16\0\14\6\44\52\24\0\10\6\12\0\3\6"+
    "\3\52\12\0\44\52\122\6\3\0\1\6\25\0\4\52"+
    "\1\0\4\52\3\0\2\52\11\6\300\52\47\0\25\6"+
    "\4\0\26\52\2\6\6\52\2\6\46\52\2\6\6\52"+
    "\2\6\10\52\1\6\1\52\1\6\1\52\1\6\1\52"+
    "\1\6\37\52\2\6\65\52\1\6\7\52\1\6\1\52"+
    "\3\6\3\52\1\6\7\52\3\6\4\52\2\6\6\52"+
    "\4\6\15\52\5\6\3\52\1\6\7\52\16\6\5\0"+
    "\30\6\2\3\5\0\20\6\2\52\23\6\1\52\13\6"+
    "\5\0\5\6\6\0\1\6\1\52\15\6\1\52\20\6"+
    "\15\52\3\6\33\52\25\6\15\0\4\6\1\0\3\6"+
    "\14\0\21\6\1\52\4\6\1\52\2\6\12\52\1\6"+
    "\1\52\3\6\5\52\6\6\1\52\1\6\1\52\1\6"+
    "\1\52\1\6\4\52\1\6\13\52\2\6\4\52\5\6"+
    "\5\52\4\6\1\52\21\6\51\52\u0177\6\57\52\1\6"+
    "\57\52\1\6\205\52\6\6\4\52\3\0\2\52\14\6"+
    "\46\52\1\6\1\52\5\6\1\52\2\6\70\52\7\6"+
    "\1\52\17\6\1\0\27\52\11\6\7\52\1\6\7\52"+
    "\1\6\7\52\1\6\7\52\1\6\7\52\1\6\7\52"+
    "\1\6\7\52\1\6\7\52\1\6\40\0\57\6\1\52"+
    "\325\6\3\52\31\6\11\52\6\0\1\6\5\52\2\6"+
    "\5\52\4\6\126\52\2\6\2\0\2\6\3\52\1\6"+
    "\132\52\1\6\4\52\5\6\51\52\3\6\136\52\21\6"+
    "\33\52\65\6\306\52\112\6\315\52\63\6\215\52\103\6"+
    "\56\52\2\6\15\52\3\6\20\52\12\0\2\52\24\6"+
    "\57\52\1\0\4\6\12\0\1\6\31\52\7\6\1\0"+
    "\120\52\2\0\45\6\11\52\2\6\147\52\2\6\4\52"+
    "\1\6\4\52\14\6\13\52\115\6\12\52\1\0\3\52"+
    "\1\0\4\52\1\0\27\52\5\0\20\6\1\52\7\6"+
    "\64\52\14\6\2\0\62\52\21\0\13\6\12\0\6\6"+
    "\22\0\6\52\3\6\1\52\4\6\12\0\34\52\10\0"+
    "\2\6\27\52\15\0\14\6\35\52\3\6\4\0\57\52"+
    "\16\0\16\6\1\52\12\0\46\6\51\52\16\0\11\6"+
    "\3\52\1\0\10\52\2\0\2\6\12\0\6\6\27\52"+
    "\3\6\1\52\1\0\4\6\60\52\1\0\1\52\3\0"+
    "\2\52\2\0\5\52\2\0\1\52\1\0\1\52\30\6"+
    "\3\52\2\6\13\52\5\0\2\6\3\52\2\0\12\6"+
    "\6\52\2\6\6\52\2\6\6\52\11\6\7\52\1\6"+
    "\7\52\221\6\43\52\10\0\1\6\2\0\2\6\12\0"+
    "\6\6\244\52\14\6\27\52\4\6\61\52\4\6\u0100\53"+
    "\156\52\2\6\152\52\46\6\7\52\14\6\5\52\5\6"+
    "\1\52\1\0\12\52\1\6\15\52\1\6\5\52\1\6"+
    "\1\52\1\6\2\52\1\6\2\52\1\6\154\52\41\6"+
    "\153\52\22\6\100\52\2\6\66\52\50\6\15\52\3\6"+
    "\20\0\20\6\7\0\14\6\2\52\30\6\3\52\31\6"+
    "\1\52\6\6\5\52\1\6\207\52\2\6\1\0\4\6"+
    "\1\52\13\6\12\0\7\6\32\52\4\6\1\52\1\6"+
    "\32\52\13\6\131\52\3\6\6\52\2\6\6\52\2\6"+
    "\6\52\2\6\3\52\3\6\2\52\3\6\2\52\22\6"+
    "\3\0\4\6\14\52\1\6\32\52\1\6\23\52\1\6"+
    "\2\52\1\6\17\52\2\6\16\52\42\6\173\52\105\6"+
    "\65\52\210\6\1\0\202\6\35\52\3\6\61\52\57\6"+
    "\37\52\21\6\33\52\65\6\36\52\2\6\44\52\4\6"+
    "\10\52\1\6\5\52\52\6\236\52\2\6\12\0\126\6"+
    "\6\52\2\6\1\52\1\6\54\52\1\6\2\52\3\6"+
    "\1\52\2\6\27\52\252\6\26\52\12\6\32\52\106\6"+
    "\70\52\6\6\2\52\100\6\1\52\3\0\1\6\2\0"+
    "\5\6\4\0\4\52\1\6\3\52\1\6\33\52\4\6"+
    "\3\0\4\6\1\0\40\6\35\52\203\6\66\52\12\6"+
    "\26\52\12\6\23\52\215\6\111\52\267\6\3\0\65\52"+
    "\17\0\37\6\12\0\20\6\3\0\55\52\13\0\2\6"+
    "\1\0\22\6\31\52\7\6\12\0\6\6\3\0\44\52"+
    "\16\0\1\6\12\0\100\6\3\0\60\52\16\0\4\52"+
    "\13\6\12\0\246\6\53\52\15\0\10\6\12\0\66\6"+
    "\157\52\221\6\143\52\235\6\57\52\321\6\71\52\307\6"+
    "\105\52\13\6\1\52\56\0\20\6\4\0\15\52\140\6"+
    "\2\52\u0163\6\5\0\3\6\26\0\2\6\7\0\36\6"+
    "\4\0\224\6\3\0\273\6\125\52\1\6\107\52\1\6"+
    "\2\52\2\6\1\52\2\6\2\52\2\6\4\52\1\6"+
    "\14\52\1\6\1\52\1\6\7\52\1\6\101\52\1\6"+
    "\4\52\2\6\10\52\1\6\7\52\1\6\34\52\1\6"+
    "\4\52\1\6\5\52\1\6\1\52\3\6\7\52\1\6"+
    "\u0154\52\2\6\31\52\1\6\31\52\1\6\37\52\1\6"+
    "\31\52\1\6\37\52\1\6\31\52\1\6\37\52\1\6"+
    "\31\52\1\6\37\52\1\6\31\52\1\6\10\52\2\6"+
    "\62\0\4\52\1\6\33\52\1\6\2\52\1\6\1\52"+
    "\2\6\1\52\1\6\12\52\1\6\4\52\1\6\1\52"+
    "\1\6\1\52\6\6\1\52\4\6\1\52\1\6\1\52"+
    "\1\6\1\52\1\6\3\52\1\6\2\52\1\6\1\52"+
    "\2\6\1\52\1\6\1\52\1\6\1\52\1\6\1\52"+
    "\1\6\1\52\1\6\2\52\1\6\1\52\2\6\4\52"+
    "\1\6\7\52\1\6\4\52\1\6\4\52\1\6\1\52"+
    "\1\6\12\52\1\6\21\52\5\6\3\52\1\6\5\52"+
    "\1\6\21\52\104\6\327\52\51\6\65\52\13\6\336\52"+
    "\343\6\1\0\36\6\140\0\200\6\360\0\20\6";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[21504];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\2\1\1\10\1\11\1\1\1\12\1\13\1\14\1\15"+
    "\1\16\1\5\1\1\3\5\1\17\1\20\1\1\1\0"+
    "\1\21\1\22\1\0\1\21\2\0\1\5\2\0\1\23"+
    "\2\0\1\24\4\5\1\0\1\22\1\21\5\0\1\25"+
    "\2\23\2\0\1\5\2\0\1\5\1\24\3\0\4\5"+
    "\4\0\1\26\3\0\1\5\3\0\1\5\2\0\1\27"+
    "\2\0\1\5\1\30\2\0\1\31\1\26\4\0\2\27"+
    "\1\5\3\0\1\5\3\0\1\32\1\0\1\33\1\34"+
    "\1\33\2\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[115];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\54\0\130\0\54\0\204\0\260\0\54"+
    "\0\54\0\334\0\u0108\0\u0108\0\54\0\u0134\0\54\0\54"+
    "\0\54\0\54\0\54\0\u0160\0\u018c\0\u01b8\0\u01e4\0\u0210"+
    "\0\54\0\54\0\u023c\0\u0268\0\u0294\0\u02c0\0\u02ec\0\u0318"+
    "\0\u0344\0\u0134\0\u0370\0\u039c\0\u03c8\0\u03f4\0\u0420\0\u044c"+
    "\0\u0478\0\u04a4\0\u04d0\0\u04fc\0\u0528\0\u0554\0\54\0\u0580"+
    "\0\u05ac\0\u05d8\0\u0604\0\u0630\0\u065c\0\u0688\0\260\0\54"+
    "\0\u06b4\0\u06e0\0\u070c\0\u0738\0\u0764\0\u0790\0\54\0\u07bc"+
    "\0\u07e8\0\u0814\0\u0840\0\u086c\0\u0898\0\u08c4\0\u08f0\0\u091c"+
    "\0\u0948\0\u0974\0\u09a0\0\u09cc\0\u09f8\0\u0a24\0\u0a50\0\u0a7c"+
    "\0\u0aa8\0\u0ad4\0\u0b00\0\u0b2c\0\u0b58\0\u0b84\0\u0bb0\0\u0bdc"+
    "\0\u0c08\0\u0c34\0\u0c60\0\u0c8c\0\54\0\54\0\u09a0\0\u0cb8"+
    "\0\u0ce4\0\u0d10\0\260\0\54\0\u0b84\0\u0d3c\0\u0d68\0\u0d94"+
    "\0\u0dc0\0\u0dec\0\u0e18\0\u0c34\0\54\0\u0e44\0\260\0\u0e70"+
    "\0\54\0\u0e9c\0\54";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[115];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\2\1\3\1\4\1\2\1\3\1\5"+
    "\1\6\1\7\1\2\1\10\1\11\1\12\1\13\1\14"+
    "\1\2\1\15\1\16\1\2\1\17\1\20\1\21\1\22"+
    "\1\2\1\23\1\24\1\25\1\7\1\26\1\27\5\7"+
    "\1\30\1\31\1\32\1\33\1\2\1\7\1\2\56\0"+
    "\1\3\51\0\2\6\4\0\43\6\1\0\1\6\1\0"+
    "\1\7\11\0\1\7\10\0\1\7\7\0\1\7\1\0"+
    "\11\7\3\0\2\7\1\0\2\34\1\0\2\34\1\0"+
    "\1\34\1\35\6\34\1\36\12\34\1\37\22\34\7\0"+
    "\1\40\65\0\1\41\1\0\1\42\30\0\1\43\1\44"+
    "\1\0\2\44\1\0\4\44\1\43\10\44\1\43\5\44"+
    "\1\45\1\44\1\46\1\44\11\43\3\44\2\43\1\44"+
    "\2\47\1\0\2\47\1\0\23\47\1\50\2\47\1\51"+
    "\17\47\1\7\11\0\1\7\10\0\1\7\7\0\1\7"+
    "\1\0\3\7\1\52\3\7\1\53\1\7\3\0\2\7"+
    "\1\0\1\7\11\0\1\7\10\0\1\7\7\0\1\7"+
    "\1\0\7\7\1\54\1\7\3\0\2\7\1\0\1\7"+
    "\11\0\1\7\10\0\1\7\7\0\1\7\1\0\10\7"+
    "\1\55\3\0\2\7\51\0\1\56\3\0\2\34\1\0"+
    "\2\34\1\0\10\34\1\57\12\34\1\37\22\34\2\35"+
    "\1\0\2\34\1\0\10\35\1\40\12\35\1\60\17\35"+
    "\1\34\1\35\1\34\2\61\1\0\2\61\1\0\10\61"+
    "\1\62\12\61\1\63\22\61\1\0\1\37\2\34\1\64"+
    "\1\65\1\0\1\37\41\0\1\34\2\0\2\40\4\0"+
    "\43\40\1\0\1\40\10\0\1\66\44\0\1\43\1\44"+
    "\1\0\2\44\1\0\4\44\1\43\10\44\1\43\5\44"+
    "\1\45\1\44\1\67\1\44\11\43\3\44\2\43\3\44"+
    "\1\0\2\44\1\0\23\44\1\45\1\44\1\70\20\44"+
    "\1\0\1\45\2\44\1\71\1\72\1\0\1\45\41\0"+
    "\1\44\2\0\1\73\1\74\1\0\2\74\1\0\4\74"+
    "\1\73\10\74\1\73\5\74\1\75\1\74\1\76\1\74"+
    "\11\73\3\74\2\73\1\74\2\47\1\0\2\47\1\0"+
    "\23\47\1\50\2\47\1\77\17\47\1\0\1\50\2\47"+
    "\1\100\1\101\1\0\1\50\41\0\1\47\36\0\1\102"+
    "\17\0\1\7\11\0\1\7\10\0\1\7\7\0\1\7"+
    "\1\0\4\7\1\103\4\7\3\0\2\7\1\0\1\7"+
    "\11\0\1\7\10\0\1\7\7\0\1\7\1\0\5\7"+
    "\1\104\3\7\3\0\2\7\1\0\1\7\11\0\1\7"+
    "\10\0\1\7\7\0\1\7\1\0\7\7\1\105\1\7"+
    "\3\0\2\7\1\0\1\7\11\0\1\7\10\0\1\7"+
    "\7\0\1\7\1\0\10\7\1\106\3\0\2\7\1\0"+
    "\2\56\1\0\2\56\1\0\23\56\1\107\16\56\1\110"+
    "\3\56\1\40\1\60\2\34\1\64\1\65\1\40\1\60"+
    "\41\40\1\34\1\40\1\0\2\61\1\0\2\61\1\0"+
    "\10\61\1\111\12\61\1\63\22\61\2\112\1\0\2\112"+
    "\1\0\10\112\1\113\12\112\1\114\22\112\1\0\1\63"+
    "\2\61\1\115\1\116\1\0\1\63\41\0\1\61\2\0"+
    "\1\34\1\64\2\34\1\64\1\65\1\34\1\64\6\34"+
    "\1\57\12\34\1\37\27\34\1\0\10\34\1\57\12\34"+
    "\1\37\22\34\2\66\4\0\43\66\1\0\1\66\1\0"+
    "\1\44\1\71\2\44\1\71\1\72\1\44\1\71\21\44"+
    "\1\45\1\44\1\70\25\44\1\0\23\44\1\45\1\44"+
    "\1\70\20\44\1\73\1\74\1\0\2\74\1\0\4\74"+
    "\1\73\10\74\1\73\5\74\1\75\1\74\1\117\1\74"+
    "\11\73\3\74\2\73\3\74\1\0\2\74\1\0\23\74"+
    "\1\75\1\74\1\120\20\74\1\0\1\75\2\74\1\121"+
    "\1\122\1\0\1\75\41\0\1\74\2\0\1\123\1\124"+
    "\1\0\2\124\1\0\4\124\1\123\10\124\1\123\5\124"+
    "\1\125\1\124\1\126\1\124\11\123\3\124\2\123\1\124"+
    "\1\47\1\100\2\47\1\100\1\101\1\47\1\100\21\47"+
    "\1\50\2\47\1\77\24\47\1\0\23\47\1\50\2\47"+
    "\1\77\17\47\34\102\1\127\17\102\1\7\11\0\1\7"+
    "\10\0\1\7\7\0\1\7\1\0\1\104\10\7\3\0"+
    "\2\7\1\0\1\7\11\0\1\7\10\0\1\7\1\130"+
    "\6\0\1\7\1\0\11\7\3\0\2\7\1\0\1\7"+
    "\11\0\1\7\10\0\1\7\7\0\1\7\1\0\5\7"+
    "\1\131\3\7\3\0\2\7\1\0\1\7\11\0\1\7"+
    "\6\0\1\132\1\0\1\7\7\0\1\7\1\0\11\7"+
    "\3\0\2\7\2\0\1\107\2\56\1\133\1\134\1\0"+
    "\1\107\41\0\1\56\52\0\1\135\21\0\1\136\35\0"+
    "\2\112\1\0\2\112\1\0\10\112\1\137\12\112\1\114"+
    "\22\112\16\0\1\140\36\0\1\114\2\112\1\141\1\142"+
    "\1\0\1\114\41\0\1\112\2\0\1\61\1\115\2\61"+
    "\1\115\1\116\1\61\1\115\6\61\1\111\12\61\1\63"+
    "\27\61\1\0\10\61\1\111\12\61\1\63\22\61\1\7"+
    "\11\0\1\7\10\0\1\7\7\0\1\143\1\0\11\7"+
    "\3\0\2\7\34\0\1\144\20\0\1\74\1\121\2\74"+
    "\1\121\1\122\1\74\1\121\21\74\1\75\1\74\1\120"+
    "\25\74\1\0\23\74\1\75\1\74\1\120\20\74\1\123"+
    "\1\124\1\0\2\124\1\0\4\124\1\123\10\124\1\123"+
    "\5\124\1\125\1\124\1\145\1\124\11\123\3\124\2\123"+
    "\3\124\1\0\2\124\1\0\23\124\1\125\1\124\1\146"+
    "\20\124\1\0\1\125\2\124\1\147\1\150\1\0\1\125"+
    "\41\0\1\124\2\0\1\7\11\0\1\7\10\0\1\7"+
    "\7\0\1\151\1\0\11\7\3\0\2\7\1\0\34\102"+
    "\1\152\17\102\22\0\1\153\31\0\1\7\11\0\1\7"+
    "\10\0\1\7\1\130\6\0\1\7\1\0\6\7\1\104"+
    "\2\7\3\0\2\7\11\0\2\154\1\132\7\154\2\132"+
    "\1\154\1\0\1\154\1\0\1\154\1\0\2\154\1\0"+
    "\11\132\2\0\1\154\3\0\1\56\1\133\2\56\1\133"+
    "\1\134\1\56\1\133\21\56\1\107\16\56\1\110\10\56"+
    "\1\0\23\56\1\107\16\56\1\110\3\56\16\0\1\155"+
    "\35\0\1\112\1\141\2\112\1\141\1\142\1\112\1\141"+
    "\6\112\1\137\12\112\1\114\27\112\1\0\10\112\1\137"+
    "\12\112\1\114\22\112\33\0\1\156\20\0\1\124\1\147"+
    "\2\124\1\147\1\150\1\124\1\147\21\124\1\125\1\124"+
    "\1\146\25\124\1\0\23\124\1\125\1\124\1\146\20\124"+
    "\1\7\11\0\1\7\10\0\1\7\7\0\1\157\1\0"+
    "\11\7\3\0\2\7\1\0\34\102\1\160\17\102\22\0"+
    "\1\132\64\0\1\161\54\0\1\162\53\0\1\163\17\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3784];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\2\1\2\11\3\1\1\11"+
    "\1\1\5\11\5\1\2\11\1\1\1\0\2\1\1\0"+
    "\1\1\2\0\1\1\2\0\1\1\2\0\5\1\1\0"+
    "\1\11\1\1\5\0\2\1\1\11\2\0\1\1\2\0"+
    "\1\1\1\11\3\0\4\1\4\0\1\1\3\0\1\1"+
    "\3\0\1\1\2\0\1\1\2\0\2\1\2\0\2\11"+
    "\4\0\1\1\1\11\1\1\3\0\1\1\3\0\1\11"+
    "\1\0\2\1\1\11\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[115];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public final int getTokenStart() {
      return (int) yychar;
  }

  public final int getTokenEnd() {
      return getTokenStart() + yylength();
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public MarkdownLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @NotNull
  public MarkdownToken advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
              {
                return MarkdownToken.EOF;
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return MarkdownToken.BAD_CHARACTER;
            }
            // fall through
          case 29: break;
          case 2:
            { return MarkdownToken.WHITESPACE;
            }
            // fall through
          case 30: break;
          case 3:
            { return MarkdownToken.NOT;
            }
            // fall through
          case 31: break;
          case 4:
            { return MarkdownToken.HEADER;
            }
            // fall through
          case 32: break;
          case 5:
            { return MarkdownToken.IDENTIFIER;
            }
            // fall through
          case 33: break;
          case 6:
            { return MarkdownToken.LPAREN;
            }
            // fall through
          case 34: break;
          case 7:
            { return MarkdownToken.RPAREN;
            }
            // fall through
          case 35: break;
          case 8:
            { return MarkdownToken.MINUS;
            }
            // fall through
          case 36: break;
          case 9:
            { return MarkdownToken.DIV;
            }
            // fall through
          case 37: break;
          case 10:
            { return MarkdownToken.LT;
            }
            // fall through
          case 38: break;
          case 11:
            { return MarkdownToken.EQ;
            }
            // fall through
          case 39: break;
          case 12:
            { return MarkdownToken.GT;
            }
            // fall through
          case 40: break;
          case 13:
            { return MarkdownToken.LBRACK;
            }
            // fall through
          case 41: break;
          case 14:
            { return MarkdownToken.RBRACK;
            }
            // fall through
          case 42: break;
          case 15:
            { return MarkdownToken.LBRACE;
            }
            // fall through
          case 43: break;
          case 16:
            { return MarkdownToken.RBRACE;
            }
            // fall through
          case 44: break;
          case 17:
            { return MarkdownToken.UNORDERED_LIST_ITEM;
            }
            // fall through
          case 45: break;
          case 18:
            { return MarkdownToken.ITALIC1;
            }
            // fall through
          case 46: break;
          case 19:
            { return MarkdownToken.ITALIC2;
            }
            // fall through
          case 47: break;
          case 20:
            { return MarkdownToken.CODE;
            }
            // fall through
          case 48: break;
          case 21:
            { return MarkdownToken.ORDERED_LIST_ITEM;
            }
            // fall through
          case 49: break;
          case 22:
            { return MarkdownToken.BOLD1;
            }
            // fall through
          case 50: break;
          case 23:
            { return MarkdownToken.BOLD2;
            }
            // fall through
          case 51: break;
          case 24:
            { return MarkdownToken.URL;
            }
            // fall through
          case 52: break;
          case 25:
            { return MarkdownToken.STRIKETHROUGH;
            }
            // fall through
          case 53: break;
          case 26:
            { return MarkdownToken.BOLDITALIC1;
            }
            // fall through
          case 54: break;
          case 27:
            { return MarkdownToken.BOLDITALIC2;
            }
            // fall through
          case 55: break;
          case 28:
            { return MarkdownToken.CODE_BLOCK;
            }
            // fall through
          case 56: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
