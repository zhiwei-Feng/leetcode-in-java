package org.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class n0347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.freq));
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for (var i : nums) {
            freqCount.put(i, freqCount.getOrDefault(i, 0) + 1);
        }
        freqCount.forEach((key, val) -> q.add(new Element(key, val)));
        while (q.size()>k) {
            q.poll();
        }
        return q.stream().mapToInt(x -> x.value).toArray();
    }

    class Element {
        int value;
        int freq;

        public Element() {
        }

        public Element(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    ", freq=" + freq +
                    '}';
        }
    }
}
