package org.example.freePractice.getBeanByConstruct;

import org.example.freePractice.construct.Construct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
public class GetBeanByConstruct {

    @Autowired
    BeanFactory beanFactory;

    @Test
    public void testGetConstruct(){
        String flag = "A";
        Construct construct = beanFactory.getBean(Construct.class,flag);

        System.out.println("flag = "+construct.getFlag());
    }
}
