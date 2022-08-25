package com.offersecond.prac30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构：
 * <p>
 * insert(val)：当元素 val 不存在时返回 true，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true，并从集合中移除该项，否则返回 false。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/FortPu
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomizedSet {

    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random random;


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

        list = new ArrayList<Integer>();
        map = new HashMap<Integer , Integer>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);

        //获取list最后一个元素
        Integer lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        //删除最后一个元素
        list.remove(list.size() - 1);

        map.put(lastValue, index);
        map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
