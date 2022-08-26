package com.offersecond.prac114;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 剑指 Offer II 114. 外星文字典[困难]
 * 现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。
 * 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
 * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
 * 字符串 s 字典顺序小于 字符串 t 有两种情况：
 * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么s 的字典顺序小于 t 。
 * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/Jf1JuT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0826 {

    //拓扑排序
    int N = 26, M = N * N, idx = 0, cnt = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] in = new int[N], out = new int[N];
    boolean[] vis = new boolean[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        out[a]++;
        in[b]++;
    }


    public String alienOrder(String[] words) {
        int n = words.length;
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                if (!vis[c - 'a'] && ++cnt >= 0) vis[c - 'a'] = true;
            }
            for (int j = 0; j < i; j++) {
                if (!build(words[j], words[i])) return "";
            }
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (vis[i] && in[i] == 0) d.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) {
            int u = d.pollFirst();
            sb.append((char) (u + 'a'));
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) d.addLast(j);
            }
        }
        return sb.length() == cnt ? sb.toString() : "";
    }

    boolean build(String a, String b) {
        int n = a.length(), m = b.length(), len = Math.min(n, m);
        for (int i = 0; i < len; i++) {
            int c1 = a.charAt(i) - 'a', c2 = b.charAt(i) - 'a';
            if (c1 != c2) {
                add(c1, c2);
                return true;
            }
        }
        return n <= m;
    }

}
