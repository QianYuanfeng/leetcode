package com.leetcode.prac15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 * 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class threeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(Arrays.asList(lists));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        //数组长度<=2返回空
        if (nums.length <= 2) {
            return resultList;
        }
        //数组最小的值大于0 ， 返回空
        if (nums[0] > 0) {
            return resultList;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            //如果确定第一个元素时，如果发现它与它前面的值一样，那么跳过本轮
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int twoSum = nums[leftIndex] + nums[rightIndex];
                if (twoSum == -nums[i]) {
                    List<Integer> list = Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]);
                    resultList.add(list);
                    leftIndex++;
                    rightIndex--;
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = -2, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    //左指针右移时，去除重复
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }
                    //右指针左移时，去除重复
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--;
                    }

                } else if (twoSum > -nums[i]) {
                    rightIndex--;
                } else if (twoSum < -nums[i]) {
                    leftIndex++;
                }
            }

        }

        return resultList;

    }

}


