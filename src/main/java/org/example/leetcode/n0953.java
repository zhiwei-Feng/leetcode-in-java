package org.example.leetcode;

import java.util.HashMap;

public class n0953 {
    public boolean isAlienSorted(String[] words, String order) {
        var dict = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], dict)) continue;
            return false;
        }
        return true;
    }

    boolean compare(String w1, String w2, HashMap<Character, Integer> dict) {
        var i = 0;
        var j = 0;
        while (i < w1.length() && j < w2.length()) {
            if (w1.charAt(i)==w2.charAt(j)) {
                i++;
                j++;
                continue;
            }
            return (dict.get(w1.charAt(i)) < dict.get(w2.charAt(j)));
        }

        return w1.length() <= w2.length();
    }
}
