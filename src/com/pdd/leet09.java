package com.pdd;

/**
 * https://leetcode.cn/problems/palindrome-number/
 */
public class leet09 {

    public boolean isPalid(int x) {
        String str = String.valueOf(x);
        int leftIndex = 0;
        int rightIndex = str.length() - 1;

        while (leftIndex < rightIndex) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;

        }
        return true;

    }
}
