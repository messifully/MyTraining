package com.learnboot.demo.test.thread.e1_abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ABC_Condition_Test extends Thread {


    private String letter;
    private int num;
    private Condition self;
    private Condition next;
    private Lock lock;
    private static int state = 0;

    public ABC_Condition_Test (String letter, int num, Condition self, Condition next, Lock lock) {
        this.letter = letter;
        this.num = num;
        this.self = self;
        this.next = next;
        this.lock = lock;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; ) {
            try {
                lock.lock();
                while (state % 3 != num) {
                    self.await();
                }
                System.out.print(letter);
                next.signal();
                state++;
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }





}
