package org.example.freePractice.basic;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestTreeMap {
    @Test
    public void testOrder(){
        Map<String,Integer> map = new TreeMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("aa",3);
        map.put("aba",7);
        map.put("bb",4);
        map.put("Aa",5);
        map.put("Bb",6);

        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }

    @Test
    public void testTreeMap(){
        // 自定义比较器：首先按字符串长度排序，然后按字典顺序排序
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int lengthComparison = Integer.compare(s1.length(), s2.length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                }
                return s1.compareTo(s2);
            }
        };

        // 创建TreeMap并使用自定义比较器
        TreeMap<String, Integer> treeMap = new TreeMap<>(customComparator);
        treeMap.put("apple", 1);
        treeMap.put("banana", 2);
        treeMap.put("cherry", 3);
        treeMap.put("date", 4);
        treeMap.put("fig", 5);
        treeMap.put("grape", 6);

        // 打印整个TreeMap
        System.out.println("TreeMap with custom sorting:");
        for (String key : treeMap.keySet()) {
            System.out.println(key + " : " + treeMap.get(key));
        }

        // 范围查找：查找长度在4到6之间的所有键值对
        String fromKey = "aaaa"; // 假设长度4的起始字符串
        String toKey = "zzzzzz"; // 假设长度6的结束字符串
        SortedMap<String, Integer> subMap = treeMap.subMap(fromKey, toKey);

        // 打印范围查找结果
        System.out.println("\nSubMap with keys of length 4 to 6:");
        for (String key : subMap.keySet()) {
            System.out.println(key + " : " + subMap.get(key));
        }
    }
}
