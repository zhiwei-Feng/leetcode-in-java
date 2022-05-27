package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class n0085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        var heights = new int[matrix[0].length];
        var ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, maxRec(heights));
        }
        return ans;
    }

    int maxRec(int[] heights) {
        var ans = 0;
        Deque<Integer> stk = new ArrayDeque<>();
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

    // 剑指Offer II 040.
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        var ans = 0;
        var heights = new int[matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            var curCharArr = matrix[i].toCharArray();
            for (int j = 0; j < curCharArr.length; j++) {
                if (curCharArr[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, maxRec(heights));
        }

        return ans;
    }
}
