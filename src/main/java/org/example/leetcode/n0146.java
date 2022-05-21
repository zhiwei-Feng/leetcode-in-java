package org.example.leetcode;

import java.util.HashMap;

public class n0146 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }

        public Node() {
        }
    }

    class LRUCache {
        private int size;
        private Node head;
        private Node tail;
        private HashMap<Integer, Node> keyMap;

        public LRUCache(int capacity) {
            this.size = capacity;
            this.keyMap = new HashMap<>();
            this.head = new Node();
            this.tail = new Node();

            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public int get(int key) {
            if (!this.keyMap.containsKey(key)) return -1;
            var keyNode = this.keyMap.get(key);
            moveToHead(keyNode);
            return keyNode.val;
        }

        public void put(int key, int value) {
            if (this.keyMap.containsKey(key)) {
                var keyNode = this.keyMap.get(key);
                keyNode.val = value;
                moveToHead(keyNode);
            } else {
                var newNode = new Node(key, value);
                if (this.keyMap.size() == this.size) {
                    // cache is full;
                    var delNode = removeTail();
                    this.keyMap.remove(delNode.key);
                }
                addToHead(newNode);
                this.keyMap.put(key, newNode);
            }
        }

        void removeNode(Node cur) {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }

        void addToHead(Node cur) {
            cur.next = this.head.next;
            cur.prev = this.head;
            this.head.next.prev = cur;
            this.head.next = cur;
        }

        void moveToHead(Node cur) {
            removeNode(cur);
            addToHead(cur);
        }

        Node removeTail() {
            var delTail = this.tail.prev;
            var newTail = delTail.prev;
            this.tail.prev = newTail;
            newTail.next = this.tail;
            return delTail;
        }
    }
}
