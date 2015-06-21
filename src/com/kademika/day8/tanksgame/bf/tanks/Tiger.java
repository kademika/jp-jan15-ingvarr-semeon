package com.kademika.day8.tanksgame.bf.tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.kademika.day8.tanksgame.Direction;
import com.kademika.day8.tanksgame.bf.BattleField;

public class Tiger extends AbstractTank {
	
	private int armor;
	
	public Tiger(BattleField bf) {
		super(bf);
		this.armor = 1;
		tankColor = new Color(255, 205, 0); //orange
		towerColor = new Color(255, 150, 0); //yellow
		setImage();
	}
	
	public Tiger(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		this.armor = 1;
		tankColor = new Color(255, 205, 0); //orange
		towerColor = new Color(255, 150, 0); //yellow
		setImage();
	}
	
	private void setImage() {
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("tanks_img/yellow-top.png").getAbsoluteFile());
			images[1] = ImageIO.read(new File("tanks_img/yellow-bottom.png").getAbsoluteFile());
			images[2] = ImageIO.read(new File("tanks_img/yellow-left.png").getAbsoluteFile());
			images[3] = ImageIO.read(new File("tanks_img/yellow-right.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find tank's image(!)");
		}	
	}
	
	@Override
	public void destroy() {
		if (armor > 0) {
			armor--;
		} else {
			super.destroy();
		}
	}
	
	@Override
	public Action setUp() {
		return Action.FIRE;
	}
}
