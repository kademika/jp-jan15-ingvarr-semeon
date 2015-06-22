package com.kademika.day12.concurrency.basics;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ball extends JComponent {

    private int size = 10; //10x10
    private Color color;

    private int direction = 1; // 1 - right, -1 - left
    private int speed = 20;

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
        if (x == MAXX - size) {
            direction = -1;
        } else if (x == 0) {
            direction = 1;
        }

        x += 5 * direction;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }



    public void setColor(Color color) {
        this.color = color;
    }
}
