package com.offersecond.prac115;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 剑指 Offer II 115. 重建序列
 * 给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
 * 检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 。
 * <p>
 * 例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
 * 而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
 * <p>
 * 如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
 * 子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。
 */
public class sequenceReconstruction {

    //todo 拓扑排序
    int N = 10010, M = N, idx;
    int[] he = new int[N], e = new int[M], ne = new int[M], in = new int[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        in[b]++;
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        Arrays.fill(he, -1);
        for (int[] s : sequences) {
            for (int i = 1; i < s.length; i++) add(s[i - 1], s[i]);
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) d.addLast(i);
        }
        int loc = 0;
        while (!d.isEmpty()) {
            if (d.size() != 1) return false;
            int t = d.pollFirst();
            if (nums[loc++] != t) return false;
            for (int i = he[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) d.addLast(j);
            }
        }
        return loc == n;
    }

}
