package com.leetcode.prac623;

import java.util.ArrayDeque;
import java.util.Deque;

public class addOneRow {

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


    public TreeNode addOneRow2(TreeNode root, int val, int depth) {
        //深度为1的情况
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        //双端队列
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int sz = d.size();
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (cur == depth - 1) {
                    TreeNode a = new TreeNode(val);
                    TreeNode b = new TreeNode(val);
                    a.left = t.left;
                    b.right = t.right;
                    t.left = a;
                    t.right = b;
                } else {
                    if (t.left != null) {
                        d.addLast(t.left);
                    }
                    if (t.right != null) {
                        d.addLast(t.right);
                    }
                }
            }
            cur++;
        }
        return root;

    }


    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        //插入左结点
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        //插入右结点
        if (depth == 0) {
            TreeNode node = new TreeNode(val);
            node.right = root;
            return node;
        }
        if (root == null) {
            return null;
        }
        if (depth > 1) {
            root.left = addOneRow(root.left, val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        return root;


    }

}
