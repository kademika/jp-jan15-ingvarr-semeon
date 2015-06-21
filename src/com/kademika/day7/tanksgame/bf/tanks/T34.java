package com.kademika.day7.tanksgame.bf.tanks;

import java.awt.Color;

import com.kademika.day7.tanksgame.Direction;
import com.kademika.day7.tanksgame.bf.BattleField;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf) {
		super(bf, 128, 512, Direction.UP);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
	}
	
	public T34(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(0, 155, 0); //dark green
		towerColor = new Color(255, 200, 0); //yellow
	}

	private Object[] actoins = new Object[] {
		Action.TURN_RIGHT,
		Action.FIRE,
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
