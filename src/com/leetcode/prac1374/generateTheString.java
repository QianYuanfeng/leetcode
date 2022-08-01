package com.leetcode.prac1374;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class generateTheString {
    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n % 2 == 0) {
            stringBuilder.append("a");
            while (n-- > 1) {
                stringBuilder.append("b");
            }
        }else{
            while (n-- > 0) {
                stringBuilder.append("b");
            }

        }
        return stringBuilder.toString();
    }

}
