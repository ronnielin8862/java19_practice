package org.example.freePractice.concucrency.heap.wait;

import org.example.model.ExampleModel;

import java.util.List;
import java.util.concurrent.*;

public class HeapA {
    public static void main(String[] args) throws InterruptedException {
        int times = 10;

        List<ExampleModel> exampleModelList = new CopyOnWriteArrayList<>();
        Executor executor = new ThreadPoolExecutor(2, 5, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(11), new ThreadPoolExecutor.AbortPolicy());

        // 觸發wait
        for (int i = 0; i < times; i++) {
            int finalI = i;

            CompletableFuture<ExampleModel> m = CompletableFuture.supplyAsync(() -> {
                System.out.println("3");
                Thread.currentThread().setName("thread "+ finalI);
                ExampleModel exampleModel = new ExampleModel();
                exampleModelList.add(exampleModel);
                try {
                    return new HeapB().wait(exampleModel,exampleModelList);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return exampleModel;
            }, executor);

            System.out.println("開始等待");
            m.thenAccept((ExampleModel exampleModel1) -> {
                System.out.println(Thread.currentThread().getName() + " done");
            });
        }

        System.out.println("2");
        Thread.sleep(1000 * 3);

        // 觸發notify
        for (int i = 0; i < times; i++) {
            int finalI = i;
            try {
                Thread.sleep(500);
                new HeapB().notify(exampleModelList.get(finalI) ,exampleModelList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(1000 * 10);
        // 打印
        for(ExampleModel exampleModel : exampleModelList){
            System.out.println(exampleModel.getExampleMap());
        }
    }
}
