package com.offersecond.prac008;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class minSubArrayLen {


    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = n + 10;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        for (int i = 1; i <= n; i++) {
            int s = sum[i], d = s - target;
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sum[mid] <= d) l = mid;
                else r = mid - 1;
            }
            if (sum[r] <= d) ans = Math.min(ans, i - r);
        }
        return ans == n + 10 ? 0 : ans;
    }


}
