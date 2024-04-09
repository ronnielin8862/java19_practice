package org.example.freePractice.concurency.staticMethod;

import org.junit.jupiter.api.Test;

public class concurrentMethodTest {

    @Test
    public void testFail(){
        int i;

//        System.out.println(i);
    }

    @Test
    public void testConcurrentMethod() throws InterruptedException {
        Runnable a = ()->{
            try {
                ConcurrentMethod.testInt(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread aThread = new Thread(a);
        aThread.setName("A 線程");

        Runnable b = ()->{
            try {
                ConcurrentMethod.testInt(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread bThread = new Thread(b);
        bThread.setName("B 線程");

        aThread.start();
        bThread.start();

        Thread.currentThread().setName("C 線程");
        ConcurrentMethod.testInt(3);

        String s = "1" , t = "dd";
    }

}