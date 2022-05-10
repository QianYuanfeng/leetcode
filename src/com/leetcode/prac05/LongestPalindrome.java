package com.leetcode.prac05;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        //1.暴力解法
        String s1 = longestPalindromeViolence(s);
        System.out.println("暴力解法结果:" + s1);

        //2.中心扩散法

        String s2 = longestPalindromeCenter(s);
        System.out.println("中心扩散法结果:" + s2);

        //3.动态规划




    }

    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindromeCenter(String s) {
        if (s.length() == 1) {
            return s;
        }

        int palindromeLength = 0;
        int beginIndex = 0;
        String palindrome = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {

            int oddLength = checkPalindromeCenter(charArray, i, i);
            int evenLength = checkPalindromeCenter(charArray, i, i + 1);

            if (oddLength > palindromeLength) {
                palindromeLength = oddLength;
                beginIndex = i;
            }

            if (evenLength > palindromeLength) {
                palindromeLength = evenLength;
                beginIndex = i;
            }
        }
        int start = beginIndex - (palindromeLength - 1) / 2;
        palindrome = s.substring(start, start + palindromeLength);

        if (palindromeLength == 0) {
            return s.substring(0, 1);
        }

        return palindrome;

    }


    public static int checkPalindromeCenter(char[] charArray, int left, int right) {
        int length = charArray.length;

        int result = 0;

        int i = left;
        int j = right;
        while (i >= 0 && j < length) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }

        }
        //跳出循环时，i和j是不满足条件的情况，所以回文长度需要再减去2
        result = j - i + 1 - 2;
        return result;

    }


    /**
     * 暴力解法
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(1)
     *
     * @param s
     * @return
     */
    public static String longestPalindromeViolence(String s) {
        if (s.length() == 1) {
            return s;
        }

        int palindromeLength = 0;
        String palindrome = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (checkPalindrome(charArray, i, j) && palindromeLength <= j - i) {
                    //长度
                    palindromeLength = j - i + 1;
                    palindrome = s.substring(i, j + 1);
                }

            }
        }
        if (palindromeLength == 0) {
            return s.substring(0, 1);
        }

        return palindrome;

    }


    public static Boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }


}
