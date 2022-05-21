package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n0125Test {

    private final n0125 call = new n0125();

    @Test
    void isPalindrome() {
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
                new Case(new Args("A man, a plan, a canal: Panama"), true),
                new Case(new Args("race a car"), false),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.isPalindrome(c.args.s))
        );
    }
}