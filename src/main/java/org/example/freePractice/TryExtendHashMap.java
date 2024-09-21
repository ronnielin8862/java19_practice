package org.example.freePractice;

import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;

public class TryExtendHashMap{

    class ExtendHashMap<K extends Object,V> extends HashMap{

        public ExtendHashMap(){
            put("traceId",MDC.get("traceId"));
            super.put("spanId",MDC.get("spanId"));
            put("test","ABC");
        }

        public void otherTest(K key, V value) {

        }

        @Override
        public Object put(Object key, Object value) {
            if (key != null && key instanceof String && key.equals("spanId"))
                throw new IllegalArgumentException("不可取代 spanId");

            return super.put(key, value);
        }
    }

    public static void testAdd(){
//        for (int i=0;i<10;++i){
//            System.out.println("i = "+i);
//        }
        int i = 0;
        if (i++ >0)
            System.out.println("i = yes");
        int j = 0;
        if (++j >0)
            System.out.println("j = yes");

        System.out.println("i = " + i + ", j = " + j);
    }

    public static void main(String[] args) {
//        testAdd(); // 嘗試 i++, ++i

        testSpecialSymbal(); // 嘗試不用大括號
//        System.out.println(1 & 7775); // 嘗試HashMap內的位運算

//        TryExtendHashMap tryExtendHashMap = new TryExtendHashMap();
//        tryExtendHashMap.testExtendHashMap(); // 實現 透過繼承 HashMap 達成預設值 spanId, 並且禁制更新 spanId
    }

    private static void testSpecialSymbal() {
        if ("E".equals("1"))
            if ("g".equals("r"))
                System.out.println("1");
            else if ("t".equals("t"))
                System.out.println("2");
            else
                System.out.println("3");
        else
            System.out.println("4");
    }

    public void testExtendHashMap(){

        Map<String,String> extendHashMap = new ExtendHashMap();
        extendHashMap.put("YOYOYO","GOGOGO");


        extendHashMap.keySet().stream().forEach(k->{
            System.out.println("key = " + k);
            System.out.println("value = " + extendHashMap.get(k));
        });

        extendHashMap.put("spanId" , "更新成功");

    }
}
