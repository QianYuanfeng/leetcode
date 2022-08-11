package com.leetcode.prac1417;

import java.util.ArrayList;
import java.util.List;

/**
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reformat-the-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reformat {
    public static void main(String[] args) {
        String s = "a0b1c2";
        String s1 = "covid2019";
        String reformat = reformat(s1);
        System.out.println(reformat);

    }

    public static String reformat(String s) {
        List<Character> stringList = new ArrayList<>();
        List<Character> digitList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                stringList.add(c);
            }
            if (c >= '0' && c <= '9') {
                digitList.add(c);
            }
        }
        if ((stringList.size() - digitList.size()) <= 1 && (stringList.size() - digitList.size()) >= 0) {
            int index1 = 0;
            int index2 = 0;
            while (index1 < stringList.size()) {
                stringBuilder.append(stringList.get(index1));
                index1++;
                if (index2 < digitList.size()) {
                    stringBuilder.append(digitList.get(index2));
                    index2++;
                }

            }

        } else if ((stringList.size() - digitList.size()) >= -1 && (stringList.size() - digitList.size()) < 0) {
            int index1 = 0;
            int index2 = 0;
            while (index2 < digitList.size()) {
                stringBuilder.append(digitList.get(index2));
                index2++;
                if (index1 < stringList.size()) {
                    stringBuilder.append(stringList.get(index1));
                    index1++;
                }

            }

        } else {
            return "";
        }

        return stringBuilder.toString();
    }

}
