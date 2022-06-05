package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class n0297 {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder encoded = new StringBuilder();
            encoded.append("[");
            // bfs tree
            List<TreeNode> q = new ArrayList<>();
            if (root != null) q.add(root);
            while (!q.isEmpty()) {
                var cur = q.remove(0);
                if (cur == null) {
                    encoded.append("null,");
                    continue;
                }
                encoded.append(cur.val).append(",");
                q.add(cur.left);
                q.add(cur.right);
            }
            encoded.append("]");
            return encoded.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // []
            if (data.length() == 2) return null;
            // [1,]
            String validData = data.substring(1).substring(0, data.length() - 2);
            String[] treeNodes = validData.split(",");
            TreeNode[] tree = new TreeNode[treeNodes.length];
            for (int i = 0; i < treeNodes.length; i++) {
                if ("null".equals(treeNodes[i])) tree[i] = null;
                else tree[i] = new TreeNode(Integer.parseInt(treeNodes[i]));

            }
            var j = 1;
            for (TreeNode curNode : tree) {
                if (curNode == null) continue;
                curNode.left = tree[j];
                curNode.right = tree[j + 1];
                j += 2;
            }
            return tree[0];
        }
    }
}
