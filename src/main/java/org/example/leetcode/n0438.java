package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n0438 {

    public List<Integer> findAnagrams(String s, String p) {
        var idxList = new ArrayList<Integer>();
        var charMap = new HashMap<Character, Integer>();
        for (var c : p.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        var match = 0;
        var winS = 0;
        for (var winE = 0; winE < s.length(); winE++) {
            var curChar = s.charAt(winE);
            if (charMap.containsKey(curChar)) {
                charMap.put(curChar, charMap.get(curChar) - 1);
                if (charMap.get(curChar) == 0) match++;
            }

            if (winE - winS + 1 < p.length()) continue;
            if (match == charMap.size()) idxList.add(winS);

            var delChar = s.charAt(winS);
            if (charMap.containsKey(delChar)) {
                if (charMap.get(delChar) == 0) match--;
                charMap.put(delChar, charMap.get(delChar) + 1);
            }
            winS++;
        }

        return idxList;
    }
}
