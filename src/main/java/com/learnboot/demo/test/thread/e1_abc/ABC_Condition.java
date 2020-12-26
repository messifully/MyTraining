package com.learnboot.demo.test.thread.e1_abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC_Condition {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; ) {
                    while (count % 3 != 0) {//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        System.out.println("在这里唤醒");
                        A.await(); // A释放lock锁
                        System.out.println("在这里继续");
                    }
                    System.out.print("A");
                    count++;
                    B.signal(); // A执行完唤醒B线程
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; ) {
                    while (count % 3 != 1) {
                        System.out.println("在这里唤醒");
                        B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                        System.out.println("在这里继续");
                    }
                    System.out.print("B");
                    count++;
                    C.signal();// B执行完唤醒C线程
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; ) {
                    while (count % 3 != 2) {
                        System.out.println("在这里唤醒");
                        C.await();// C释放lock锁
                        System.out.println("在这里继续");
                    }
                    System.out.print("C");
                    count++;
                    A.signal();// C执行完唤醒A线程
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
