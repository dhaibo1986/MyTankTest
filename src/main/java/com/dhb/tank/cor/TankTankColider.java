package com.dhb.tank.cor;

import com.dhb.tank.Dir;
import com.dhb.tank.GameObject;
import com.dhb.tank.Tank;

public class TankTankColider implements Colider {

	@Override
	public boolean colide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tank && o2 instanceof Tank) {
			Tank t1 = (Tank) o1;
			Tank t2 = (Tank) o2;
			if (t1.getRect().intersects(t2.getRect())) {
				t1.setX(t1.getOldX());
				t1.setY(t1.getOldY());
				t2.setX(t2.getOldX());
				t2.setY(t2.getOldY());
				t1.setDir(Dir.getOppositeDir(t1.getDir()));
				t2.setDir(Dir.getOppositeDir(t2.getDir()));
			}
		} else  {
			return true;
		}
		return true;
	}
}
