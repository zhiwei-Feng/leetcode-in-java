package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n0003Test {

    private final n0003 call = new n0003();

    @Test
    void lengthOfLongestSubstring() {
        class Args {
            final String s;

            public Args(String s) {
                this.s = s;
            }
        }
        class Case {
            final Args args;
            final Integer expect;

            public Case(Args args, Integer expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args("abcabcbb"), 3),
                new Case(new Args("bbbbb"), 1),
                new Case(new Args("pwwkew"), 3),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect.intValue(), call.lengthOfLongestSubstring(c.args.s))
        );
    }
}