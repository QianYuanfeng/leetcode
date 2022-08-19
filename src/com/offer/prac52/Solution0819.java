package com.offer.prac52;

import java.util.HashSet;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Solution0819 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (tempA != null) {
            hashSet.add(tempA);
            tempA = tempA.next;
        }

        while (tempB != null) {
            if (hashSet.contains(tempB)) {
                return new ListNode(tempB.val);
            } else {
                tempB = tempB.next;
            }
        }
        return null;

    }


}
