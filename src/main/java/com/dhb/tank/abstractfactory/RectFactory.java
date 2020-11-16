package com.dhb.tank.abstractfactory;


public class RectFactory extends GameFactory {

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		return new RectTank(x, y, dir, group, tf);
	}

	@Override
	public BaseExplode createExplote(int x, int y, boolean living, TankFrame tf) {
		return new RectExplode(x, y, living, tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		return new RectBullet(x, y, dir, group, tf);
	}
}
