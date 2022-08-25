package com.offersecond.prac005;

public class maxProduct {

    public static void main(String[] args) {
        String[] words = new String[]{"abcz"};
        maxProduct(words);
    }

    public static int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[words.length];
//        mask[0] = 0 ;初始化默认就是0
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                //位运算，1左移位数，代表 1后面加上几位0
                //或 , 只要有1 就为1
                mask[i] = mask[i] | (1 << (word.charAt(j) - 'a'));

            }
        }
        int maxCore = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    maxCore = Math.max(maxCore, (words[i].length() * words[j].length()));
                }
            }
        }
        return maxCore;
    }

}
