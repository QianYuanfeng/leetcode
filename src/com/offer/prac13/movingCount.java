package com.offer.prac13;

/**
 *
 */
public class movingCount {

    public static void main(String[] args) {
        int i = movingCount(16, 8, 4);
        System.out.println(i);
    }

    /**
     * 递推
     * dp[i][j] = (dp[i-1][j]|| dp[i][j-1] ) && ( i/10+1%10+j/10+j%10) <=k
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int count = 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
                    continue;
                }

                // 边界判断
                if (i - 1 >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }

                count += dp[i][j] ? 1 : 0;


            }
        }
        return count;

    }

}
