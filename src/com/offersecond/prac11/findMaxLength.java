package com.offersecond.prac11;

import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class findMaxLength {
    public static void main(String[] args) {

    }

    public static int findMaxLength(int[] nums) {
        //todo
        int n = nums.length, pre = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 无前缀时，前缀和为0，下标为-1
        for(int j = 0; j < n; j++){
            pre += nums[j] == 0 ? -1 : 1; // 只有两种可能，为0时-1
            if(map.containsKey(pre)){
                int i = map.get(pre); // 针对pre[j](即pre)，找不到pre[i](也是pre)时，i=n，使j-i+1必为负
                max = Math.max(max, j - i);
            }
            else map.put(pre, j);
        }
        return max;
    }

}
