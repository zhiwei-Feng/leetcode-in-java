package org.example.leetcode;

import java.util.HashMap;

public class n0003 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        var winMap = new HashMap<Character, Integer>();
        var winStart = 0;
        var maxLen = 1;
        for (var winEnd = 0; winEnd < s.length(); winEnd++) {
            var curKey = s.charAt(winEnd);
            winMap.put(curKey, winMap.getOrDefault(curKey, 0) + 1);
            while (winMap.size() != winEnd - winStart + 1) {
                var delKey = s.charAt(winStart);
                winMap.put(delKey, winMap.get(delKey) - 1);
                if (winMap.get(delKey) == 0) {
                    winMap.remove(delKey);
                }
                winStart++;
            }
            maxLen = Math.max(maxLen, winEnd - winStart + 1);
        }
        return maxLen;
    }
}
