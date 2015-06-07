package com.kademika.day12.concurrency.basics.launcher;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
    }
}
