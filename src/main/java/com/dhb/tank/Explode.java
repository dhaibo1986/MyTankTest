package com.dhb.tank;

import java.awt.*;

public class Explode extends GameObject {

	public static int WIDTH = ResourseMgr.getInstance().getExplodes()[0].getWidth();

	public static int HEIGHT = ResourseMgr.getInstance().getExplodes()[0].getHeight();


	private boolean living = true;


	private int step = 0;

	public Explode(int x, int y, boolean living) {
		this.x = x;
		this.y = y;
		this.living = living;
		GameModel.getInstance().add(this);
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourseMgr.getInstance().getExplodes()[step++], x, y, null);
		if (step >= ResourseMgr.getInstance().getExplodes().length) {
			step = 0;
				GameModel.getInstance().remove(this);
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
}
