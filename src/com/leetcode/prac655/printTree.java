package com.leetcode.prac655;

import java.util.List;

/**
 * 655. 输出二叉树
 *
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 *     树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 *     矩阵的列数 n 应该等于 2height+1 - 1 。
 *     根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 *     对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 *     继续这一过程，直到树中的所有节点都妥善放置。
 *     任意空单元格都应该包含空字符串 "" 。
 *
 * 返回构造得到的矩阵 res 。
 *
 */
public class printTree {

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

    public List<List<String>> printTree(TreeNode root) {

        return null;
    }





}
