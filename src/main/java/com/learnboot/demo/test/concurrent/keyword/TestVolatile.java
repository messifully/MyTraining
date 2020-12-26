package com.learnboot.demo.test.concurrent.keyword;

public class TestVolatile {
    public static void main(String[] args) {
        Aobing a = new Aobing();
        a.start();
        for (;;) {
            synchronized (a) {
                if (a.isFlag()) {
                    System.out.println("有点东西");
                }
            }

        }
    }
}
