package org.example.freePractice.concucrency.heap.wait;

import org.example.model.ExampleModel;

import java.util.List;


public class HeapB {
    public ExampleModel wait(ExampleModel exampleModel, List<ExampleModel> exampleModelList) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");

        synchronized(exampleModelList){
            exampleModelList.wait();
        }
//        Thread.sleep(1000 * 3);
        exampleModel.getExampleMap().put("key1", "value1");
        System.out.println(Thread.currentThread().getName() + " processing");
        return exampleModel;
    }

    public void notify(ExampleModel exampleModel,List<ExampleModel> exampleModelList) throws InterruptedException {

        synchronized(exampleModelList){
            exampleModelList.notifyAll();
        }
        System.out.println("Notify");
    }
}
