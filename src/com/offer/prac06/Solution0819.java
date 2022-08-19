package com.offer.prac06;

import java.util.Stack;

/**
 *
 */
public class Solution0819 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            length++;
        }
        int[] res = new int[stack.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;

    }

}
