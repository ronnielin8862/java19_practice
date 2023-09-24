package org.example.freePractice.concurency.heap.wait;

public class waitTime {
    public static void main(String[] args) throws InterruptedException {

        int times = 10;
        String s = "abc";

        for (int i=0 ; i <times ; i++){
            int finalI = i;
            s = s + finalI;
            String finalS = s;
            System.out.println(1);
            new Thread( ()-> {
                System.out.println(2);
                try {
                    System.out.println(3);
                    synchronized (finalS){
                        System.out.println(4);
                        finalS.wait(3000);
                    }
                    System.out.println(finalS + " done");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

//        s.notify();

        Thread.sleep(1000 * 50);
        System.out.println("finish");
    }
}
