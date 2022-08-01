package com.offer.prac24;


import java.util.Stack;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class reverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {

    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;


        }

        return cur;
    }


}
