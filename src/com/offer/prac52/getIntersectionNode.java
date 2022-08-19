package com.offer.prac52;

import java.util.HashSet;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class getIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }


    /**
     * hashset
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 时间复杂度O(m+n)
         * 空间复杂度O(m)
         */
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

    /**
     * 差值法
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lengthA = 0;
        int lengthB = 0;
        //两个链表的长度
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        int sub = lengthA - lengthB;
        if (sub > 0) {
            //A比B长
            while (sub-- > 0) {
                headA = headA.next;
            }
        } else if (sub < 0) {
            //B比A长
            int subReverse = 0 - sub;
            while (subReverse-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        if (headA != null) {
            return headA;
        } else {
            return null;

        }

    }





}
