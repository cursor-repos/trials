package com.example.javas.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitTest {

    public static void main(String[] args) {
        System.out.println("Hi");

        int[] arr = new int[] {1,2,3,4,5};
        for (int i : arr) {
            System.out.println(i);
        }
        Integer[] arr2 = new Integer[]{1,2,3,4,5};

        Stream.of(arr2).filter(n -> n%2 ==0).forEach(System.out::println);

        int[] arr3 = IntStream.range(11,21).toArray();

        Stream.of(arr3).forEach(System.out::println);
        Arrays.stream(arr3).forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Set<Integer> set = Set.of(1,2,3);

        list.set(1, 20);
        list.stream().forEach(System.out::print);

        System.out.printf("Test %S", set.contains(2));
    }
}
