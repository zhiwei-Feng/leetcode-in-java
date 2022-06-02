package org.example.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

public class n0919 {
    class CBTInserter {

        private Deque<TreeNode> fathers;
        private TreeNode root;

        public CBTInserter(TreeNode root) {
            this.fathers = new ArrayDeque<>(1000);
            // init fathers
            Deque<TreeNode> q = new ArrayDeque<>();
            q.addLast(root);
            while (!q.isEmpty()) {
                var cur = q.pollFirst();
                if (cur.left == null || cur.right == null) {
                    this.fathers.addLast(cur);
                }
                if (cur.left != null) q.addLast(cur.left);
                if (cur.right != null) q.addLast(cur.right);
            }
            this.root = root;
        }

        public int insert(int val) {
            var newNode = new TreeNode(val);
            var curFather = this.fathers.getFirst();
            if (curFather.left == null) {
                curFather.left = newNode;
            } else {
                curFather.right = newNode;
                this.fathers.removeFirst();
            }
            this.fathers.addLast(newNode);
            return curFather.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
