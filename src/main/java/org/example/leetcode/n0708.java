package org.example.leetcode;

public class n0708 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        var p = head;
        while (true) {
            if (insertVal >= p.val && insertVal <= p.next.val) break;
            if (p.val > p.next.val && (insertVal > p.val || insertVal < p.next.val)) break;
            if (p.next == head) break;
            p = p.next;
        }

        Node insertNode = new Node(insertVal);
        insertNode.next = p.next;
        p.next = insertNode;
        return head;
    }
}
