package org.example.freePractice.construct;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GetConstruct {
    @Autowired
    BeanFactory beanFactory;

    // 這裡成功的創建了在spring託管下，初始化並獲取建構子類且入參為基本類型的範例
    // 由於基本類型並不由spring託管，因此常規初始化下會出現異常。 這裡成功關鍵是將建構子方法懶加載
    // 並在調用處由spring context獲取
    @PostConstruct
    public void testGetConstruct(){
        String flag = "A";
        Construct construct = beanFactory.getBean(Construct.class,flag);

        System.out.println("flag = "+construct.getFlag());
    }
}
