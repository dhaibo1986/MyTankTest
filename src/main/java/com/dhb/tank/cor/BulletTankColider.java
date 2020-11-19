package com.dhb.tank.cor;

import com.dhb.tank.Bullet;
import com.dhb.tank.Explode;
import com.dhb.tank.GameObject;
import com.dhb.tank.Tank;

public class BulletTankColider implements Colider {

	@Override
	public boolean colide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet bullet = (Bullet) o1;
			Tank tank = (Tank) o2;
			if (bullet.getGroup() == tank.getGroup()) {
				return false;
			}
			if (bullet.getRect().intersects(tank.getRect())) {
				tank.die();
				bullet.die();
				int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
				int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
				bullet.getGm().add(new Explode(eX, eY, true, bullet.getGm()));
			}
		} else if(o2 instanceof Bullet && o1 instanceof Tank) {
			colide(o2,o1);
		}else  {
			return false;
		}
		return true;
	}
}
