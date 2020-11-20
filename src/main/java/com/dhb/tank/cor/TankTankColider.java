package com.dhb.tank.cor;

import com.dhb.tank.GameObject;
import com.dhb.tank.Tank;

public class TankTankColider implements Colider {

	@Override
	public boolean colide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tank && o2 instanceof Tank) {
			Tank t1 = (Tank) o1;
			Tank t2 = (Tank) o2;
			if (t1.getRect().intersects(t2.getRect())) {
				t1.back();
				t2.back();
			}
		} else  {
			return true;
		}
		return true;
	}
}
