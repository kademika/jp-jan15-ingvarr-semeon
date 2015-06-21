package com.kademika.day8.tanksgame.bf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public abstract class SimpleBFObject implements BFObject {

	// current position on BF
	private int x;
	private int y;
	
	protected final int QSIZE = 64;
	
	protected Color color;
	
	protected Image image;

	private boolean isDestroyed = false;
	
	public SimpleBFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!isDestroyed) {
			if (image != null) {
				g.drawImage(image, this.getX(), this.getY(), this.getX() + QSIZE, this.getY() + QSIZE, 
						this.getX(), this.getY(), this.getX() + QSIZE, this.getY() + QSIZE, 
						new ImageObserver() {	
							@Override
							public boolean imageUpdate(Image img, int infoflags, int x, int y,
									int width, int height) {
								return false;
							}
						});
			} else {
				g.setColor(this.color);
				g.fillRect(this.getX(), this.getY(), QSIZE, QSIZE);
			}
		}
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
