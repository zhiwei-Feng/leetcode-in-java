package org.example.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class n0539 {
    private final int DAY = 24 * 60;

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > DAY) return 0;
        Collections.sort(timePoints);
        var minReduce = DAY;
        for (int i = 0; i < timePoints.size(); i++) {
            if (i != timePoints.size() - 1) {
                minReduce = Math.min(reduce(timePoints.get(i), timePoints.get(i + 1)), minReduce);
            } else {
                minReduce = Math.min(reduce(timePoints.get(0), timePoints.get(i)), minReduce);
            }
        }
        return minReduce;
    }

    int reduce(String c1, String c2) {
        String[] unit1 = c1.split(":");
        String[] unit2 = c2.split(":");
        var res = 0;
        var h1 = Integer.parseInt(unit1[0]);
        var h2 = Integer.parseInt(unit2[0]);
        res += 60 * (h2 - h1);
        var m1 = Integer.parseInt(unit1[1]);
        var m2 = Integer.parseInt(unit2[1]);
        res += m2 - m1;
        return Math.min(res, DAY - res);
    }
}
