package org.example.leetcode;

public class n0208 {
    class Trie {

        Trie[] childs;
        boolean isEnd;

        public Trie() {
            this.childs = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            var p = this;
            for (var c : word.toCharArray()) {
                var index = c - 'a';
                if (p.childs[index] == null) {
                    p.childs[index] = new Trie();
                }
                p = p.childs[index];
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            Trie lastNode = searchPrefix(word);
            return lastNode != null && lastNode.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie lastNode = searchPrefix(prefix);
            return lastNode != null;
        }

        private Trie searchPrefix(String prefix) {
            var p = this;
            for (var c : prefix.toCharArray()) {
                var idx = c - 'a';
                if (p.childs[idx] == null) {
                    return null;
                }
                p = p.childs[idx];
            }
            return p;
        }
    }
}
