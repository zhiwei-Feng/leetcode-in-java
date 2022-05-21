package org.example.leetcode;

public class n0143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        var fast = head;
        var slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        var second = slow.next;
        slow.next = null;

        second = reverse(second);

        var p = head;
        var q = second;
        while (q != null && p != null) {
            var nextq = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = nextq;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode p = head;
        while (p != null) {
            var np = p.next;
            p.next = prev;
            prev = p;
            p = np;
        }
        return prev;
    }
}
