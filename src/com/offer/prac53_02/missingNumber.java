package com.offer.prac53_02;

public class missingNumber {

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m;
            } else {
                j = m - 1;
            }
        }
        return i;

    }


}
