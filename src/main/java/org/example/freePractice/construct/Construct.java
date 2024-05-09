package org.example.freePractice.construct;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Scope("prototype")
public class Construct {
//    private ThreadLocal<String> flag = new ThreadLocal<>(); // todo threadlocal
//    public Construct(String flag){
//        this.flag.set(flag);
//        System.out.println("new flag = " + flag);
//    }
//
//    public String getFlag(){
//        return flag.get();
//    }

    private String flag;

    public Construct(String flag){
        this.flag = flag;
        System.out.println("new flag = " + flag);
    }



    public String getFlag(){
        return flag;
    }
}
