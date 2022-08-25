package com.offersecond.prac067;

public class findMaximumXOR {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        int maximumXOR = findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }

    //todo前缀树问题，好难啊🥹
    //定义前缀树
    static class TrieNode {
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[2];
        }
    }

    //前缀树根节点
    private static TrieNode trie;

    public static int findMaximumXOR(int[] nums) {
        //记录异或最大值
        int maxXOR = Integer.MIN_VALUE;
        //构建前缀树
        buildTrie(nums);
        for (int num : nums) {
            maxXOR = Math.max(maxXOR, serchMaxXOR(num));
        }
        return maxXOR;
    }

    public static void buildTrie(int[] nums) {
        trie = new TrieNode();
        for (int num : nums) {
            TrieNode cur = trie;
            for (int i = 31; i >= 0; i--) {
                int d = num >> i & 1;
                if (cur.next[d] == null) {
                    cur.next[d] = new TrieNode();
                }
                cur = cur.next[d];
            }
        }
    }

    public static int serchMaxXOR(int num) {
        TrieNode cur = trie;
        int xorNum = 0;
        for (int i = 31; i >= 0; i--) {
            int d = num >> i & 1;
            int theOther = 0;
            if (d == 0) {
                theOther = 1;
            } else {
                theOther = 0;
            }

            if (cur.next[theOther] == null) {
                cur = cur.next[d];
                xorNum = xorNum * 2 + d;

            } else {
                cur = cur.next[theOther];
                xorNum = xorNum * 2 + theOther;
            }


        }
        return num ^ xorNum;
    }


    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public static int findMaximumXOR2(int[] nums) {
        int maximum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maximum = Math.max(maximum, (nums[i] ^ nums[j]));
            }
        }
        return maximum;
    }


}
