package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class n0735Test {
    private final n0735 call = new n0735();

    @Test
    void asteroidCollision() {
        class Args {
            final int[] asteroids;

            public Args(int[] asteroids) {
                this.asteroids = asteroids;
            }
        }
        class Case {
            final Args args;
            final int[] expect;

            public Case(Args args, int[] expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args(new int[]{5, 10, -5}), new int[]{5, 10}),
                new Case(new Args(new int[]{8, -8}), new int[]{}),
                new Case(new Args(new int[]{10, 2, -5}), new int[]{10}),
                new Case(new Args(new int[]{-2,-1,1,2}), new int[]{-2,-1,1,2}),
        };
        Arrays.stream(cases).forEach(
                c -> {
                    var actual = call.asteroidCollision(c.args.asteroids);
                    assertEquals(c.expect.length, actual.length);
                    for (int i = 0; i < c.expect.length; i++) {
                        assertEquals(c.expect[i], actual[i]);
                    }
                }
        );
    }
}