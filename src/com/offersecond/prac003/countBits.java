package com.offersecond.prac003;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 */
public class countBits {
    public static void main(String[] args) {
        int[] ints = countBits(2);
        System.out.println(ints);

    }

    /**
     * 动态规划
     * <p>
     * O(0)= 0 ,O(1) = 1 , O(2) = 10 ,O(3)= 11, O(4) =100 , O(5) = 101,O(6)= 110 , O(7)= 111,O(8)=1000
     * <p>
     * dp[0)=0, dp[1]=1,dp[2]=1,dp[3]=2,dp[4]=1,dp[5]=2,dp[6]=2,dp[7]=3,dp[8]=1
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            //i >> 1 所包含的 1 的个数」+「i 的最低位是否为 1」
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;

    }


}
