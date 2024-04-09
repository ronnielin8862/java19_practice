package org.example.freePractice.concurency.staticMethod;

public class ConcurrentMethod {
//    public static int b; // 放在外面會被其他線程改變

    public static int testInt(int a) throws InterruptedException {
        int b;
        System.out.println("Thread :" + Thread.currentThread().getName() + ", entry! a = " + a);
        b = a;
        System.out.println("Thread :" + Thread.currentThread().getName() + ", entry! b = " + b);
        Thread.sleep(1000 * 3);
        System.out.println("Thread :" + Thread.currentThread().getName() + ", finished! a = " + a);
        System.out.println("Thread :" + Thread.currentThread().getName() + ", finished! b = " + b);
        return a;
    }
}
