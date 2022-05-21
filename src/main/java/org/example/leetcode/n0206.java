package org.example.leetcode;

public class n0206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode p = head;
        while (p != null) {
            var nextp = p.next;
            p.next = prev;
            prev = p;
            p = nextp;
        }
        return prev;
    }
}
