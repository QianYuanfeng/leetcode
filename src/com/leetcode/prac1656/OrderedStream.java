package com.leetcode.prac1656;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    //todo
    private String[] nums;
    private int ptr;

    public OrderedStream(int n) {
        nums = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        nums[idKey] = value;
        List<String> res = new ArrayList<>();
        while(ptr<nums.length && nums[ptr] != null){
            res.add(nums[ptr]);
            ++ptr;
        }
        return res;
    }

}
