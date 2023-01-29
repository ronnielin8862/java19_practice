package org.example.freePractice.spring;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SelfAgentImp implements SelfAgent{

    @Override
    public void testAutoWire() {
        System.out.println("success injection in sp");
    }

    @Override
    public void doSomethingAndImportSelf() {
        System.out.println("Start SelfAgent");


        SelfAgent bean = SpringBeanUtil.getBean(SelfAgent.class);


        bean.testAutoWire();
    }
}
