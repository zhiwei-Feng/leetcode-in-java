package org.example.leetcode;

import java.util.HashMap;

public class n0242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            var charCount = new HashMap<Character, Integer>();
            for (var c : s.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
            for (var c : t.toCharArray()) {
                if (!charCount.containsKey(c)) return false;
                charCount.put(c, charCount.get(c) - 1);
                if (charCount.get(c) == 0) charCount.remove(c);
            }
            return charCount.size() == 0;
        }
    }
}
