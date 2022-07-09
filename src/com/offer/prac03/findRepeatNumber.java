package com.offer.prac03;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 03
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findRepeatNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {

        HashSet<Integer> intSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            /*if(intSet.contains(nums[i])){
                return nums[i];
            }else {
                intSet.add(nums[i]);
            }*/
            if(!intSet.add(nums[i])){
                return nums[i];
            }

        }

        return -1;
    }


}
