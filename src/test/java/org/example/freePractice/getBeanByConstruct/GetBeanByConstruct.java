package org.example.freePractice.getBeanByConstruct;

import org.example.freePractice.construct.Construct;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetBeanByConstruct {

    @Autowired
    BeanFactory beanFactory;

    static Integer a;
    @Value("${some.key: 987}")
    void setA(Integer b){
        a = b;
    }

    @Test
    public void testGetValue(){
        System.out.println("A = " + a);
    }

    @Test
    public void testMultiThreadGetConstruct() throws InterruptedException {

        int times = 100;
        new Thread(()->{
            String flag = "A";
            Construct construct = beanFactory.getBean(Construct.class,flag);
            for (int i = 0; i<= times; i++){
                String returnFlag = construct.getFlag();
                System.out.println("A thread flag = "+returnFlag);
                Assert.assertEquals("NOT EQUAL",returnFlag,flag);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(()->{
            String flag = "B";
            Construct construct = beanFactory.getBean(Construct.class,flag);
            for (int i = 0; i<= times; i++){
                String returnFlag = construct.getFlag();
                System.out.println("B thread flag = "+returnFlag);
                Assert.assertEquals("NOT EQUAL",returnFlag, "AAAA");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        Thread.sleep(2000);
        System.out.println("Finish");
    }

    @Test
    public void testGetConstruct(){
        String flag = "A";
        Construct construct = beanFactory.getBean(Construct.class,flag);
        System.out.println("get = " + construct.getFlag());
    }

}
