package org.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class n0144Test {

    private final n0144 call = new n0144();

    @Test
    void preorderTraversal() {
        var root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        class Args {
            final TreeNode t;

            public Args(TreeNode root) {
                this.t = root;
            }
        }
        class Case {
            final Args args;
            final Integer[] expect;

            public Case(Args args, Integer[] expect) {
                this.args = args;
                this.expect = expect;
            }
        }

        var cases = new Case[]{
                new Case(new Args(root), new Integer[]{1, 2, 3}),
        };
        Arrays.stream(cases).forEach(
                c -> assertArrayEquals(c.expect, call.preorderTraversal(c.args.t).toArray())
        );
    }
}