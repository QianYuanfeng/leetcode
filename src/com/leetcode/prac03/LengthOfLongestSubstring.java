package com.leetcode.prac03;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    private static Logger logger = LoggerFactory.getLogger(LengthOfLongestSubstring.class);

    public static void main(String[] args) {
        String str = "abba";
        int i = lengthOfLongestSubstring(str);
        System.out.println("i:" + i);

        //int j = maxString(str);
        //System.out.println("j:" + j);

    }


    /**
     * 方法一：滑动窗口
     
     * 思路和算法
     
     * 我们先用一个例子考虑如何在较优的时间复杂度内通过本题。
     
     * 我们不妨以示例一中的字符串 abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
     
     * 以 (a)bcabcbb  开始的最长字符串为 (abc)abcbb ；
     * 以 a(b)cabcbb  开始的最长字符串为 a(bca)bcbb ；
     * 以 ab(c)abcbb  开始的最长字符串为 ab(cab)cbb ；
     * 以 abc(a)bcbb  开始的最长字符串为 abc(abc)bb ；
     * 以 abca(b)cbb  开始的最长字符串为 abca(bc)bb ；
     * 以 abcab(c)bb  开始的最长字符串为 abcab(cb)b ；
     * 以 abcabc(b)b  开始的最长字符串为 abcabc(b)b ；
     * 以 abcabcb(b)  开始的最长字符串为 abcabcb(b) 。

     * 发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 k个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为 rk。
     * 那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 rk 的字符显然是不重复的，并且由于少了原本的第 k个字符，我们可以尝试继续增大 rk，直到右侧出现了重复字符为止。
     * 这样一来，我们就可以使用「滑动窗口」来解决这个问题了：
     
     * 我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 rk；
     
     * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
     
     * 在枚举结束后，我们找到的最长的子串的长度即为答案。
     
     * 判断重复字符
     
     * 在上面的流程中，我们还需要使用一种数据结构来判断 是否有重复的字符，常用的数据结构为哈希集合（即 C++ 中的 std::unordered_set，Java 中的 HashSet，Python 中的 set, JavaScript 中的 Set）。在左指针向右移动的时候，我们从哈希集合中移除一个字符，在右指针向右移动的时候，我们往哈希集合中添加一个字符。
     
     * 至此，我们就完美解决了本题。
     
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //最长子串长度
        int max = 0;
        //滑动窗口左下标，i相当于滑动窗口右下标
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            // 当遇到重复值，说明左指针需要跳转，跳转的位置是该重复值的下标+1
            // 比如字符串abcdecf，到遇到第二个c，即便从bcde任意一个开始，长度都无法超过a，只有从decf开始计算才是新一轮查找
            // 值得注意的是，如果碰到了重复值的下标比左指针还小的情况，不应该跳转，因为左指针左边的元素不再窗口内，比如abba
            if (hashMap.containsKey(s.charAt(i))) { //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
                //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                left = Math.max(hashMap.get(s.charAt(i)) + 1, left);
            }
            //再更新map中a映射的下标
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }


    /**
     * herig
     *
     * @param s
     * @return
     */
    public static int maxString(String s) {
        int maxLen = 0;
        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() - 1; i++) {
            int currentLen = 1;
            String substring = s.substring(i - 1, i);
            HashMap<String, Integer> map = new HashMap<>();
            map.put(substring, i);
            for (int j = i + 1; j <= s.length(); j++) {
                String substring_j = s.substring(j - 1, j);
                if (map.containsKey(substring_j)) {
                    break;
                } else {
                    map.put(substring_j, j);
                    currentLen++;
                }
            }
            if (maxLen < currentLen) {
                maxLen = currentLen;
            }
        }

        return maxLen;
    }


    //如果用哈希计算的话，每个字符都存到map里，如果
    public static int lengthOfLongestSubstringWrong(String s) {
        int balance = 0;
        int index = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (s == null || s.length() == 0) {
            return balance;
        }
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(i - 1, i);
            System.out.println("substring: " + substring);
            if (hashMap.containsKey(substring)) {
                index = hashMap.get(substring);
                Integer integer = hashMap.get(substring);
                int indexBalance = i - index;
                if (indexBalance > balance) {
                    balance = indexBalance;
                }
            } else {
                hashMap.put(substring, i);
                balance = i - index;
            }

        }
        System.out.println("balance:" + balance);
        return balance;
    }


}
