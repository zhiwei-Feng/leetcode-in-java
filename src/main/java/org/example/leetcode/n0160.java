package org.example.leetcode;

public class n0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var pa = headA;
        var pb = headB;
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
            if (pa == pb) break;
            if (pa == null) pa = headB;
            if (pb == null) pb = headA;
        }
        return pa;
    }
}
