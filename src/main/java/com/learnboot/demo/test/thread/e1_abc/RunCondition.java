package com.learnboot.demo.test.thread.e1_abc;

public class RunCondition {
    public static void main(String[] args) {
        new ABC_Condition.ThreadB().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new ABC_Condition.ThreadA().start();
        new ABC_Condition.ThreadC().start();
    }

}
