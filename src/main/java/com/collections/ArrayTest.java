package com.collections;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        String[] arr1 = new String[]{"ram", "sam", "pam"};

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
        for( int i: arr) {
            System.out.println(i);
        }
        Arrays.stream(arr1).forEach(e->{ System.out.println(e);});
    }

}
