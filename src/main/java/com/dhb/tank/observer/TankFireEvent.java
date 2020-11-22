package com.dhb.tank.observer;

import com.dhb.tank.Tank;

public class TankFireEvent {

	Tank tank;

	public TankFireEvent(Tank tank) {
		this.tank = tank;
	}

	public Tank getSource() {
		return tank;
	}
}
