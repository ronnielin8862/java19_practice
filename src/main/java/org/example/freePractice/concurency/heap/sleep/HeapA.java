package org.example.freePractice.concurency.heap.sleep;

import org.example.model.ExampleModel;

public class HeapA {
    public static void main(String[] args) throws InterruptedException {
        int times = 100000;

        for (int i = 0; i < times; i++) {
            int finalI = i;
            Thread.sleep(500);
            new Thread(()-> {
                try {
                    Thread.currentThread().setName("thread "+ finalI);
                    ExampleModel e = new ExampleModel();
                    e.getExampleMap().put("key1", "value1");
                    System.out.println(Thread.currentThread().getName() + " is processing");
                    Thread.sleep(1000000);
                    System.out.println(Thread.currentThread().getName() + " is done 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
