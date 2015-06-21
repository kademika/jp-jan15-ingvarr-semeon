package com.kademika.day8.tanksgame.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends SimpleBFObject {

	public Brick(int x, int y) {
		super(x, y);
		try { 
			setImage();
		} catch(IllegalStateException e) {
			color = new Color(180, 60, 0); //brown
		}
	}
	
	private void setImage() {
		try {
			image = ImageIO.read(new File("tanks_img/bricks_texture.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find brick's image(!)");
		}
	}
}
