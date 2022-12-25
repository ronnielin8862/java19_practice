package org.example.freePractice.concucrency.heap.wait;

import org.example.model.ExampleModel;

import java.util.List;
import java.util.concurrent.*;

public class HeapA {
    public static void main(String[] args) throws InterruptedException {
        int times = 3000;
        int interval = 100;

        List<ExampleModel> exampleModelList = new CopyOnWriteArrayList<>();
        Executor executor = new ThreadPoolExecutor(10000, 10000, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000), new ThreadPoolExecutor.AbortPolicy());

        // 觸發wait
        for (int i = 0; i < times; i++) {
            int finalI = i;
            Thread.sleep(interval);
            CompletableFuture<ExampleModel> m = CompletableFuture.supplyAsync(() -> {
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

            m.thenAccept((ExampleModel exampleModel1) -> {
                System.out.println(Thread.currentThread().getName() + " done");
            });
        }

        System.out.println("開始等待");
        Thread.sleep(1000 * 180);

        // 觸發notify
        for (int i = 0; i < times; i++) {
            int finalI = i;
            Thread.sleep(interval);
            try {
                new HeapB().notify(exampleModelList.get(finalI) ,exampleModelList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(1000 * 10000);
        System.out.println("結束");
        // 打印
//        for(ExampleModel exampleModel : exampleModelList){
//            System.out.println(exampleModel.getExampleMap());
//        }
    }
}
