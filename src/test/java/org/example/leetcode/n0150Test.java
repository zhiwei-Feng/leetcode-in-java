package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class n0150Test {

    private final n0150 call = new n0150();

    @Test
    void evalRPN() {
        class Args {
            final String[] tokens;

            public Args(String[] tokens) {
                this.tokens = tokens;
            }
        }
        class Case {
            final Args args;
            final int expect;

            public Case(Args args, int expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args(new String[]{"2", "1", "+", "3", "*"}), 9),
                new Case(new Args(new String[]{"4", "13", "5", "/", "+"}), 6),
                new Case(new Args(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}),
                        22),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.evalRPN(c.args.tokens))
        );
    }
}