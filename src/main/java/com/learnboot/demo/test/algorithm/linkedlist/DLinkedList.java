package com.learnboot.demo.test.algorithm.linkedlist;

public class DLinkedList {

    private DListNode first = null;
    private DListNode last = null;
    private int size = 0;

    public DListNode getLast() {
        return last;
    }

    public void addLast(DListNode node) {
        if (last == null) {
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size ++;
    }

    public int size() {
        return size;
    }
}
