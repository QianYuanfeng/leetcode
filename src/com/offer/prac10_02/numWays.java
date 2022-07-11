package com.offer.prac10_02;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class numWays {

    public static void main(String[] args) {
        int i = numWays(0);
        System.out.println(i);
    }

    /**
     * 动态规划
     * 根据推测，f(0) = 1 ,f(1)= 1 , f(2)= 2
     * f(n)= f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];

    }
}
