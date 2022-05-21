package org.example.leetcode;

import java.util.HashMap;

public class n0076 {
    public String minWindow(String s, String t) {
        var charMap = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        var match = 0;
        var winStart = 0;
        var ans = "";
        for (var winEnd = 0; winEnd < s.length(); winEnd++) {
            var curKey = s.charAt(winEnd);
            if (charMap.containsKey(curKey)) {
                charMap.put(curKey, charMap.get(curKey) - 1);
                if (charMap.get(curKey) == 0) match++;
            }

            while (match == charMap.size()) {
                if (ans.isEmpty() || ans.length() > winEnd - winStart + 1) ans = s.substring(winStart, winEnd + 1);
                var delKey = s.charAt(winStart);
                if (charMap.containsKey(delKey)) {
                    if (charMap.get(delKey) == 0) match--;
                    charMap.put(delKey, charMap.get(delKey) + 1);
                }
                winStart++;
            }
        }

        return ans;
    }
}
