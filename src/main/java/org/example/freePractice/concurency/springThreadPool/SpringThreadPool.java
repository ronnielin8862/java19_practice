package org.example.freePractice.concurency.springThreadPool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

@Component
public class SpringThreadPool extends ThreadPoolTaskExecutor {

    public void testSpThreadPool() throws InterruptedException {
        setCorePoolSize(10);
        Queue<Integer> queue = new ConcurrentLinkedQueue<>(){};
        for (int i =0; i <100 ; i++){
            queue.add(i);
        }

        CountDownLatch latch = new CountDownLatch(queue.size());
        System.out.println("size = " + queue.size());

        int qSize = queue.size();
        for (int i = 0; i <= qSize;i++){

            getThreadPoolExecutor().execute(()->{
                System.out.println(queue.poll());
                latch.countDown();
            });
        }

        Thread.sleep(2000);

        latch.await();
        System.out.println("size = " + queue.size());

    }
}
