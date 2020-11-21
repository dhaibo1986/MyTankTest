package com.dhb.tank.abstractfactory;


import java.awt.*;

public class RectExplode extends BaseExplode {


	public static int WIDTH = ResourseMgr.getInstance().getExplodes()[0].getWidth();

	public static int HEIGHT = ResourseMgr.getInstance().getExplodes()[0].getHeight();
	TankFrame tf;
	private int x, y;
	private boolean living = true;
	private int step = 0;

	public RectExplode(int x, int y, boolean living, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.living = living;
		this.tf = tf;
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, 10 * step, 10 * step);
		step++;
		if (step >= 5) {
			tf.explodes.remove(this);
		}
		g.setColor(c);

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
