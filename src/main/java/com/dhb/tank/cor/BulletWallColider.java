package com.dhb.tank.cor;

import com.dhb.tank.*;

public class BulletWallColider implements Colider {

	@Override
	public boolean colide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Wall) {
			Bullet bullet = (Bullet) o1;
			Wall wall = (Wall) o2;
			if (bullet.getRect().intersects(wall.getRect())) {
				bullet.die();
				int eX = bullet.getX() + Bullet.WIDTH / 2 - Bullet.WIDTH / 2;
				int eY = bullet.getY() + Bullet.HEIGHT / 2 - Bullet.HEIGHT / 2;
				bullet.getGm().add(new Explode(eX, eY, true, bullet.getGm()));
			}
		} else if(o2 instanceof Bullet && o1 instanceof Wall) {
			colide(o2,o1);
		}
		return true;
	}
}
