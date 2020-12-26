package com.learnboot.demo.test.thread.e1_abc;

public class ABC_Synch implements Runnable {
        public String name;
        public Object pre;
        public Object self;

        public ABC_Synch(String name, Object pre, Object self) {
            this.name = name;
            this.pre = pre;
            this.self = self;
        }

//        public static int count = 10;
        public  int count = 10;

        @Override
        public void run() {
            while (count > 0) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.print(name);
                        count --;
                        self.notify();
                    }
                    // 确保后面第一个线程拿到此锁，避免pre.wait()之后后面第二个线程拿到此锁导致顺序错误
//                    try {
//                        Thread.sleep(
//                                1000
//                        );
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    try {
                        if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。并让线程唤醒避免一直处于休眠
                            pre.notifyAll();
                        } else {
                            pre.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
