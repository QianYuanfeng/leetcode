package com.offersecond.prac09;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class numSubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int[] nums2 = new int[]{1, 1, 1};
        int k1 = 19;
        int k2 = 1;
        //int i1 = numSubarrayProductLessThanK(nums1, k1);
        //System.out.println(i1);
        int i2 = numSubarrayProductLessThanK2(nums2, k2);
        System.out.println(i2);
    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //todo
        if (k <= 1) return 0;
        int res = 0;
        for (int i = 0 ,j =0 , mul = 1; i < nums.length; i++) {
            mul *= nums[i];
            while (mul >= k) {
                mul /= nums[j++];

            }
            res += i - j + 1;
        }
        return res;

    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int n = nums.length, ans = 0;
        if (k <= 1) return 0;
        for (int i = 0, j = 0, cur = 1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k) cur /= nums[j++];
            ans += i - j + 1;
        }
        return ans;

    }
}
