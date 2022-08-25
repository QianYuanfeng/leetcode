package com.offer.prac32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //为空的情况
        if (root == null) {
            return new ArrayList<>();
        }
        //init
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            //队列长度即为数组长度
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode poll = queue.poll();
                integerList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            arrayList.add(integerList);
        }
        return arrayList;
    }
}
