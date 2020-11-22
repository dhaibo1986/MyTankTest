package com.dhb.tank;

import java.awt.*;

public class Bullet extends GameObject{

	public static final int SPEED = 10;
	public static final int WIDTH = ResourseMgr.getInstance().getBulletD().getWidth(),
			HEIGHT = ResourseMgr.getInstance().getBulletD().getHeight();
	Rectangle rect = new Rectangle();
	private Dir dir;
	private Group group = Group.BAD;
	private boolean living = true;

	public Bullet(int x, int y, Dir dir, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		GameModel.getInstance().add(this);
	}

	public static int getSPEED() {
		return SPEED;
	}

	public void die() {
		this.living = false;
		GameModel.getInstance().remove(this);
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
		switch (dir) {
			case LEFT:
				g.drawImage(ResourseMgr.getInstance().getBulletL(), x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourseMgr.getInstance().getBulletR(), x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourseMgr.getInstance().getBulletD(), x, y, null);
				break;
			case UP:
				g.drawImage(ResourseMgr.getInstance().getBulletU(), x, y, null);
				break;

			default:
				break;
		}
		move();
	}

	public void collideWith(Tank tank) {
		if (this.group == tank.getGroup()) {
			return;
		}
		if (this.rect.intersects(tank.getRect())) {
			tank.die();
			this.die();
			int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
			int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
			//重构之后，将add方法放到构造函数中，从而降低耦合
			new Explode(eX, eY, true);
		}
	}

	private void move() {
		if (!living) {
			GameModel.getInstance().remove(this);
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
		this.rect.x = x;
		this.rect.y = y;

		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			this.living = false;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
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

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
