package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class n0933 {
    class RecentCounter {
        private Deque<Integer> q;

        public RecentCounter() {
            this.q = new ArrayDeque<>(3000);
        }

        public int ping(int t) {
            while (!this.q.isEmpty() && this.q.getFirst() < t - 3000) {
                q.removeFirst();
            }
            q.addLast(t);
            return q.size();
        }
    }
}
