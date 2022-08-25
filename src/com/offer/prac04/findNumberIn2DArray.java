package com.offer.prac04;

/* *
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        //int[][] matrix = {};
        int target = 5;
        boolean numberIn2DArray = findNumberIn2DArray(matrix, target);
        System.out.println(numberIn2DArray);

    }

    /**
     * 线性查找
     * 时间复杂度：O(n+m),访问到的下标的行最多增加 n 次，列最多减少 m 次，因此循环体最多执行 n + m 次。
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从左下方开始
        int leftLength = matrix.length;
        if (leftLength == 0) {
            return false;
        }
        int rightLength = matrix[0].length;

        int leftIndex = leftLength - 1;
        int rightIndex = 0;
        while (leftIndex >= 0 && rightIndex < rightLength) {
            if (matrix[leftIndex][rightIndex] == target) {
                return true;
            } else if (matrix[leftIndex][rightIndex] < target) {
                rightIndex++;
            } else {
                leftIndex--;
            }
        }
        return false;
    }

    //todo
}
