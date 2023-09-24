package org.example.freePractice.concurency.springThreadPool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSpThreadPool {
    @Autowired
    SpringThreadPool springThreadPool;

    @Test
    public void testSpThreadPool() throws InterruptedException {
        springThreadPool.testSpThreadPool();
    }
}
