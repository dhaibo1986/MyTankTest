package com.dhb.tank.abstractfactory;


public abstract class GameFactory {
	public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

	public abstract BaseExplode createExplote(int x, int y, boolean living, TankFrame tf);

	public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

}
