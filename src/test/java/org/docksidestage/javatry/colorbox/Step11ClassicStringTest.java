/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.colorbox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.docksidestage.bizfw.colorbox.ColorBox;
import org.docksidestage.bizfw.colorbox.color.BoxColor;
import org.docksidestage.bizfw.colorbox.space.BoxSpace;
import org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of String with color-box, not using Stream API. <br>
 * Show answer by log() for question of javadoc. <br>
 * <pre>
 * addition:
 * o e.g. "string in color-boxes" means String-type content in space of color-box
 * o don't fix the YourPrivateRoom class and color-box classes
 * </pre>
 * @author jflute
 * @author your_name_here
 */
public class Step11ClassicStringTest extends PlainTestCase {

    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * How many lengths does color name of first color-boxes have? <br>
     * (最初のカラーボックスの色の名前の文字数は？)
     */
    public void test_length_basic() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        if (!colorBoxList.isEmpty()) {
            ColorBox colorBox = colorBoxList.get(0);
            BoxColor boxColor = colorBox.getColor();
            String colorName = boxColor.getColorName();
            int answer = colorName.length();
            log(answer + " (" + colorName + ")"); // also show name for visual check
        } else {
            log("*not found");
        }
    }

    /**
     * Which string has max length in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長い文字列は？)
     */
    public void test_length_findMax() {
        Integer maxLength = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final int length = ((String) content).length();
                    if (maxLength == null || length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        log(maxLength);
    }

    /**
     * How many characters are difference between max and min length of string in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？)
     */
    public void test_length_findMaxMinDiff() {
        Integer maxLength = null;
        Integer minLength = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final int length = ((String) content).length();
                    if (minLength == null || length < minLength) {
                        minLength = length;
                    }
                    if (maxLength == null || length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        log(maxLength - minLength);
    }

    /**
     * Which value (toString() if non-string) has second-max length in color-boxes? (without sort) <br>
     * (カラーボックスに入ってる値 (文字列以外はtoString()) の中で、二番目に長い文字列は？ (ソートなしで))
     */
    public void test_length_findSecondMax() {
        String maxLengthStr = null;
        String secondLengthStr = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    final int length = contentStr.length();
                    if (maxLengthStr == null) {
                        maxLengthStr = contentStr;
                        continue;
                    }
                    if (secondLengthStr == null && maxLengthStr.length() > length) {
                        secondLengthStr = contentStr;
                        continue;
                    }
                    if (secondLengthStr == null && maxLengthStr.length() <= length) {
                        secondLengthStr = maxLengthStr;
                        maxLengthStr = contentStr;
                        continue;
                    }
                    if (maxLengthStr.length() < length) {
                        secondLengthStr = maxLengthStr;
                        maxLengthStr = contentStr;
                        continue;
                    }
                    if (secondLengthStr.length() < length) {
                        secondLengthStr = contentStr;
                        continue;
                    }
                }
            }
        }
        log(maxLengthStr);
        log(secondLengthStr);
    }

    /**
     * How many total lengths of strings in color-boxes? <br>
     * (カラーボックスに入ってる文字列の長さの合計は？)
     */
    public void test_length_calculateLengthSum() {
        int allLength = 0;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final int length = ((String) content).length();
                    allLength = allLength + length;
                }
            }
        }
        log(allLength);
    }

    /**
     * Which color name has max length in color-boxes? <br>
     * (カラーボックスの中で、色の名前が一番長いものは？)
     */
    public void test_length_findMaxColorSize() {
        String maxLengthColor = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            BoxColor color = colorBox.getColor();
            String colorName = color.getColorName();
            if (maxLengthColor == null || maxLengthColor.length() < colorName.length()) {
                maxLengthColor = colorName;
            }
        }
        log(maxLengthColor);
    }

    // ===================================================================================
    //                                                            startsWith(), endsWith()
    //                                                            ========================
    /**
     * What is color in the color-box that has string starting with "Water"? <br>
     * ("Water" で始まる文字列をしまっているカラーボックスの色は？)
     */
    public void test_startsWith_findFirstWord() {
        List<BoxColor> boxColors = new ArrayList<>();
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    if (contentStr.startsWith("Water")) {
                        boxColors.add(colorBox.getColor());
                    }
                }
            }
        }
        log(boxColors);
    }

    /**
     * What is color in the color-box that has string ending with "front"? <br>
     * ("front" で終わる文字列をしまっているカラーボックスの色は？)
     */
    public void test_endsWith_findLastWord() {
        List<BoxColor> boxColors = new ArrayList<>();
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    if (contentStr.endsWith("front")) {
                        boxColors.add(colorBox.getColor());
                    }
                }
            }
        }
        log(boxColors);
    }

    // ===================================================================================
    //                                                            indexOf(), lastIndexOf()
    //                                                            ========================
    /**
     * What number character is starting with first "front" of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列で、最初の "front" は何文字目から始まる？)
     */
    public void test_indexOf_findIndex() {
        Integer resultNumber = null;
        String resultStr = null;
        final String TARGET = "front";
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    if (contentStr.endsWith(TARGET)) {
                        resultNumber = contentStr.indexOf(TARGET);
                        resultStr = contentStr;
                    }
                }
            }
        }
        log(resultNumber);
        log(resultStr);
    }

    /**
     * What number character is starting with the late "ど" of string containing plural "ど"s in color-boxes? (e.g. "どんどん" => 3) <br>
     * (カラーボックスに入ってる「ど」を二つ以上含む文字列で、最後の「ど」は何文字目から始まる？ (e.g. "どんどん" => 3))
     */
    public void test_lastIndexOf_findIndex() {
        Integer resultNumber = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    final int count = contentStr.split("ど").length;
                    if (count >= 2) {
                        contentStr.lastIndexOf("ど");
                    }
                }
            }
        }
        log(resultNumber);
    }

    // ===================================================================================
    //                                                                         substring()
    //                                                                         ===========
    /**
     * What character is first of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列の最初の一文字は？)
     */
    public void test_substring_findFirstChar() {
        String result = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    if (contentStr.endsWith("front")) {
                        result = contentStr.substring(0, 1);
                    }
                }
            }
        }
        log(result);
    }

    /**
     * What character is last of string starting with "Water" in color-boxes? <br>
     * (カラーボックスに入ってる "Water" で始まる文字列の最後の一文字は？)
     */
    public void test_substring_findLastChar() {
        String result = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    if (contentStr.startsWith("Water")) {
                        result = contentStr.substring(contentStr.length() - 1);
                    }
                }
            }
        }
        log(result);
    }

    // ===================================================================================
    //                                                                           replace()
    //                                                                           =========
    /**
     * How many characters does string that contains "o" in color-boxes and removing "o" have? <br>
     * (カラーボックスに入ってる "o" (おー) を含んだ文字列から "o" を全て除去したら何文字？)
     */
    public void test_replace_remove_o() {
        Integer result = null;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    final String contentStr = (String) content;
                    if (contentStr.contains("o")) {
                        result = contentStr.replaceAll("o", "").length();
                    }
                }
            }
        }
        log(result);
    }

    /**
     * What string is path string of java.io.File in color-boxes, which is replaced with "/" to Windows file separator? <br>
     * カラーボックスに入ってる java.io.File のパス文字列のファイルセパレーターの "/" を、Windowsのファイルセパレーターに置き換えた文字列は？
     */
    public void test_replace_fileseparator() {
        List<String> results = new ArrayList<>();
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof File) {
                    final String path = ((File) content).getPath();
                    results.add(path.replaceAll("/", "\\\\"));
                }
            }
        }
        log(results);
    }

    // ===================================================================================
    //                                                                    Welcome to Devil
    //                                                                    ================
    /**
     * What is total length of text of DevilBox class in color-boxes? <br>
     * (カラーボックスの中に入っているDevilBoxクラスのtextの長さの合計は？)
     */
    public void test_welcomeToDevil() {
        int result = 0;
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object content = boxSpace.getContent();
                if (content instanceof YourPrivateRoom.DevilBox) {
                    YourPrivateRoom.DevilBox devilBox = (YourPrivateRoom.DevilBox) content;
                    devilBox.wakeUp();
                    devilBox.allowMe();
                    devilBox.open();
                    try {
                        String text = devilBox.getText();
                        result = result + text.length();
                    } catch (YourPrivateRoom.DevilBoxTextNotFoundException e) {
                        continue;
                    }

                }
            }
        }
        log(result);
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * What string is converted to style "map:{ key = value ; key = value ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = value ; ... }" という形式で表示すると？)
     */
    public void test_showMap_flat() {
    }

    /**
     * What string is converted to style "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" という形式で表示すると？)
     */
    public void test_showMap_nested() {
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * What string of toString() is converted from text of SecretBox class in upper space on the "white" color-box to java.util.Map? <br>
     * (whiteのカラーボックスのupperスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
     */
    public void test_parseMap_flat() {
    }

    /**
     * What string of toString() is converted from text of SecretBox class in both middle and lower spaces on the "white" color-box to java.util.Map? <br>
     * (whiteのカラーボックスのmiddleおよびlowerスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
     */
    public void test_parseMap_nested() {
    }
}
