package org.example.freePractice.concurency.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TriggerMaxThreadPool {
    public static void main(String[] args) throws InterruptedException {
        TriggerMaxThreadPool triggerMaxThreadPool = new TriggerMaxThreadPool();
        triggerMaxThreadPool.threadPoolExecutor();
    }



    private void threadPoolExecutor(){
        ArrayBlockingQueue q = new ArrayBlockingQueue<>(8);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 10L,
                TimeUnit.SECONDS, q, new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);



        System.out.println("q size 1 = " + q.size());

        for (int i = 0; i < 9; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000 * 2);
                    System.out.println("thead: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("q size 2 = " + q.size());
    }
}
