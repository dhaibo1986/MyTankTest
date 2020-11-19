package com.dhb.tank.strategy;


import com.dhb.tank.*;

public class FourDirFireStrategy implements FireStrategy {


	private FourDirFireStrategy() {

	}

	public static FourDirFireStrategy getInstance() {
		return FourDirFireStrategy.Sigleton.INSTANCE.getInstance();
	}

	@Override
	public void fire(Tank t) {
		int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
		int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

		Dir[] dirs = Dir.values();
		for (Dir dir : dirs) {
			t.getGm().add(new Bullet(bX, bY, dir, t.getGroup(), t.getGm()));
		}
		if (t.getGroup() == Group.GOOD) {
			new Thread(() -> {
				new Audio("audio/tank_fire.wav");
			}).start();
		}
	}


	private enum Sigleton {
		INSTANCE;

		private final FourDirFireStrategy instance;

		Sigleton() {
			instance = new FourDirFireStrategy();
		}

		public FourDirFireStrategy getInstance() {
			return instance;
		}
	}
}
