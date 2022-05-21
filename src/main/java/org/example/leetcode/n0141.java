package org.example.leetcode;

public class n0141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        var fast = head;
        var slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
