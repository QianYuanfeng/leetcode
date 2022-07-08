package com.leetcode.prac55;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class canJump {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println("b:" + b);
    }

    public static boolean canJump(int[] nums) {
        int rightIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightIndex) {
                rightIndex = Math.max(rightIndex, nums[i] + i);
            }
            if (rightIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
