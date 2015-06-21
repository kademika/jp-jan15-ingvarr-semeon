package com.kademika.day8.tanksgame.bf.tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.kademika.day8.tanksgame.Direction;
import com.kademika.day8.tanksgame.bf.BattleField;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf) {
		super(bf, 512, 448, Direction.UP);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
		setImage();
	}
	
	public T34(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
		setImage();
	}
	
	private void setImage() {
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("tanks_img/green-top.png").getAbsoluteFile());
			images[1] = ImageIO.read(new File("tanks_img/green-bottom.png").getAbsoluteFile());
			images[2] = ImageIO.read(new File("tanks_img/green-left.png").getAbsoluteFile());
			images[3] = ImageIO.read(new File("tanks_img/green-right.png").getAbsoluteFile());
		} catch (IOException e) {
			throw new IllegalStateException("(!)Can't find tank's image(!)");
		}	
	}

	private Object[] actoins = new Object[] {
			Action.TURN_LEFT,
			Action.MOVE,
			Action.FIRE,
			Action.MOVE,
			Action.FIRE,
			Action.FIRE
		};
		
	private int step = 0;
		
	@Override
	public Action setUp() {
		if (step >= actoins.length) {
			step = 0;
		}
		if (!(actoins[step] instanceof Action)) {
			turn((Direction) actoins[step++]);
		}
		if (step >= actoins.length) {
			step = 0;
		}
		return (Action) actoins[step++];
	}
}
