package com.kademika.day8.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel{
	
	private final static String IMAGE_FILE = "All_is_Ok! .jpg";
	
	public Window() {
		JFrame jf = new JFrame("Window");
		jf.setLocation(300, 100);
		jf.setMinimumSize(new Dimension(670, 535)); //What different:  jf.setSize(520, 535); ???
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().add(this);
		
		jf.pack();
		jf.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.draw3DRect(50, 50, 550, 400, false);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
		g.drawString("Hello Java Swing Components", 70, 100);
		
		try {
			g.drawImage(ImageIO.read(new File(IMAGE_FILE)), 250, 200, new ImageObserver() {
				
				@Override
				public boolean imageUpdate(Image img, int infoflags, int x, int y,
						int width, int height) {
					return false;
				}
			});
		} catch (IOException e) {
			System.out.println("Can not find image file:" + IMAGE_FILE);
		}
		
	}

	public static void main(String[] args) {
		Window window = new Window();
		
	}

}
