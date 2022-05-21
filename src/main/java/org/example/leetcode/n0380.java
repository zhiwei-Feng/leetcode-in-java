package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class n0380 {
    class RandomizedSet {

        private ArrayList<Integer> datas;
        private HashMap<Integer, Integer> keys;

        public RandomizedSet() {
            this.datas = new ArrayList<>();
            this.keys = new HashMap<>();
        }

        public boolean insert(int val) {
            if (this.keys.containsKey(val)) return false;
            this.datas.add(val);
            this.keys.put(val, this.datas.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!this.keys.containsKey(val)) return false;
            var delIdx = this.keys.remove(val);
            var lastIdx = this.datas.size() - 1;
            this.datas.set(delIdx, this.datas.get(lastIdx));
            if (delIdx!=lastIdx) this.keys.put(this.datas.get(lastIdx), delIdx);
            this.datas.remove(lastIdx);
            return true;
        }

        public int getRandom() {
            var rand = new Random();
            var idx = rand.nextInt(this.datas.size());
            return this.datas.get(idx);
        }
    }
}
