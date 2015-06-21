package com.kademika.day8.tanksgame.bf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends SimpleBFObject {
	
	public Rock(int x, int y) {
		super(x, y);
		try { 
			setImage();
		} catch(IllegalStateException e) {
			color = new Color(100, 100, 100); //dark gray
		}
	}
	
	private void setImage() {
		try {
			image = ImageIO.read(new File("tanks_img/rock_texture.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find brick's image(!)");
		}
	}
}
