package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n0647Test {

    private final n0647 call = new n0647();

    @Test
    void countSubstrings() {
        class Args {
            final String s;

            public Args(String s) {
                this.s = s;
            }
        }
        class Case {
            final Args args;
            final int expect;

            public Case(Args args, Integer expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args("abc"), 3),
                new Case(new Args("aaa"), 6),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.countSubstrings(c.args.s))
        );
    }
}