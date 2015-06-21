package com.kademika.day8.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HowToDraw extends JPanel {
	
	static Color top = Color.BLUE;
	static Color up = Color.YELLOW;
	
	public HowToDraw() {
		JFrame jf = new JFrame("Lesson 8 2D Graphics");
		jf.setLocation(750, 150);
		jf.setMinimumSize(new Dimension(600, 400));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().add(this);
		
		jf.pack();
		jf.setVisible(true);
		
//		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(top);
		g.fillRect(50, 50, 500, 300);
		
		g.setColor(up);
		g.fillRect(50, 200, 500, 150);
		
	}
	
	public static void main(String[] args) throws Exception {
		HowToDraw htd = new HowToDraw();
		
		System.out.println("Ukraine");
		
		Thread.sleep(5000);
		
		System.out.println("Poland");
		
		top = Color.WHITE;
		up = Color.RED;
		
		htd.repaint();
		
	}
}
