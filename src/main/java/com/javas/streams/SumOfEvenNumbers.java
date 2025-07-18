package com.javas.streams;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = java.util.Arrays.stream(numbers)
                                  .filter(n -> n % 2 == 0)
                                  .sum();
        System.out.println("Sum of even numbers: " + sum);
    }
}
