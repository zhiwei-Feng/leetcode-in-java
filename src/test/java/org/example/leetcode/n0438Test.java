package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

class n0438Test {

    private final n0438 call = new n0438();

    @Test
    void findAnagrams() {
        class Args {
            final String s;
            final String p;

            public Args(String s, String p) {
                this.s = s;
                this.p = p;
            }
        }
        class Case {
            final Args args;
            final List<Integer> expect;

            public Case(Args args, List<Integer> expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args("cbaebabacd", "abc"), Arrays.asList(0, 6)),
                new Case(new Args("abab", "ab"), Arrays.asList(0, 1, 2)),
        };
        Arrays.stream(cases).forEach(
                c -> assertSame(true, c.expect.equals(call.findAnagrams(c.args.s, c.args.p)))
        );
    }
}