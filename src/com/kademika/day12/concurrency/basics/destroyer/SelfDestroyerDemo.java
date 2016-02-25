package com.kademika.day12.concurrency.basics.destroyer;

public class SelfDestroyerDemo {

    public static void main(String[] args) {
        SelfDestroyer selfDestroyer = new SelfDestroyer();
        selfDestroyer.start();

        try {
            Thread.currentThread().sleep(1000); // sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        selfDestroyer.killMySelf();
        selfDestroyer.interrupt();
    }
}
