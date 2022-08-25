package com.leetcode.leetcode658;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findClosestElements {
    //todo

    //双指针
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int removeLength = length - k;
        while (removeLength > 0) {
            if (x - arr[leftIndex] <= arr[rightIndex] - x) {
                rightIndex--;
            } else {
                leftIndex++;
            }
            removeLength--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = leftIndex; i < leftIndex + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

}
