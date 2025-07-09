package com.example.javas.collections;

import java.util.Arrays;
import java.util.List;

public class ListTest {

    List<String> ls = Arrays.asList("sam", "pam", "ram");
    List<String> ls1 = List.of("sam", "pam", "ram");

    public static void main(String[] args) {
        ListTest ob = new ListTest();

        ob.mapOfTest();

//        for (String l : ob.ls) {
//            System.out.println(l);
//        }
//
//        for (int i=0; i< ob.ls1.size(); i++) {
//            if(ob.ls.get(i).equals("sam"))
//                ob.ls.set(i, "Sam");
//            System.out.println(ob.ls.get(i));
//        }
//        for (String l : ob.ls1) {
//            System.out.println(l);
//        }
    }

    public void mapOfTest(){
     //   ls1.add("mutable"); - Throws runtime error
     //   ls1.set(0, "mod");  - Throws run time error
     // mapOf creates an immutable collection, which should not be modified later in the code

        for (String l : ls1) {
            System.out.println(l);
        }
    }
}
