package com.leetcode.prac1422;

/**
 * 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即左 子字符串和 右 子字符串）所能获得的最大得分。
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-score-after-splitting-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxScore {

    public static void main(String[] args) {
        String s = "011101";
        int i = maxScore(s);
        System.out.println(i);

    }

    public static int maxScore(String s) {

        int maxCore = 0;
        for (int i = 1; i < s.length(); i++) {
            int score = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    score++;
                }
            }
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    score++;
                }
            }
            maxCore = Math.max(maxCore, score);

        }

        return maxCore;

    }


}
