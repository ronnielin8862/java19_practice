package org.example.freePractice.basic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestHashMap {
    @Test
    public void testHashMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");

        System.out.println("value = " + hashMap.get("key1"));

    }

    @Test
    public void testCalculatePosition(){
        int n;
        n = 16;
        int t = (n -1) & 1234567;

        System.out.println("t = " + t);
    }
}
