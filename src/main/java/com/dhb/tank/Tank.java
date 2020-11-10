package com.dhb.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
	public static final int SPEED = 5;
	private int x;
	private int y;
	private Dir dir = Dir.DOWN;
	private Random random = new Random();

	Rectangle rect = new Rectangle();

	private Group group = Group.BAD;

	private boolean living = true;

	public static final int WIDTH = ResourseMgr.goodTankU.getWidth();
	public static final int HEIGHT = ResourseMgr.goodTankU.getHeight();

	private boolean moveing = true;

	private TankFrame tf = null;


	public Tank(int x, int y,Dir dir,Group group,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		rect.x = x;
		rect.y = y;
		rect.height = HEIGHT;
		rect.width = WIDTH;
	}

	public void die() {
		this.living = false;
	}

	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
			return;
		}
		switch(dir){
			case LEFT:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.goodTankL:ResourseMgr.badTankL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.goodTankR:ResourseMgr.badTankR,x,y,null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.goodTankD:ResourseMgr.badTankD,x,y,null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.goodTankU:ResourseMgr.badTankU,x,y,null);
				break;

			default:
				break;
		}
		this.move();
	}

	public void fire() {
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add( new Bullet(bX,bY,this.dir,this.group,tf));
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
		rect.x = x;
		rect.y = y;
		if(this.group == Group.BAD && random.nextInt(20) > 18 ){
			this.fire();
		}
		if(this.group == Group.BAD && random.nextInt(20) > 18) {
			randomDir();
		}

		boundsCheck();
	}

	private void boundsCheck() {
		if(this.x < 2) {
			x = 0;
		}
		if(this.y < 28 ) {
			y = 28;
		}
		if(this.x > (TankFrame.GAME_WIDTH-Tank.WIDTH -2)) {
			x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
		}

		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT-2) {
			y = TankFrame.GAME_HEIGHT-Tank.HEIGHT-2;
		}
	}

	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}
	public boolean isMoveing() {
		return moveing;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}
}
