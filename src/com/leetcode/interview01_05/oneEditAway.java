package com.leetcode.interview01_05;

/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class oneEditAway {

    public static void main(String[] args) {
        String first = "pales";
        String second = "pal";
        boolean b = oneEditAway(first, second);
        System.out.println("b:" + b);
    }

    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        if (first.equalsIgnoreCase(second)) {
            return true;
        }

        int firstIndex = 0;
        int secondIndex = 0;
        int times = 0;
        if (first.length() == second.length()) {
            while (firstIndex < first.length() && secondIndex < second.length()) {
                if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                    times++;
                }
                firstIndex++;
                secondIndex++;
            }
        } else if (first.length() < second.length()) {
            while (firstIndex < first.length() && secondIndex < second.length()) {
                if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                    times++;
                    secondIndex++;
                } else {
                    firstIndex++;
                    secondIndex++;
                }

            }
        } else if (first.length() > second.length()) {
            while (firstIndex < first.length() && secondIndex < second.length()) {
                if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                    times++;
                    firstIndex++;
                } else {
                    firstIndex++;
                    secondIndex++;
                }

            }
        }


        if (times > 1) {
            return false;
        }

        return true;
    }

}
