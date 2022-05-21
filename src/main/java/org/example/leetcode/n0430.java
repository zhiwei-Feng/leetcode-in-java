package org.example.leetcode;

public class n0430 {
    public Node flatten(Node head) {
        if (head == null) return null;
        return _flatten(head).head;
    }

    NodeList _flatten(Node head) {
        NodeList res = new NodeList();
        res.head = head;
        var p = head;
        while (p != null) {
            if (p.child != null) {
                var childNodeList = _flatten(p.child);
                childNodeList.tail.next = p.next;
                if (p.next!=null) p.next.prev = childNodeList.tail;
                p.next = childNodeList.head;
                childNodeList.head.prev = p;
                p.child = null;
                p = childNodeList.tail;
            }
            if (p.next == null) res.tail = p;
            p = p.next;
        }
        return res;
    }

    class NodeList {
        Node head;
        Node tail;
    }
}
