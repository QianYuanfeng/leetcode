package com.leetcode.prac1302;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 */
public class deepestLeavesSum {
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


    //BFS

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            //同一层有几个节点
            int sz = deque.size();
            while (sz-- > 0) {
                TreeNode node = deque.pollFirst();
                map.put(depth, map.getOrDefault(depth, 0) + node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            depth++;
        }
        return map.get(depth - 1);

    }

    //DFS
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int deepestLeavesSumDFS(TreeNode root) {

        dfs(root, 0);
        return map.get(max);
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) return;
        max = Math.max(max, depth);
        map.put(depth, map.getOrDefault(depth, 0) + node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);

    }


}
