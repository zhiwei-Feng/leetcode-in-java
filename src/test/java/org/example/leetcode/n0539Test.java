package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class n0539Test {

    private final n0539 call = new n0539();

    @Test
    void findMinDifference() {
        class Args {
            final List<String> timePoints;

            public Args(List<String> timePoints) {
                this.timePoints = timePoints;
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
                new Case(new Args(new ArrayList<>(List.of("23:59", "00:00"))), 1),
                new Case(new Args(new ArrayList<>(List.of("00:00", "23:59", "00:00"))), 0),
                new Case(new Args(new ArrayList<>(List.of("00:00","04:00","22:00"))), 120),
        };
        Arrays.stream(cases).forEach(
                c -> assertEquals(c.expect, call.findMinDifference(c.args.timePoints))
        );
    }
}