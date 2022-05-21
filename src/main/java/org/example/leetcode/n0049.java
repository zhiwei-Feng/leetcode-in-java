package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class n0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        var mapList = new HashMap<String, List<String>>();
        for (var str : strs) {
            var charArr = str.toCharArray();
            Arrays.sort(charArr);
            var key = Arrays.toString(charArr);
            if (!mapList.containsKey(key)) mapList.put(key, new ArrayList<>());
            mapList.get(key).add(str);
        }
        return new ArrayList<>(mapList.values());
    }
}
