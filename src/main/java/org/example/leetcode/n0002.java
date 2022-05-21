package org.example.leetcode;

public class n0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        var last = ans;
        var p = l1;
        var q = l2;
        var carry = 0;
        while (p != null && q != null) {
            var sum = p.val + q.val + carry;
            carry = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;
            p = p.next;
            q = q.next;
        }

        while (p != null) {
            var sum = p.val + carry;
            carry = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;
            p = p.next;
        }
        while (q != null) {
            var sum = q.val + carry;
            carry = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;
            q = q.next;
        }
        if (carry != 0) last.next = new ListNode(carry);
        return ans.next;
    }
}
