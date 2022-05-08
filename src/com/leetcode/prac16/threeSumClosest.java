package com.leetcode.prac16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 10, 11};
        int target = 12;
        int i = threeSumClosest(nums, target);
        System.out.println("i:" + i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int balance = 0;
        int result = target;
        Boolean firstFlag = true;

        for (int i = 0; i < nums.length - 2; i++) {

            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int threeSum = nums[leftIndex] + nums[rightIndex] + nums[i];
                int balanceCompare = target - threeSum;

                if (balanceCompare == 0) {
                    return target;
                } else if (balanceCompare < 0) {
                    if (firstFlag) {
                        balance = balanceCompare;
                        result = nums[leftIndex] + nums[rightIndex] + nums[i];
                        firstFlag = false;
                    }


                    if (Math.abs(balanceCompare) <= Math.abs(balance)) {
                        balance = balanceCompare;
                        result = nums[leftIndex] + nums[rightIndex] + nums[i];
                    }

                    rightIndex--;


                } else if (balanceCompare > 0) {
                    if (firstFlag) {
                        balance = balanceCompare;
                        result = nums[leftIndex] + nums[rightIndex] + nums[i];
                        firstFlag = false;
                    }

                    if (Math.abs(balanceCompare) <= Math.abs(balance)) {
                        balance = balanceCompare;
                        result = nums[leftIndex] + nums[rightIndex] + nums[i];
                    }

                    leftIndex++;
                }

            }

        }

        return result;

    }

}
