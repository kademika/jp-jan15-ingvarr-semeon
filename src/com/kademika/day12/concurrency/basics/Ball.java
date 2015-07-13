package com.kademika.day12.concurrency.basics;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ball extends JComponent {

    private int size = 12; //10x10
    private Color color;

    private int directionX = 1; // 1 - right, -1 - left
    private int directionY = 2; // 2 - down, -2  - up
    private long speed = 20; //delay time - the length of time to sleep in milliseconds

    private int x;
    private int y;
    private final int MAXX = 640;
    private final int MAXY = 480;

    public Ball() {
        createRundomBall();
    }

    private void createRundomBall() {
        x = new Random().nextInt(MAXX - size);
        y = new Random().nextInt(MAXY - size);
        speed += new Random().nextInt(20);
    }

    public void move() {
        if (x >= MAXX - size) {
            directionX = -1;
        } else if (x <= 0) {
            directionX = 1;
        } else if (y >= MAXY - size) {
            directionY = -2;
        } else if (y <= 0) {
            directionY = 2;
        }

        x += 5 * directionX;
        y += 5 * directionY;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getSpeed() {
        return speed;
    }
}
