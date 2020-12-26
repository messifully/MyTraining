package com.learnboot.demo.test.concurrent.keyword;

public class Aobing extends Thread {

    private  boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag= true;
        System.out.println("flag=" + flag);
    }
}
