package org.example.freePractice.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSelfAgent {
    @Autowired
    SelfAgent selfAgent;

    @Test
    public void TestAutoWire(){
        selfAgent.testAutoWire();
    }

    @Test
    public void TestDoSomethingAndImportSelf(){
        selfAgent.doSomethingAndImportSelf();
    }
}
