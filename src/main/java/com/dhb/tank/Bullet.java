package com.dhb.tank;

import java.awt.*;

public class Bullet {

	public static final int SPEED = 10;
	public static final int WIDTH = ResourseMgr.bulletD.getWidth(), HEIGHT = ResourseMgr.bulletD.getHeight();
	private int x;
	private int y;
	private Dir dir;
	private TankFrame tf;
	private Group group = Group.BAD;


	private boolean living = true;

	public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group= group;
	}

	public void die() {
		this.living = false;
		this.tf.bullets.remove(this);
	}

	public static int getSPEED() {
		return SPEED;
	}

	public void paint(Graphics g) {
		switch(dir){
			case LEFT:
				g.drawImage(ResourseMgr.bulletL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourseMgr.bulletR,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResourseMgr.bulletD,x,y,null);
				break;
			case UP:
				g.drawImage(ResourseMgr.bulletU,x,y,null);
				break;

			default:
				break;
		}
		move();
	}

	public void  collideWith(Tank tank) {
		if(this.group == tank.getGroup()) {
			return;
		}
		Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if(rectangle1.intersects(rectangle2)) {
			tank.die();
			this.die();
		}
	}

	private void move() {
		if(!living) {
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
			this.living = false;
		}
	}

	public int getX() {
		return x;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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
