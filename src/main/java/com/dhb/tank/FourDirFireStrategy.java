package com.dhb.tank;

import com.dhb.tank.abstractfactory.BaseBullet;
import com.dhb.tank.abstractfactory.BaseTank;
import com.dhb.tank.abstractfactory.GameFactory;

public class FourDirFireStrategy implements FireStrategy {


	private FourDirFireStrategy() {

	}

	public static FourDirFireStrategy getInstance() {
		return FourDirFireStrategy.Sigleton.INSTANCE.getInstance();
	}

	@Override
	public void fire(BaseTank t) {
		int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
		int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

		Dir[] dirs = Dir.values();
		for (Dir dir : dirs) {
			TankFrame tf = t.getTf();
			GameFactory gf = tf.gf;
			BaseBullet bullet = gf.createBullet(bX, bY, dir, t.getGroup(), t.getTf());
			t.getTf().bullets.add(bullet);
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
