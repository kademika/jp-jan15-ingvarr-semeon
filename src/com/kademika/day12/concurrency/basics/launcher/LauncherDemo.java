package com.kademika.day12.concurrency.basics.launcher;

public class LauncherDemo {

    public static void main(String[] args) {
        System.out.println("Running " + Thread.currentThread().getName() + Thread.currentThread());

        new MyThread().run(); //Running Mythread in main thread

        new MyThread().start(); // Running Mythread in separate thread

        new Thread(new MyRunnable()).start(); // Running MyRunnable in separate thread
    }
}
