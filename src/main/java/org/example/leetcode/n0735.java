package org.example.leetcode;

import java.util.Stack;
import java.util.function.IntFunction;

public class n0735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (var i : asteroids) {
            if (i < 0) {
                while (!stk.empty() && stk.peek()>0 && stk.peek()<Math.abs(i)) {
                    stk.pop();
                }
                if (stk.isEmpty()||stk.peek()<0){
                    stk.push(i);
                    continue;
                }

                if (stk.peek()==Math.abs(i)){
                    stk.pop();
                }
            } else {
                stk.push(i);
            }
        }
        return stk.stream().mapToInt(x -> x).toArray();
    }
}
