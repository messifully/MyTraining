package com.learnboot.demo.test.thread.e1_abc;

public class RunLockTest {
    public static void main(String[] args) {
        new ABC_LOCK_Test("A", 0).start();
        new ABC_LOCK_Test("B", 1).start();
        new ABC_LOCK_Test("C", 2).start();
    }
}
