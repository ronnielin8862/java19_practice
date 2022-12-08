package org.example.freePractice.functionalInterface;

public class FunctionImpA implements FunctionInterface{

    @Override
    public Object run(Object o, Object o2) {

        // business logic here
        return  String.valueOf(o) + String.valueOf(o2);
    }
}
