package com.kademika.day8.tanksgame.bf;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends SimpleBFObject {
	
	public Water(int x, int y) {
		super(x, y);
		try { 
			setImage();
		} catch(IllegalStateException e) {
			color = new Color(0, 0, 255); //blue
		}
	}
	
	private void setImage() {
		try {
			image = ImageIO.read(new File("tanks_img/water_texture.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find brick's image(!)");
		}
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Composite org = g2d.getComposite();
		Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
		g2d.setComposite(translucent);
		g.drawImage(image, this.getX(), this.getY(), this.getX() + QSIZE, this.getY() + QSIZE, 
				this.getX(), this.getY(), this.getX() + QSIZE, this.getY() + QSIZE, 
				new ImageObserver() {	
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y,
							int width, int height) {
						return false;
					}
				});
		g2d.setComposite(org);
	}
}
