package com.learnboot.demo.test.thread.e1_abc;

/**
 * 1.交替打印ABC
 * Synchronized同步法
 */
public class RunSynch {


    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Object C = new Object();
        Object D = new Object();
        ABC_Synch threadA = new ABC_Synch("A", D, A);
        ABC_Synch threadB = new ABC_Synch("B", A, B);
        ABC_Synch threadC = new ABC_Synch("C", B, C);
        ABC_Synch threadD = new ABC_Synch("D", C, D);

        try {
            new Thread(threadA).start();
            Thread.sleep(1000);
            new Thread(threadB).start();
            Thread.sleep(1000);
            new Thread(threadC).start();
            Thread.sleep(1000);
            new Thread(threadD).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
