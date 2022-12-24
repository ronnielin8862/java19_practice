package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class ExampleModel {

    private Map<String,String> exampleMap;

    public ExampleModel(){
        exampleMap = new HashMap<>();
    }

    public Map<String, String> getExampleMap() {
        return exampleMap;
    }

    public void setExampleMap(Map<String, String> exampleMap) {
        this.exampleMap = exampleMap;
    }
}
