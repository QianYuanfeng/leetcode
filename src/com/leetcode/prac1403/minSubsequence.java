package com.leetcode.prac1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minSubsequence {

    public static void main(String[] args) {

    }

    public List<Integer> minSubsequence(int[] nums) {


        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            target += nums[i];
            list.add(nums[i]);
            if (target > (sum - target)) {
                return list;
            }
        }

        return list;

    }

}
