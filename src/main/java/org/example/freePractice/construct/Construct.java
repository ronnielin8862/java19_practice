package org.example.freePractice.construct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class Construct {
    private String flag = "";

    public Construct(String flag){
        this.flag = flag;
        System.out.println("new flag = " + flag);
    }

    public String getFlag(){
        return flag;
    }
}
