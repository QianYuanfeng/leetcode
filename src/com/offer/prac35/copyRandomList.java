package com.offer.prac35;

import java.util.HashMap;

public class copyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node cur = dummy;
        Node temp = head;
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();

        while (head != null) {

            Node node = new Node(head.val);
            nodeNodeHashMap.put(head, node);

            cur.next = node;
            cur = cur.next;
            head = head.next;
        }

        cur = dummy.next;
        head = temp;
        while (head != null) {
            cur.random = nodeNodeHashMap.get(head.random);
            cur = cur.next;
            head = head.next;
        }

        return dummy.next;
    }


}
