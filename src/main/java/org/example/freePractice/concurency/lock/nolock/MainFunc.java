package org.example.freePractice.concurency.lock.nolock;

public class MainFunc {
    public static void main(String[] args) {
        Function f = new Function();
        for(int i =0; i<100; i++){
            new Thread( ()->{
                for (int j =0; j<500; j++){
                    f.a ++;
                    System.out.println("a = " + f.a);
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
            }).start();
        }
    }
}
