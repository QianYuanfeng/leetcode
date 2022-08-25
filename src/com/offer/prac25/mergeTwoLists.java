package com.offer.prac25;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class mergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode cur = listNode;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return listNode.next;
    }


}
