package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class n0953Test {

    private final n0953 call = new n0953();

    @Test
    void isAlienSorted() {
        class Args {
            final String[] words;
            final String order;

            public Args(String[] words, String order) {
                this.words = words;
                this.order = order;
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
                new Case(new Args(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"), true),
                new Case(new Args(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"), false),
                new Case(new Args(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"), false),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.isAlienSorted(c.args.words, c.args.order))
        );
    }
}