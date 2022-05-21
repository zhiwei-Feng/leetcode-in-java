package org.example.leetcode;

public class n0142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        var fast = head;
        var slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast.next == null || fast.next.next == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
