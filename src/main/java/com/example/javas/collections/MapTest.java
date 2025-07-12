package com.example.javas.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> ls = new HashMap<>();
        Map<String, String> ls1 = Map.of("k1", "key1", "k2", "key2", "k3", "key3");
        Map<String, String> ls2 = new TreeMap<>(ls1);

        ls1.put("k4", "key4")
        for (Entry l : ls1.entrySet()) {
            System.out.println(l.toString());
        }

        for (Entry l : ls2.entrySet()) {
            System.out.println(l.toString());
        }
    }
}
