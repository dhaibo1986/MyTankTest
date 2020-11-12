package com.dhb.tank;

import java.awt.*;

public class Explode {

	public static int WIDTH = ResourseMgr.getInstance().getExplodes()[0].getWidth();

	public static int HEIGHT = ResourseMgr.getInstance().getExplodes()[0].getHeight();

	private int x,y;

	private boolean living = true;

	TankFrame tf;

	private int step = 0;

	public Explode(int x, int y, boolean living, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.living = living;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		g.drawImage(ResourseMgr.getInstance().getExplodes()[step++],x,y,null);
		if(step >= ResourseMgr.getInstance().getExplodes().length) {
			step = 0;
			this.tf.explodes.remove(this);
		}
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

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
}
