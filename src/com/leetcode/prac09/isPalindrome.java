package com.leetcode.prac09;

public class isPalindrome {
    public static void main(String[] args) {
        int x = 10;
        boolean palindromeFlag = isPalindrome(x);
        System.out.println("palindromeFlag :" + palindromeFlag);
    }

    public static boolean isPalindrome(int x) {
        Boolean flag = true;

        String str = String.valueOf(x);
        char[] strArray = str.toCharArray();
        int length = strArray.length;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            if (strArray[left] == strArray[right]) {
                left++;
                right--;
            } else {
                flag = false;
                break;
            }
        }


        return flag;
    }
}
