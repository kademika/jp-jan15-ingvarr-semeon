package com.kademika.day12.concurrency.basics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Balls extends JPanel {

    public static void main(String[] args) {
        new Balls();
    }

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private static final Color[] COLORS = new Color[]{
            Color.WHITE,
            Color.GRAY,
            Color.BLACK,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.ORANGE,
            Color.RED,
            Color.MAGENTA
    };

    private ArrayList<Ball> ballList;

    public Balls() {
        JFrame frame = new JFrame("BALLS");
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocation(450,150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        createBalls();
        runAction();
    }

    private void createBalls() {
        ballList = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            Ball ball = new Ball();
            ball.setColor(COLORS[new Random().nextInt(9)]);
            ballList.add(ball);
        }
    }

    private void runAction() {
        for (Ball ball : ballList) {
            BallMovementThread ballMovementThread = new BallMovementThread(ball);
            new Thread(ballMovementThread).start(); //Running ball in separate thread
        }

        while (true) {
            try {
                Thread.sleep(60/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //zeroing drawn component on ContentPane

        g.setColor(new Color(76, 240, 252));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (Ball ball : ballList) {
            ball.draw(g);
        }
    }
}
