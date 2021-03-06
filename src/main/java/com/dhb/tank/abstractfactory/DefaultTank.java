package com.dhb.tank.abstractfactory;

import java.awt.*;
import java.util.Random;

public class DefaultTank extends BaseTank {
	public static final int SPEED = 5;
	private int x;
	private int y;
	private Dir dir = Dir.DOWN;
	private Random random = new Random();

	Rectangle rect = new Rectangle();

	private Group group = Group.BAD;

	private boolean living = true;

	public static final int WIDTH = ResourseMgr.getInstance().getGoodTankU().getWidth();
	public static final int HEIGHT = ResourseMgr.getInstance().getGoodTankU().getHeight();

	private boolean moveing = true;

	private TankFrame tf = null;


	public DefaultTank(int x, int y, Dir dir, Group group, TankFrame tf) {
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

	/*public void die() {
		this.living = false;
	}
*/
	@Override
	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
			return;
		}
		switch(dir){
			case LEFT:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.getInstance().getGoodTankL() :ResourseMgr.getInstance().getBadTankL(),x,y,null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.getInstance().getGoodTankR() :ResourseMgr.getInstance().getBadTankR(),x,y,null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.getInstance().getGoodTankD() :ResourseMgr.getInstance().getBadTankD(),x,y,null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD?ResourseMgr.getInstance().getGoodTankU() :ResourseMgr.getInstance().getBadTankU(),x,y,null);
				break;

			default:
				break;
		}
		this.move();
	}

/*	public Rectangle getRect() {
		return rect;
	}*/

/*	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
*/
	@Override
	public void fire(FireStrategy fireStrategy) {
		fireStrategy.fire(this);
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
			String skey = ProrertyMgr.getString("goodFs");
			this.fire(this.tf.strategyMap.get(skey));
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
		if(this.x > (TankFrame.GAME_WIDTH- DefaultTank.WIDTH -2)) {
			x = TankFrame.GAME_WIDTH - DefaultTank.WIDTH -2;
		}

		if(this.y > TankFrame.GAME_HEIGHT - DefaultTank.HEIGHT-2) {
			y = TankFrame.GAME_HEIGHT- DefaultTank.HEIGHT-2;
		}
	}
/*
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

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}*/

	@Override
	public Group getGroup() {
		return group;
	}
	@Override
	public void die() {
		this.living = false;
	}

	@Override
	public Rectangle getRect() {
		return rect;
	}

	@Override
	public Dir getDir() {
		return dir;
	}
	@Override
	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
}
