package com.offer.prac22;

import java.util.Stack;

public class Solution0821 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode node = null;
        for (int i = 0; i <= k; i++) {
            node = stack.pop();
        }
        return node;

    }
}
