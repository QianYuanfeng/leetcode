package com.offer.prac07;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class buildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


   /* public TreeNode buildTree(int[] preorder, int[] inorder) {



        if (preorder.length > 0 && inorder.length > 0) {
            //preorder的第一个数为根结点
            //inorder里找到这个数的位置，左边为左节点，右边为右节点

            int rootNode = preorder[0];



        }


//        return
    }
*/
}
