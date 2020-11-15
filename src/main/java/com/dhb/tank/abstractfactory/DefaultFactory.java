package com.dhb.tank.abstractfactory;

import com.dhb.tank.*;

public class DefaultFactory extends GameFactory{


	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		return new DefaultTank(x,y,dir,group,tf);
	}

	@Override
	public BaseExplode createExplote(int x, int y, boolean living, TankFrame tf) {
		return new Explode(x, y, living,tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		return new RectBullet(x,y,dir,group,tf);
	}
}
