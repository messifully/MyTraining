package com.learnboot.demo.test.thread.e1_abc;

/**
 * 2.交替打印ABC
 * Lock锁方法
 */
public class RunLock {

    public static void main(String[] args) {

        Thread threadA = new ABC_Lock.ThreadA();
        Thread threadB = new ABC_Lock.ThreadB();
        Thread threadC = new ABC_Lock.ThreadC();
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
