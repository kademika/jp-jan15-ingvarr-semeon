package com.kademika.day7.tanksgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.kademika.day7.tanksgame.bf.BFObject;
import com.kademika.day7.tanksgame.bf.BattleField;
import com.kademika.day7.tanksgame.bf.Blank;
import com.kademika.day7.tanksgame.bf.tanks.Action;
import com.kademika.day7.tanksgame.bf.tanks.BT7;
import com.kademika.day7.tanksgame.bf.tanks.Bullet;
import com.kademika.day7.tanksgame.bf.tanks.T34;
import com.kademika.day7.tanksgame.bf.tanks.Tank;

/**
 * Updated to object oriented style.
 * 
 * @version 3.0
 */
public class ActionField extends JPanel {

	private boolean COLORDED_MODE = false;

	private BattleField battleField;
	private Tank defender;
	private Tank aggressor;
	private Bullet bullet;

	/**
	 * Write your code here.
	 */
	void runTheGame() throws Exception {
		while (true) {
			if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
				processAction(aggressor.setUp(), aggressor);
			}
			if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
				processAction(defender.setUp(), defender);
			}
		}
	}
	
	private void processAction(Action a, Tank t) throws Exception {
		if (a == Action.MOVE) {
			try {
				processMove(t);
			} catch (ObstacleException e) {
				processFire(t.fire());
				System.out.println("*Obstacle destroyed*");
			} finally {
			}
		} else if (a == Action.FIRE) {
			processTurn(t);
			processFire(t.fire());
		} else if (a == Action.TURN_DOWN) {
			t.turn(Direction.DOWN);
		} else if (a == Action.TURN_UP) {
			t.turn(Direction.UP);
		} else if (a == Action.TURN_LEFT) {
			t.turn(Direction.LEFT);
		} else if (a == Action.TURN_RIGHT) {
			t.turn(Direction.RIGHT);
		}
	}

	private void processTurn(Tank tank) throws Exception {
		repaint();
	}
	
//	private void processMoveToQuadrant(Tank tank, int v, int h) throws Exception {
//		String targetXY = getQuadrantXY(v, h);
//		int targetX = Integer.parseInt(targetXY.substring(0,
//				targetXY.indexOf("_")));
//		int targetY = Integer.parseInt(targetXY.substring(
//				targetXY.indexOf("_") + 1, targetXY.length()));
//		int stepPixels = 64;
//		int directionX = 0;
//		int directionY = 0;
//		int stepsXQty = 0;
//		int stepsYQty = 0;
//
//		System.out.println("[target coordinates]: " + targetX + ", " + targetY);
//
//		if (tank.getX() < targetX) {
////			directionX = 4; // right
//			tank.turn(Direction.RIGHT);
//			stepsXQty = (targetX - tank.getX()) / stepPixels;
//		} else if (tank.getX() > targetX) {
//			directionX = 3; // left
//			stepsXQty = (tank.getX() - targetX) / stepPixels;
//		}
//
//		if (tank.getY() < targetY) {
////			directionY = 2; // down
//			tank.turn(Direction.DOWN);
//			stepsYQty = (targetY - tank.getY()) / stepPixels;
//		} else if (tank.getY() > targetY) {
////			directionY = 1; // up
//			tank.turn(Direction.UP);
//			stepsYQty = (tank.getY() - targetY) / stepPixels;
//		}
//
//		if (directionX > 0 && stepsXQty > 0) {
//			while (stepsXQty > 0) {
//				//move(directionX);
//				processMove(tank);//
//				stepsXQty -= 1;
//			}
//		}
//
//		if (directionY > 0 && stepsYQty > 0) {
//			while (stepsYQty > 0) {
//				//move(directionY);
//				processMove(tank);//
//				stepsYQty -= 1;
//			}
//		}
//
//		System.out.println("[current coordinates]: " + "tankX = "
//				+ tank.getX() + ", tankY = " + tank.getY());
//
//	}
//	
//	private String getQuadrantXY(int v, int h) {
//		return (v - 1) * 64 + "_" + (h - 1) * 64;
//	}

	private void processMove(Tank tank) throws Exception {
		processTurn(tank);
		Direction direction = tank.getDirection();
		int step = 1;
		
		for (int i = 0; i < tank.getMovePath(); i++) {
			int covered = 0;

			String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
			int v = Integer.parseInt(tankQuadrant.split("_")[0]);
			int h = Integer.parseInt(tankQuadrant.split("_")[1]);

			// check limits x: 0, 513; y: 0, 513
			if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
					|| (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
				System.out.println("[Battlefield Borders] direction: " + direction
						+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				return;
			}
			
			// check next quadrant before move
			if (direction == Direction.UP) {
				v++;
			} else if (direction == Direction.DOWN) {
				v--;
			} else if (direction == Direction.RIGHT) {
				h++;
			} else if (direction == Direction.LEFT) {
				h--;
			}
			BFObject bfobject = battleField.scanQuadrant(v, h);
			if (!(bfobject instanceof Blank) && !bfobject.isDestroyed()) {
//				System.out.println("[illegal move] direction: " + direction
//						+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				throw new ObstacleException();
//				return;
			}
	

			// process move
	
			while (covered < 64) {
				if (direction == Direction.UP) {
					tank.updateY(-step);
	//				System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				} else if (direction == Direction.DOWN) {
					tank.updateY(step);
	//				System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				} else if (direction == Direction.LEFT) {
					tank.updateX(-step);
	//				System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				} else {
					tank.updateX(step);
	//				System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
				}
				covered += step;
	
				repaint();
				Thread.sleep(tank.getSpeed());
			}
		}
	}
	
	private void processFire(Bullet bullet) throws Exception {
		this.bullet = bullet;
		int step = 1;
		while ((bullet.getX() > -14 && bullet.getX() < 590)
				&& (bullet.getY() > -14 && bullet.getY() < 590)) {
			if (bullet.getDirection() == Direction.UP) {
				bullet.updateY(-step);
			} else if (bullet.getDirection() == Direction.DOWN) {
				bullet.updateY(step);
			} else if (bullet.getDirection() == Direction.LEFT) {
				bullet.updateX(-step);
			} else {
				bullet.updateX(step);
			}
			if (processInterception()) {
				bullet.destroy();
			}
			repaint();
			Thread.sleep(bullet.getSpeed());
			if (bullet.isDestroyed()) {
				break;
			}
		}
	}

	private boolean processInterception() {
		String coordinates = getQuadrant(bullet.getX(), bullet.getY());
		int y = Integer.parseInt(coordinates.split("_")[0]);
		int x = Integer.parseInt(coordinates.split("_")[1]);

		if (y >= 0 && y < 9 && x >= 0 && x < 9) {
			BFObject bfObject = battleField.scanQuadrant(y, x);
			if (!bfObject.isDestroyed() && !(bfObject instanceof Blank)) {
				battleField.destroyObject(y, x);
				return true;
			}
			
			// check aggressor
			if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
				aggressor.destroy();
				return true;
			}

			// check aggressor
			if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
				defender.destroy();
				return true;
			}
		}
		return false;
	}
	
	private boolean checkInterception(String object, String quadrant) {
		int oy = Integer.parseInt(object.split("_")[0]);
		int ox = Integer.parseInt(object.split("_")[1]);

		int qy = Integer.parseInt(quadrant.split("_")[0]);
		int qx = Integer.parseInt(quadrant.split("_")[1]);

		if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
			if (oy == qy && ox == qx) {
				return true;
			}
		}
		return false;
	}

	public String getQuadrant(int x, int y) {
		// input data should be correct
		return y / 64 + "_" + x / 64;
	}

	public ActionField() throws Exception {
		battleField = new BattleField();
		defender = new T34(battleField);

		String location = battleField.getAggressorLocation();
		aggressor = new BT7(battleField,
			Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);

		bullet = new Bullet(-100, -100, Direction.NONE);

		JFrame frame = new JFrame("BATTLE FIELD, DAY 7");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.getBfWidth(), battleField.getBfHeight() + 22));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		battleField.draw(g);
		
		defender.draw(g);
		aggressor.draw(g);
		bullet.draw(g);
	}
}