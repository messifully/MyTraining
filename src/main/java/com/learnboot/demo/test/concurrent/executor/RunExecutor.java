package com.learnboot.demo.test.concurrent.executor;

import java.util.concurrent.*;

public class RunExecutor {

    public static void main(String[] args) {

//        TestExecutor executor = new TestExecutor();
//        executor.execute(() -> {System.out.println("你能咋了");});

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(() -> System.out.println("haha"));

        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();
        Future<String> future = executorService.schedule(() -> {
                    System.out.println("sleep");
//                    Thread.sleep(5000);
                    System.out.println("醒了");
                    return "返回值";
                }, 1, TimeUnit.SECONDS
        );
        String s = null;
        try {
            s = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);


    }
}
