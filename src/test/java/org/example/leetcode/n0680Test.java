package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n0680Test {

    private final n0680 call = new n0680();

    @Test
    void validPalindrome() {
        class Args {
            final String s;

            public Args(String s) {
                this.s = s;
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
                new Case(new Args("aba"), true),
                new Case(new Args("abca"), true),
                new Case(new Args("abc"), false),
                new Case(new Args("aydmda"), true),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.validPalindrome(c.args.s))
        );
    }
}