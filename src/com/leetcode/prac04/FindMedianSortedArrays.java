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
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4, 5};
        double medianSortedArrays = findMedianSortedArraysOne(nums1, nums2);
        System.out.println("medianSortedArrays :" + medianSortedArrays);

    }

    //1.两个数组的值都取出来，然后放到一个数组里排好序，再找到中位数
    public static double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
        double result = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            arrayList.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            arrayList.add(nums2[j]);
        }
        Integer[] ints = new Integer[arrayList.size()];
        arrayList.toArray(ints);
        sortArray(ints);
        return result;
    }

    public static void sortArray(Integer[] intArray) {
        System.out.println("intArray :" + Arrays.asList(intArray));
        int start = 0;
        int end = intArray.length - 1;

        if (end - start > 0) {
//            sortArray(intArray);
            int left = start;
            int right = (end - start) / 2 + 1;

            int index = 0;
            Integer[] result = new Integer[end - start + 1];

            while (left <= (right - left) / 2 && right <= end) {
                System.out.println("left:" + left + "; right:" + right + "; (right - left) / 2 :" + (right - left) / 2);
                if (intArray[left] <= intArray[right]) {
                    System.out.println("intArray[left] : " + intArray[left] + "; intArray[right] :" + right);
                    result[index] = intArray[left];
                    left++;
                } else {

                    result[index] = intArray[right];
                    right++;
                }
//                System.out.println("left :" + left + ";right:" + right);
                System.out.println("result :" + Arrays.asList(result));
                index++;
            }

            while (left <= (right - left) / 2 || right <= end) {
                System.out.println("left:" + left + " ;right:" + right + ";(right - left)/2 : " + (right - left) / 2);
                if (left <= (right - left) / 2) {
                    System.out.println("left");
                    result[index] = intArray[left];
                    left++;
                } else {
                    System.out.println("right");
                    result[index] = intArray[right];
                    right++;
                }
//                System.out.println("left :" + left + ";right:" + right);
                System.out.println("result :" + Arrays.asList(result));
                index++;
            }

            System.out.println("result :" + Arrays.asList(result));

            for (int i = start; i <= end; i++) {
                intArray[i] = result[i ];
            }

            System.out.println("intArray :" + Arrays.asList(intArray));
        }


    }


}
