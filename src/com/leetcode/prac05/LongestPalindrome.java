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
        int endIndex = 0;
        String palindrome = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {

            int oddLength = checkPalindromeCenter(charArray, i, i);
            int evenLength = checkPalindromeCenter(charArray, i, i + 1);

            if (oddLength > palindromeLength) {
                palindromeLength = oddLength;
                beginIndex = i;
                endIndex = i;
            }

            if (evenLength > palindromeLength) {
                palindromeLength = evenLength;
                beginIndex = i;
                endIndex = i + 1;
            }
        }
        int start = beginIndex - (palindromeLength - 1) / 2;
        int end = endIndex + (palindromeLength - 1) / 2;
        palindrome = s.substring(start, end + 1);

        if (palindromeLength == 0) {
            return s.substring(0, 1);
        }

        return palindrome;

    }


    public static int checkPalindromeCenter(char[] charArray, int left, int right) {
        int length = charArray.length;
        Boolean flag = true;
        int result = 0;

        //中心位是一个数
        if (left == right) {
            while (left <= right && flag) {
                if (left - 1 >= 0 && right + 1 < length) {
                    left--;
                    right++;
                    flag = checkPalindrome(charArray, left, right);
                    if (flag) {
                        result = right - left + 1;
                    }

                } else {
                    break;
                }
            }
        } else {
            //中心位是两个数
            if (charArray[left] == charArray[right]) {
                result = 2;
            }
            while (left < right && checkPalindrome(charArray, left, right) && flag) {
                if (left - 1 >= 0 && right + 1 < length && flag) {
                    left--;
                    right++;
                    flag = checkPalindrome(charArray, left, right);
                    if (flag) {
                        result = right - left + 1;
                    }
                } else {

                    break;
                }
            }
        }
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
