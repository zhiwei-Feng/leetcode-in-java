package org.example.leetcode;

import java.util.List;
import java.util.StringJoiner;

public class n0648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie tree = new Trie();
        for (var s : dictionary) {
            tree.insert(s);
        }

        String[] splited = sentence.split(" ");
        for (int i = 0; i < splited.length; i++) {
            String replaced = tree.getRoot(splited[i]);
            if (replaced.length() > 0) {
                splited[i] = replaced;
            }
        }
        return String.join(" ", splited);
    }

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
                var idx = c - 'a';
                if (p.childs[idx] == null) {
                    p.childs[idx] = new Trie();
                }
                p = p.childs[idx];
            }
            p.isEnd = true;
        }

        public String getRoot(String word) {
            var p = this;
            var replacedBuilder = new StringBuilder();

            for (var c : word.toCharArray()) {
                var idx = c - 'a';
                if (p.childs[idx] == null) {
                    return "";
                }
                replacedBuilder.append(c);
                if (p.childs[idx].isEnd) {
                    return replacedBuilder.toString();
                }
                p = p.childs[idx];
            }
            return "";
        }
    }
}
