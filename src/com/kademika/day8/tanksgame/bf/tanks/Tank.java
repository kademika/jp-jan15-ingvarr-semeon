package com.kademika.day8.tanksgame.bf.tanks;

import com.kademika.day8.tanksgame.Direction;
import com.kademika.day8.tanksgame.bf.Destroyable;
import com.kademika.day8.tanksgame.bf.Drawable;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();
	
	public void turn(Direction direction);

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

}
