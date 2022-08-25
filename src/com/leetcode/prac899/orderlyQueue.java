package com.leetcode.prac899;

import java.util.Arrays;

/**
 *
 */
public class orderlyQueue {

    public static void main(String[] args) {
        String s = "baaca";
        int k = 3;
        System.out.println(orderlyQueue(s, k));
    }

    public static String orderlyQueue(String s, int k) {
        if (k == 1) {
            String str = s;
            for (int i = 1; i < s.length(); i++) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(str) < 0) {
                    str = t;
                }
            }
            return str;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }

    }


    public static String orderlyQueue2(String s, int k) {
        if (k == 1) {
            //最小表示法
            char[] cs = s.toCharArray();
            int i = 0, j = 1, h = 0, n = cs.length;
            while (i < n && j < n && h < n) {
                char a = cs[(i + h) % n];
                char b = cs[(j + h) % n];
                if (a == b) {
                    h++;
                } else {
                    if (a > b) {
                        i += h + 1;
                    } else {
                        j += h + 1;
                    }
                    if (i == j) i++;
                    h = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);


        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }

    }

}
