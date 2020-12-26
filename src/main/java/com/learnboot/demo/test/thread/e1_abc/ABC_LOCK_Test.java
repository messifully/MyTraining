package com.learnboot.demo.test.thread.e1_abc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC_LOCK_Test extends Thread{

    private String letter;
    private int num;

    public  static int state = 0 ;

    public static Lock lock = new ReentrantLock();

    public ABC_LOCK_Test(String letter, int num) {
        this.letter = letter;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ) {
            try {
                lock.lock();
                while (state % 3 == num) {
                    System.out.print(letter);
                    state++;
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
