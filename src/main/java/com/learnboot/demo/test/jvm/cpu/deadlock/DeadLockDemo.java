package com.learnboot.demo.test.jvm.cpu.deadlock;

public class DeadLockDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockClass(true));//建立一个线程
        Thread t2 = new Thread(new DeadLockClass(false));//建立另一个线程
        t1.start();//启动一个线程
        t2.start();//启动另一个线程
    }
}


class DeadLockClass implements Runnable {

    Boolean flag;

    public DeadLockClass(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag.equals(true)) {
            System.out.println("t1 prepare to get a-lock");
            while (true) {
                synchronized (Obj.a) {
                    System.out.println("t1  get a-lock");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 prepare to get b-lock");
                    synchronized (Obj.b) {
                        System.out.println("t1  get b-lock");
                    }
                }
            }

        } else {
            System.out.println("t2 prepare to get b-lock");
            while (true) {
                synchronized (Obj.b) {
                    System.out.println("t2  get b-lock");
                    System.out.println("t2 prepare to get a-lock");
                    synchronized (Obj.a) {
                        System.out.println("t2  get a-lock");
                    }
                }
            }

        }
    }
}

class Obj {
     static Object a = new Object();
     static Object b = new Object();
}
