package com.leetcode.prac1408;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * 如果你可以删除 words[j]最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 */
public class stringMatching {

    public static void main(String[] args) {

    }

    public List<String> stringMatching(String[] words) {

        if (words.length == 1) {
            return new ArrayList<>();
        }

        String initStr = words[0];
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j] != words[i]) {
                    if (words[j].contains(words[i]) && !res.contains(words[i])) {
                        res.add(words[i]);
                    }
                }
            }
        }
        return res;

    }


}
