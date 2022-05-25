package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class n0084 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<>();
        var ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                var curIdx = stk.pop();
                var leftIdx = stk.isEmpty() ? -1 : stk.peek();
                ans = Math.max(ans, heights[curIdx] * (i - leftIdx - 1));
            }
            stk.push(i);
        }
        var rightIdx = heights.length;
        while (!stk.isEmpty()) {
            var curIdx = stk.pop();
            var leftIdx = stk.isEmpty() ? -1 : stk.peek();
            ans = Math.max(ans, heights[curIdx] * (rightIdx - leftIdx - 1));
        }
        return ans;
    }
}
