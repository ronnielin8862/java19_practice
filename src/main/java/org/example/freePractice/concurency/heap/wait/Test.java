package org.example.freePractice.concurency.heap.wait;

import org.example.model.ExampleModel;

public class Test {
    public static void main(String[] args) {
        ExampleModel e = new ExampleModel();
        e.getExampleMap().put("key1", "value1");
        System.out.println(e.getExampleMap());
    }
}
