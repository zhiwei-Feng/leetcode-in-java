package org.example.leetcode;

public class n0676 {
    class MagicDictionary {

        MagicDictionary[] childs;
        boolean isEnd;

        public MagicDictionary() {
            this.childs = new MagicDictionary[26];
            this.isEnd = false;
        }

        public void buildDict(String[] dictionary) {
            for (var s : dictionary) {
                this.insert(s);
            }
        }

        private void insert(String word) {
            var p = this;
            for (var c : word.toCharArray()) {
                var idx = c - 'a';
                if (p.childs[idx] == null) {
                    p.childs[idx] = new MagicDictionary();
                }
                p = p.childs[idx];
            }
            p.isEnd = true;
        }

        public boolean search(String searchWord) {
            var p = this;
            for (int i = 0; i < searchWord.length(); i++) {
                var idx = searchWord.charAt(i) - 'a';
                for (int j = 0; j < 26; j++) {
                    if (p.childs[j]!=null && idx!=j && p.childs[j].searchSub(searchWord.substring(i+1))) {
                        return true;
                    }
                }
                if (p.childs[idx]!=null) {
                    p = p.childs[idx];
                }else {
                    return false;
                }
            }
            return false;
        }

        private boolean searchSub(String subWord) {
            var p = this;
            for (var c : subWord.toCharArray()) {
                var idx = c - 'a';
                if (p.childs[idx] == null) {
                    return false;
                }
                p = p.childs[idx];
            }
            return p.isEnd;
        }
    }
}
