package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class n0173 {
    class BSTIterator {

        private final Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new ArrayDeque<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            var root = this.stack.pop();
            var ans = root.val;
            root = root.right;
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }
            return ans;
        }

        public boolean hasNext() {
            return !this.stack.isEmpty();
        }
    }
}
