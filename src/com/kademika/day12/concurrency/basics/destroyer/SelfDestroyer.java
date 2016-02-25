package com.kademika.day12.concurrency.basics.destroyer;

public class SelfDestroyer extends Thread {

    private volatile boolean killMe = false;

    public void killMySelf() {
        killMe = true;
    }

    @Override
    public void run() {
        while(!killMe) {
            try {
                System.out.println("Enjoying life:)");
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Life is good. Enjoy your life while you can. Goodbye! (Dying)");
    }
}
