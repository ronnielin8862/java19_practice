package org.example.freePractice;

import java.util.concurrent.CompletableFuture;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        int times = 10;

        for (int i=0 ; i <times ; i++){
            int finalI = i;
            CompletableFuture<String> comparableFutureTask = CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread " + finalI + " start");
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Thread " + finalI + " end";
            });
//            comparableFutureTask.thenAccept((String s) -> {
//                System.out.println(s);
//            });
        }

        Thread.sleep(1000 * 10);

//        for (int i=0 ; i <times ; i++){
//            int finalI = i;
//            Thread thread = new Thread(() -> {
//                System.out.println("thread "+ finalI);
//                try {
//                    Thread.sleep(1000 * 3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread.start();
//        }
    }
}
