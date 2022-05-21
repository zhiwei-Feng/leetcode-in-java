package org.example.leetcode;

public class n0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        var pre = dummy;
        var p = head;
        var count = 0;
        while (p != null) {
            p = p.next;
            if (count >= n) pre = pre.next;
            count++;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
