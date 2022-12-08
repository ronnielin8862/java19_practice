package org.example.freePractice.functionalInterface;

import java.util.HashMap;
import java.util.Map;

public class FunctionFactory {

    public Map<String,FunctionInterface> getFunctionMap(){

        Map<String,FunctionInterface> functionMap = new HashMap<>();

        FunctionInterface funcA = new FunctionImpA();

        FunctionInterface funcB = new FunctionImpB();

        functionMap.put("A", funcA);

        functionMap.put("B", funcB);

        return functionMap;
    }

}
