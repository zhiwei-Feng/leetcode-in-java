package org.example.leetcode;

import java.util.*;

public class n0739 {
    class Pair {
        int temperature;
        int ind;

        public Pair(int temperature, int ind) {
            this.temperature = temperature;
            this.ind = ind;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> stk = new LinkedList<>();
        var res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (i == temperatures.length - 1) {
                stk.push(new Pair(temperatures[i], i));
                res[i] = 0;
                continue;
            }

            while (stk.size() > 0 && stk.peek().temperature <= temperatures[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stk.peek().ind - i;
            }
            stk.push(new Pair(temperatures[i], i));
        }
        return res;
    }
}
