package com.dhb.tank.abstractfactory;

import com.dhb.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {

	public static final int SPEED = 10;
	public static final int WIDTH = ResourseMgr.getInstance().getBulletD().getWidth(),
			HEIGHT = ResourseMgr.getInstance().getBulletD().getHeight();
	Rectangle rect = new Rectangle();
	private int x;
	private int y;
	private Dir dir;
	private TankFrame tf;
	private Group group = Group.BAD;
	private boolean living = true;

	public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public void die() {
		this.living = false;
		this.tf.bullets.remove(this);
	}

	@Override
	public void collideWith(BaseTank tank) {
		if (this.group == tank.getGroup()) {
			return;
		}
		if (this.rect.intersects(tank.getRect())) {
			tank.die();
			this.die();
			int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
			int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

			this.tf.explodes.add(this.tf.gf.createExplote(eX, eY, true, this.tf));
		}
	}

	private void move() {
		if (!living) {
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

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}


	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 20, 20);
		move();
	}

}