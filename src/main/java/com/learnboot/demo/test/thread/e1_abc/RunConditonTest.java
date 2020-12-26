package com.learnboot.demo.test.thread.e1_abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunConditonTest {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();
        new ABC_Condition_Test("A", 0, A, B, lock).start();
        new ABC_Condition_Test("B", 1, B, C, lock).start();
        new ABC_Condition_Test("C", 2, C, A, lock).start();

    }
}
