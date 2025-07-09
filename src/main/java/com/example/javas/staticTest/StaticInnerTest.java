package com.example.javas.staticTest;

public class StaticInnerTest {
    int i=0;

    static class Inner {
        int j=0;
        public void display() {
            System.out.println(j);
            System.out.println("Inside static inner class");
        }

        static void display1() {
            System.out.println("Inside static inner class1");
        }
    }

    public static void main(String[] args) {
        Inner.display1();
        Inner inner = new Inner();
        inner.display();
    }

}
