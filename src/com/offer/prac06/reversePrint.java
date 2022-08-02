package com.offer.prac06;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class reversePrint {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        int[] ints = new int[]{1, 3, 2};
        ListNode head = new ListNode(ints[0]);
        ListNode listNode = head;
        for (int i = 1; i < ints.length; i++) {
            listNode.next = new ListNode(ints[i]);
            listNode = listNode.next;

        }
        reversePrint(head);
//        System.out.println(Arrays.asList(ints1));

    }

    /**
     * 利用栈 ，后进先出
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {

        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int[] intArray = new int[stack.size()];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = stack.pop().val;
        }

        return intArray;


    }


    /**
     * 0802 栈
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {

        ListNode temp = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        int length = 0;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
            length++;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int val = stack.pop().val;
            arr[i] = val;
        }
        return arr;


    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static int[] reversePrint3(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        recursion(head, arrayList);
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static void recursion(ListNode head, ArrayList<Integer> arrayList) {
        if (head == null) {
            return;
        }

        recursion(head.next, arrayList);
        arrayList.add(head.val);

    }

}
