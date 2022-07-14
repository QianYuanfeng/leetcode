package com.offer.prac63;

/**
 * 0 <= 数组长度 <= 10^5
 */
public class maxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] dp = new int[prices.length + 1];
        dp[0] = prices[0];

        int[] max = new int[prices.length + 1];
        int maxValue = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max[i] = prices[i] - dp[i - 1];
            maxValue = Math.max(maxValue, max[i]);
        }

        return maxValue;

    }


}
