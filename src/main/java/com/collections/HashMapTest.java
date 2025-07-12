package com.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args){
        Map<Integer, String> hm = new HashMap<>();

        hm.put(1, "Adam");
        hm.put(2, "Eve");

        hm.entrySet().stream().forEach(e-> System.out.println(e));

    }
}
