package com.leetcode.prac1470;

/**
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
public class shuffle {


    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0, j = n, k = 0;
        while (k < 2 * n) {
            if (k % 2 == 0) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }
        return res;
    }

}
