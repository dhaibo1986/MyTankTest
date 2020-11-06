package com.dhb.tank;

import java.awt.*;

public class Bullet {

	public static final int SPEED = 10;
	public static final int WIDTH = 30, HEIGHT = 30;
	private int x;
	private int y;
	private Dir dir;
	private TankFrame tf;


	private boolean live = true;

	public Bullet(int x, int y, Dir dir,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}

	private void move() {
		if(!live) {
			tf.bullets.remove(this);
		}
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

		if(x<0 || y<0 || x > TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
			this.live = false;
		}
	}

	public int getX() {
		return x;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
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
