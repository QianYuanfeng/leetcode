package com.leetcode.prac02;

import java.util.List;

/**
 * 2. 两数相加
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /*
     * 1.先创建头结点，在把头结点设置为当前节点，然后开始遍历，几乎成为了一个套路；
     * 2、current = current.next; 表示指针后移，模板代码；
     * 3、用头结点就可以代表一个链表，所以返回的是 head。
     *
     * 数组转成链表
     * @param intArray
     * @return
     */
    public static ListNode arrayToListNode(int[] intArray) {
        ListNode head = new ListNode(intArray[0]);
        ListNode listNode = head;
        for (int i = 1; i < intArray.length; i++) {
            //当前链表节点的下一个赋值
            listNode.next = new ListNode(intArray[i]);
            //指针后移
            listNode = listNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] intsOne = {9, 9, 9, 9, 9, 9, 9};
        ListNode listNodeOne = arrayToListNode(intsOne);
        int[] intsTwo = {9, 9, 9, 9};
        ListNode listNodeTwo = arrayToListNode(intsTwo);

        ListNode listNode = addTwoNumbers(listNodeOne, listNodeTwo);
        ListNode current = listNode;
        while (current != null){
            System.out.println("current :" + current.val);
            current = current.next;
        }

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个新联表伪指针，用来指向头指针，返回结果
        ListNode prev = new ListNode(0);
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，
        int carry = 0;
        //定义一个可移动的指针，用来指向存储两个数之和的位置
        ListNode cur = prev;
        //当l1 不等于null或l2 不等于空时，就进入循环
        while (l1 != null || l2 != null) {
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x = l1 != null ? l1.val : 0;
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int y = l2 != null ? l2.val : 0;
            //将两个链表的值，进行相加，并加上进位数
            int sum = x + y + carry;
            //计算进位数
            carry = sum / 10;
            //计算两个数的和，此时排除超过10的请况（大于10，取余数）
            sum = sum % 10;
            //将求和数赋值给新链表的节点，
            //注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
            //所以这个时候要创一个新的节点，将值赋予节点
            cur.next = new ListNode(sum);
            //将新链表的节点后移
            cur = cur.next;
            //当链表l1不等于null的时候，将l1 的节点后移
            if (l1 != null) {
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        //返回链表的头节点
        return prev.next;
    }

    /**
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     * <p>
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2n1,n2，进位值为 carry\textit{carry}carry，则它们的和为 n1+n2+carryn1+n2+\textit{carry}n1+n2+carry；其中，答案链表处相应位置的数字为 (n1+n2+carry) mod 10(n1+n2+\textit{carry}) \bmod 10(n1+n2+carry)mod10，而新的进位值为 ⌊n1+n2+carry10⌋\lfloor\frac{n1+n2+\textit{carry}}{10}\rfloor⌊10n1+n2+carry​⌋。
     * <p>
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 000 。
     * <p>
     * 此外，如果链表遍历结束后，有 carry>0\textit{carry} > 0carry>0，还需要在答案链表的后面附加一个节点，节点的值为 carry\textit{carry}carry。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersQian(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        //一开始进位为0
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int sum = i1 + i2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            System.out.println("carry:" + carry);
            System.out.println("sum:" + sum);

            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return head.next;
    }


}


