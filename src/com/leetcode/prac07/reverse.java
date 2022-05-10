package com.leetcode.prac07;

import java.math.BigDecimal;

public class reverse {
    public static void main(String[] args) {
        int x = 1534236469;
        int reverse = reverse(x);
        System.out.println("x:" + x + ";reverse:" + reverse);
    }

    public static int reverse(int x) {
        int result = 0;

        StringBuffer str = new StringBuffer();

        char[] xArray = String.valueOf(x).toCharArray();
        for (int i = xArray.length - 1; i > 0; i--) {
            str.append(xArray[i]);
        }
        if ("-".equalsIgnoreCase(String.valueOf(xArray[0]))) {
            str = new StringBuffer("-").append(str);
        } else {
            str.append(xArray[0]);
        }


        try {
            result = Integer.valueOf(String.valueOf(str));
        } catch (Exception e) {
            return  0 ;
        }

        return result;
    }
}
