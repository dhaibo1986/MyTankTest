package com.dhb.tank.abstractfactory;

import java.awt.*;
import java.util.Random;

public abstract class BaseTank {

	public static final int SPEED = 5;
	public static final int WIDTH = ResourseMgr.getInstance().getGoodTankU().getWidth();
	public static final int HEIGHT = ResourseMgr.getInstance().getGoodTankU().getHeight();
	Rectangle rect = new Rectangle();
	protected int x;
	protected int y;
	protected Dir dir = Dir.DOWN;
	protected Random random = new Random();
	protected Group group = Group.BAD;
	protected boolean living = true;
	protected boolean moveing = true;

	protected TankFrame tf;


	public abstract void die();

	public abstract void paint(Graphics g);

	public abstract void fire(FireStrategy fireStrategy);


	protected void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}
	public static int getSPEED() {
		return SPEED;
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public abstract Rectangle getRect();


	public void setRect(Rectangle rect) {
		this.rect = rect;
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

	public abstract Dir getDir();


	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}


	public abstract Group getGroup();

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public boolean isMoveing() {
		return moveing;
	}

	public void setMoveing(boolean moveing) {
		this.moveing = moveing;
	}

	public abstract TankFrame getTf();

}
