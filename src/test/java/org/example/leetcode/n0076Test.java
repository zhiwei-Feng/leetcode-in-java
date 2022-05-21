package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n0076Test {

    private final n0076 call = new n0076();

    @Test
    void minWindow() {
        class Args {
            final String s;
            final String t;

            public Args(String s, String t) {
                this.s = s;
                this.t = t;
            }
        }
        class Case {
            final Args args;
            final String expect;

            public Case(Args args, String expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args("ADOBECODEBANC", "ABC"), "BANC"),
                new Case(new Args("a", "a"), "a"),
                new Case(new Args("a", "aa"), ""),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.minWindow(c.args.s, c.args.t))
        );
    }
}