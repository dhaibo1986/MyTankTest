package com.dhb.tank.abstractfactory;

import com.dhb.tank.*;

import java.awt.*;

public class RectTank  extends BaseTank{


	public RectTank(int x, int y,Dir dir,Group group,TankFrame tf) {
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


	@Override
	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
			return;
		}
		Color c = g.getColor();
		g.setColor(group==Group.BAD?Color.ORANGE:Color.BLUE);
		g.fillRect(x,y,40,40);
		g.setColor(c);
		this.move();
	}


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
		if(this.x > (TankFrame.GAME_WIDTH-Tank.WIDTH -2)) {
			x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
		}

		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT-2) {
			y = TankFrame.GAME_HEIGHT-Tank.HEIGHT-2;
		}
	}

	@Override
	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}

}
