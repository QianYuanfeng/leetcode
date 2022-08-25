package com.leetcode.prac26;


public class removeDuplicates {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < nums.length) {
            if (nums[leftIndex] == nums[rightIndex]) {
                rightIndex++;
            } else {
                nums[leftIndex] = nums[rightIndex];
                leftIndex++;
                rightIndex++;
            }
        }

        return 0;
    }

}
