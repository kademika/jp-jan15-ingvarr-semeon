package com.kademika.day12.concurrency.basics;

public class BallMovementThread implements Runnable {

    private Ball ball;

    public BallMovementThread(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while (true) {
            ball.move();
            try {
                Thread.sleep(ball.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
