package com.offer.prac22;

import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class getKthFromEnd {

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
     * 双指针。两指针都指向头节点。右指针加k。（两指针距离为k）
     * 然后双指针同时右移，移到最后。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

    /**
     * 利用栈先进后出
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode pop = null;
        while (k-- > 0) {
            pop = stack.pop();
        }
        return pop;
    }


    /**
     * 差值
     * 先算出链表长度n
     * 再找到n-k的位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int size = n - k;
        while (size-- > 0) {
            head = head.next;
        }
        return head;

    }


}
