package org.example.leetcode;

import java.util.*;

public class n0373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(k, Comparator.comparingInt(o -> nums1[o.n1] + nums2[o.n2]));
        var n = nums1.length;
        var m = nums2.length;
        for (int i = 0; i < n; i++) {
            q.offer(new Pair(i, 0));
        }

        var ans = new ArrayList<List<Integer>>();
        while (k-- > 0 && !q.isEmpty()) {
            Pair cur = q.poll();
            ans.add(List.of(nums1[cur.n1], nums2[cur.n2]));
            if (cur.n2 + 1 < m) {
                q.offer(new Pair(cur.n1, cur.n2 + 1));
            }
        }
        return ans;
    }

    class Pair {
        // store index of pair
        int n1;
        int n2;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }
}
