package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class n0150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (var t : tokens) {
            if ("+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t)) {
                var x2 = stk.pop();
                var x1 = stk.pop();
                switch (t) {
                    case "+":
                        stk.add(x1 + x2);
                        break;
                    case "-":
                        stk.add(x1 - x2);
                        break;
                    case "*":
                        stk.add(x1 * x2);
                        break;
                    case "/":
                        stk.add(x1 / x2);
                        break;
                    default:
                        break;
                }
            } else {
                stk.add(Integer.parseInt(t));
            }
        }
        return stk.peek();
    }
}
