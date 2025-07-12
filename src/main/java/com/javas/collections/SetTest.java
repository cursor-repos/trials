package com.javas.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
        Set<String> ls = new HashSet<>( Arrays.asList("sam", "pam", "ram"));
        Set<String> ls1 = new LinkedHashSet<>();
        Set<String> ls2 = new LinkedHashSet<>(ls);
        Set<String> ls3 = new TreeSet<>(ls);
        ls1 = Set.of("sam", "pam", "ram");

        for (String l : ls) {
            System.out.println(l);
        }
        for (String l : ls1) {
            System.out.println(l);
        }
        for (String l : ls2) {
            System.out.println(l);
        }
        for (String l : ls3) {
            System.out.println(l);
        }

    }
}
