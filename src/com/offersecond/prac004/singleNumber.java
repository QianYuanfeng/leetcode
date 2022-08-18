package com.offersecond.prac004;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class singleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{30000, 500, 100, 30000, 100, 30000, 100};
        singleNumber(nums);
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> e : entries) {
            if (e.getValue() == 1) {
                res = e.getKey();
                return e.getKey();
            }
        }

        return res;

    }


    public static int singleNumber2(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        //另一种写法
        for (int x : hashMap.keySet()) {
            if (hashMap.get(x) == 1) {
                res = x;
                return x;
            }
        }

        return res;

    }


}
