package com.offer.prac10_01;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class fib {

    public static void main(String[] args) {
        int i = fib3(5);
        System.out.println(i);
    }


    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        int fibResult = 0;
        if (n == 1 || n == 0) {
            fibResult = n;
        } else {
            fibResult = fib(n - 2) + fib(n - 1);

        }
        return fibResult % 1000000007;
    }


    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int fibDynamic(int n) {
        int[] dp = new int[n + 1];
        if (n == 0 || n == 1) {
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];

    }


    // f(n) = f(n-1) + f(n-2) = 2f(n-2) + f(n-3) = 2(f(n-3) + f(n-4)) + f(n-3) = 3f(n-3) + 2f(n-4) = (n-2) f(2) + (n-3) f(1)
    //

    /**
     * 0808
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];

    }

}
