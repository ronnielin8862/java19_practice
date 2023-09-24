package org.example.freePractice.concurency.springThreadPool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestConcurency {
    public void print(int m) throws InterruptedException {
        int n = m;
        for (int i = 1 ; i<=2 ;i++){
            System.out.println("thread name = " + Thread.currentThread().getName()+ ", 第" + i+"次， m = " + m);
            Thread.sleep(3000);
        }
    }

    @Test
    public void testPrint() throws InterruptedException {
        ArrayBlockingQueue q = new ArrayBlockingQueue<>(11);
        Executor executor = new ThreadPoolExecutor(2,5,60 ,SECONDS, new LinkedBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

        CompletableFuture c = new CompletableFuture<>();
        for (int i =1; i <= 2; i++){
            int finalI = i;
            c = CompletableFuture.supplyAsync(()->{
                try {
                    Thread.currentThread().setName(String.valueOf(finalI));
                    print(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return null;
            });
            Thread.sleep(1000);
        }
        c.join();

    }
}
