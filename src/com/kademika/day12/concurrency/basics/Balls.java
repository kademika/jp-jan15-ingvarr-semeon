package com.kademika.day12.concurrency.basics;

import javax.swing.*;
import java.awt.*;

public class Balls extends JPanel {

    public static void main(String[] args) {
        new Balls();
    }

    private static final int WIDTH = 400;

    private static final Color[] COLORS = new Color[] {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE,
            Color.WHITE,
            Color.BLACK
    };

    //private List<Ball> balls;

    public Balls() {
        JFrame frame = new JFrame("BALLS");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);


    }


}
