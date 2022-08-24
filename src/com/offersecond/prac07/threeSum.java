package com.offersecond.prac07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class threeSum {



    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length <= 2) {
            return resultList;
        }
        if (nums[0] > 0) {
            return resultList;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                 continue;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] + nums[i] == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]);
                    resultList.add(list);
                    leftIndex++;
                    rightIndex--;
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--;
                    }
                } else if (nums[leftIndex] + nums[rightIndex] + nums[i] < 0) {
                    leftIndex++;
                } else if (nums[leftIndex] + nums[rightIndex] + nums[i] > 0) {
                    rightIndex--;
                }
            }
        }
        return resultList;
    }






}
