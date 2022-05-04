package com.leetcode.prac11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * 11.盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxArea {

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(intArray.length);
        int maxArea = maxAreaSolution(intArray);
        System.out.println(maxArea);
    }

    /**
     * 双指针解法
     */
    public static int maxAreaSolution(int[] height) {
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int minHeight = Math.min(height[leftIndex], height[rightIndex]);
            int area = (rightIndex - leftIndex) * minHeight;
            if (maxArea < area) {
                maxArea = area;
            }
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;

            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }



    /**
     * 暴力解法 :
     * 考虑两条垂线 i， j 之间的面积为 （j-i）* min(height[i],height[j])
     *
     * @param height
     * @return
     */
    public static int maxAreaViolentSolution(int[] height) {
        int maxArea = 0;
        for (int i = 0; i <= height.length - 2; i++) {
            for (int j = i + 1; j <= height.length - 1; j++) {
                int minValue = Math.min(height[i], height[j]);
                int maxArea_compare = (j - i) * minValue;
                if (maxArea_compare > maxArea) {
                    maxArea = maxArea_compare;
                }
            }
        }
        return maxArea;
    }


}
