package org.example.leetcode;

import java.util.HashMap;

public class n0460 {
    class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", freq=" + freq +
                    '}';
        }
    }

    class NodeList {
        Node head;
        Node tail;

        public NodeList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public boolean isEmpty() {
            return this.head.next == this.tail;
        }

        public void removeNode(Node cur) {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        }

        public void addToHead(Node cur) {
            cur.next = this.head.next;
            cur.prev = this.head;
            this.head.next.prev = cur;
            this.head.next = cur;
        }

        public Node removeTail() {
            var oldTail = this.tail.prev;
            var newTail = oldTail.prev;
            newTail.next = this.tail;
            this.tail.prev = newTail;
            return oldTail;
        }

        @Override
        public String toString() {
            return "NodeList{" +
                    "head=" + head +
                    ", tail=" + tail +
                    '}';
        }
    }

    class LFUCache {
        private int size;
        private int minFreq;
        private HashMap<Integer, Node> keyMap;
        private HashMap<Integer, NodeList> freqMap;


        public LFUCache(int capacity) {
            this.size = capacity;
            this.minFreq = -1;
            this.keyMap = new HashMap<>();
            this.freqMap = new HashMap<>();
        }

        NodeList newNodeList() {
            return new NodeList(new Node(), new Node());
        }

        private void updateExistedKey(Node keyNode) {
            var keyFreq = keyNode.freq;
            keyNode.freq++;

            // insert to (keyFreq+1)th List and remove from (keyFreq)th List
            if (!this.freqMap.containsKey(keyFreq + 1)) this.freqMap.put(keyFreq + 1, newNodeList());
            // warning: keep remove first
            this.freqMap.get(keyFreq).removeNode(keyNode);
            this.freqMap.get(keyFreq + 1).addToHead(keyNode);
            // update minFreq
            if (this.freqMap.get(keyFreq).isEmpty() && this.minFreq == keyFreq) minFreq++;
        }


        public int get(int key) {
            if (this.size == 0) return -1;
            if (!this.keyMap.containsKey(key)) return -1;
            var keyNode = this.keyMap.get(key);

            updateExistedKey(keyNode);

            return keyNode.val;
        }

        public void put(int key, int value) {
            if (this.size == 0) return;
            if (this.keyMap.containsKey(key)) {
                var keyNode = this.keyMap.get(key);
                keyNode.val = value;
                updateExistedKey(keyNode);
            } else {
                var newNode = new Node(key, value, 1);

                // if it is the first node
                if (this.keyMap.size() == 0) {
                    this.freqMap.put(1, newNodeList());
                }

                // else
                if (this.keyMap.size() == this.size) {
                    var delNode = this.freqMap.get(this.minFreq).removeTail();
                    this.keyMap.remove(delNode.key);
                }
                this.freqMap.get(1).addToHead(newNode);
                this.minFreq = 1;
                this.keyMap.put(key, newNode);
            }
        }
    }
}
