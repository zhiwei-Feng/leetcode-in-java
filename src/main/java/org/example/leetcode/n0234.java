package org.example.leetcode;

public class n0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        var fast = head;
        var slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow.next 表示后半部分的开头
        slow.next = reverse(slow.next);
        // traversal slow.next;
        var p = head;
        var q = slow.next;
        while (q != null) {
            if (p.val != q.val) {
                slow.next = reverse(slow.next);
                return false;
            }
            p = p.next;
            q = q.next;
        }
        slow.next = reverse(slow.next);
        return true;
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
