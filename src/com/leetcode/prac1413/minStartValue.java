package com.leetcode.prac1413;

/**
 * 1413. 逐步求和得到正数的最小值
 * 给你一个整数数组 nums。你可以选定任意的正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums数组，并将 startValue 依次累加上nums数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的正数作为 startValue 。
 */
public class minStartValue {


    public int minStartValue(int[] nums) {
        int res;
        int maxSum = Integer.MAX_VALUE;
        int initNum = nums[0];
        maxSum = Math.min(maxSum, initNum);
        for (int i = 1; i < nums.length; i++) {
            initNum += nums[i];
            maxSum = Math.min(maxSum, initNum);
        }
        if (maxSum >= 1) {
            res = 1;
        } else {
            res = 1 - maxSum;
        }
        return res;

    }


}
