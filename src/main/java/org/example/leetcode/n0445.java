package org.example.leetcode;

public class n0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        var ans = new ListNode();
        var carry = 0;
        while (l1 != null || l2 != null) {
            var sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
            } else if (l1 != null) {
                sum = l1.val + carry;
            } else {
                sum = l2.val + carry;
            }

            carry = sum / 10;
            ans.next = new ListNode(sum % 10, ans.next);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) ans.next = new ListNode(carry, ans.next);
        return ans.next;
    }

    ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode p = h;
        while (p != null) {
            var nextp = p.next;
            p.next = prev;
            prev = p;
            p = nextp;
        }
        return prev;
    }
}
