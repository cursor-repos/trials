package com.java.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class ThreadTest extends Thread{

    public static void main(String[] args){
        System.out.println("hi");

        Runnable rTask1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++){
                    System.out.println(i + " "+ Thread.currentThread().getName());
                }
            }
        };

        Callable cTask1 = new Callable() {
            @Override
            public Integer call() throws Exception {
                for(int i=0; i<3; i++){
                    System.out.println(i + " "+ Thread.currentThread().threadId());
                }
                return 3;
            }
        };

        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(rTask1);
        Thread t2 = new Thread(rTask1);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
//        CompletableFuture<String> future = new CompletableFuture<>();
//
//        future.thenAccept(System.out::println);
//
//        future.complete("Hello, World!");
//
//        future.join();
    }
}
 