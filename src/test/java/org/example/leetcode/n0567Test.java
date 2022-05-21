package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertSame;

class n0567Test {
    private final n0567 call = new n0567();

    @Test
    void checkInclusion() {
        class Args {
            final String s1;
            final String s2;

            public Args(String s1, String s2) {
                this.s1 = s1;
                this.s2 = s2;
            }
        }
        class Case {
            final Args args;
            final boolean expect;

            public Case(Args args, boolean expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args("ab", "eidbaooo"), true),
                new Case(new Args("ab", "eidboaoo"), false),
                new Case(new Args("abc", "ccccbbbbaaaa"), false),
        };
        Arrays.stream(cases).forEach(
                c -> assertSame(c.expect, call.checkInclusion(c.args.s1, c.args.s2))
        );
    }
}