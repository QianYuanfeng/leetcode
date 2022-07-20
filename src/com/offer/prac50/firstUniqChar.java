package com.offer.prac50;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class firstUniqChar {

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c1 = firstUniqChar(s);
        System.out.println("c1:" + c1);
        char c2 = firstUniqCharTwo(s);
        System.out.println("c2:" + c2);

    }

    /**
     * 方法一：利用hashmap里的getOrDefault，获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
     * 时间复杂度：O(n)O(n)，其中 nn 是字符串 ss 的长度。我们需要进行两次遍历
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 是字符集，在本题中 ss 只包含小写字母，因此 |\Sigma| \leq 26∣Σ∣≤26。我们需要 O(|\Sigma|)O(∣Σ∣) 的空间存储哈希映射
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-by-3zqv5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        char res = ' ';
        HashMap<Character, Integer> characterHashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characterHashMap.put(c, characterHashMap.getOrDefault(c, 0) + 1);

        }

        for (int i = 0; i < s.length(); i++) {
            if (characterHashMap.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return res;

    }

    /**
     * 方法二：
     */
    public static char firstUniqCharTwo(String s) {
        char res = ' ';
        HashMap<Character, Boolean> hashMap = new HashMap<Character, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, !hashMap.containsKey(c));
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i))) {
                return s.charAt(i);
            }
        }

        return res;

    }

}
