package com.offer.prac14_01;


/**
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 2 <= n <= 58
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class cuttingRope {

    public static void main(String[] args) {
        int i = cuttingRope(3);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n == 2) {
            return 1;
        }
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

}
