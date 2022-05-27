package org.example.leetcode;

public class n0221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        var maxD = 0;
        var maxDs = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    maxDs[i + 1][j + 1] = 0;
                    continue;
                }

                var curD = Math.min(Math.min(maxDs[i + 1][j], maxDs[i][j + 1]), maxDs[i][j]) + 1;
                maxD = Math.max(maxD, curD);
                maxDs[i + 1][j + 1] = curD;
            }
        }


        return maxD * maxD;
    }
}
