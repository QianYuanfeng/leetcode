package com.leetcode.prac14;

import java.util.Arrays;

/**
 *14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println("输入：" + Arrays.asList(strs) + "；输出：" + longestCommonPrefix);
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String strInit = strs[0];
        for (int i = 1; i < strs.length; i++) {
            strInit = findCommonPrefix(strInit, strs[i]);
            //如果得到的公共前缀为空，可以直接返回空值。
            if (strInit.length() == 0) {
                break;
            }
        }
        return strInit;
    }

    public static String findCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int index = 0;
        //String.charAt()方法返回指定索引处的char值。索引范围是从0到length() - 1。
        while (index < minLength && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }



}
