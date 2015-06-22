package com.kademika.day12.concurrency.basics.launcher;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
    }
}