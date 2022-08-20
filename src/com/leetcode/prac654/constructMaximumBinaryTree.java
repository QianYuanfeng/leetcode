package com.leetcode.prac654;


/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * <p>
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class constructMaximumBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);

    }

    private TreeNode dfs(int[] nums, int from, int to) {
        if (to < from) return null;
        int max = from;
        for (int i = from + 1; i <= to; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = dfs(nums, from, max - 1);
        node.right = dfs(nums, max + 1, to);
        return node;

    }

}
