package com.dhb.tank;

import java.awt.*;

public class Tank {
	public static final int SPEED = 10;
	private int x;
	private int y;
	private Dir dir = Dir.DOWN;

	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;

	private boolean moveing = false;

	private TankFrame tf = null;


	public Tank(int x, int y,Dir dir,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, WIDTH, HEIGHT);
		this.move();
	}

	public void fire() {
		tf.bullets.add( new Bullet(this.x,this.y,this.dir,tf));
	}

	private void move() {
		if(isMoveing()) {
			switch (dir) {
				case LEFT:
					x -= SPEED;
					break;
				case RIGHT:
					x += SPEED;
					break;
				case UP:
					y -= SPEED;
					break;
				case DOWN:
					y += SPEED;
					break;
				default:
					break;
			}
		}
	}

	public boolean isMoveing() {
		return moveing;
	}

	public void setMoveing(boolean moveing) {
		this.moveing = moveing;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}
}
