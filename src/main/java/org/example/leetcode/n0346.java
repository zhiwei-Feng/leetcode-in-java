package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class n0346 {
    class MovingAverage {
        private double windowSum;
        private List<Integer> window;
        private int idx;
        private int size;

        public MovingAverage(int size) {
            this.windowSum = 0;
            this.window = new ArrayList<>(size);
            this.idx = 0;
            this.size = size;
        }

        public double next(int val) {
            if (this.window.size() < this.size) {
                this.windowSum += val;
                this.window.add(val);
                return this.windowSum / this.window.size();
            }
            var validIdx = this.idx % this.size;
            this.windowSum += val - window.get(validIdx);
            window.set(validIdx, val);
            this.idx++;
            return this.windowSum / this.size;
        }
    }

}
