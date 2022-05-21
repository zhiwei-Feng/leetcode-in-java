package org.example.leetcode;

import java.util.HashMap;

public class n0567 {
    public boolean checkInclusion(String s1, String s2) {
        var charMap = new HashMap<Character, Integer>();
        for (var c : s1.toCharArray()) {
            charMap.compute(c, (k, v) -> (v == null ? 1 : v + 1));
        }
        var winS = 0;
        var match = 0;
        for (var winE = 0; winE < s2.length(); winE++) {
            var cur = s2.charAt(winE);
            if (charMap.containsKey(cur)) {
                charMap.put(cur, charMap.get(cur) - 1);
                if (charMap.get(cur) == 0) {
                    match++;
                }
            }

            if (winE - winS + 1 < s1.length()) {
                continue;
            }
            if (match == charMap.size()) {
                return true;
            }

            var del = s2.charAt(winS);
            if (charMap.containsKey(del)) {
                if (charMap.get(del) == 0) {
                    match--;
                }
                charMap.put(del, charMap.get(del) + 1);
            }
            winS++;
        }

        return false;
    }
}
