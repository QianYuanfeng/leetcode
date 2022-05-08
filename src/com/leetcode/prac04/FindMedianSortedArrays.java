package com.leetcode.prac04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {1, 3};
        double medianSortedArrays = findMedianSortedArraysOne(nums1, nums2);
        System.out.println("medianSortedArrays :" + medianSortedArrays);

    }

    //两个数组依次比较，构成一个新的数组，取中位数
    public static double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
        double result = 0;

        int numLengthOne = nums1.length;
        int numLengthTwo = nums2.length;
        int[] resultArray = new int[numLengthOne + numLengthTwo];

        int x = 0;
        int y = 0;

        for (int i = 0; i < numLengthOne + numLengthTwo; i++) {
            if (x < numLengthOne) {
                if (y < numLengthTwo) {
                    if (nums1[x] <= nums2[y]) {
                        resultArray[i] = nums1[x];
                        x++;
                    } else {
                        resultArray[i] = nums2[y];
                        y++;
                    }
                } else {
                    resultArray[i] = nums1[x];
                    x++;
                }

            } else {
                resultArray[i] = nums2[y];
                y++;

            }

        }

        if (resultArray.length % 2 == 0) {
            //偶数位数 ， 中间两位相加再除以2
            result = (resultArray[resultArray.length / 2] + resultArray[resultArray.length / 2 - 1]) / 2.0;
        } else {
            result = resultArray[resultArray.length / 2];
        }


        return result;


    }

}
