package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class n0513 {
    public int findBottomLeftValue(TreeNode root) {
        var res = -1;
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            var levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                var curNode = q.poll();
                if (i == 0) res = curNode.val;
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
            }
        }

        return res;
    }
}
