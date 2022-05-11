package com.leetcode.prac27;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class removeElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int i = removeElement(nums, val);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = 0;

        while (rightIndex < nums.length) {
            if (nums[rightIndex] != val) {
                nums[leftIndex] = nums[rightIndex];
                leftIndex++;
                rightIndex++;
            } else {
                rightIndex++;
            }
        }


        return leftIndex;

    }


}
