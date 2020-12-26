package com.learnboot.demo.test.algorithm.linkedlist;

import lombok.Data;

import java.util.LinkedList;

@Data
public class DListNode {
        int val;
        DListNode prev, next;
        DListNode(int val) {
            this.val = val;
            this.prev = this.next = null;
        }

        public DListNode reverse(DListNode head) {
            DListNode curr = null;
            while (head != null) {
                curr = head;
                head = head.next;
                curr.next = curr.prev;
                curr.prev = head;

            }
            return curr;
        }

        public void add(DListNode dListNode) {
            this.next = dListNode;
            dListNode.prev = this;
        }





}

