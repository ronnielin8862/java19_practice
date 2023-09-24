package org.example.freePractice.concurency.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TriggerMaxThreadPool {
    public static void main(String[] args) {
        ArrayBlockingQueue q = new ArrayBlockingQueue<>(11);
        Executor executor = new ThreadPoolExecutor(2, 5, 10L,
                TimeUnit.SECONDS, q, new ThreadPoolExecutor.AbortPolicy());

        System.out.println("q size 1 = " + q.size());

        for (int i = 0; i < 9; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("q size 2 = " + q.size());
    }
}
