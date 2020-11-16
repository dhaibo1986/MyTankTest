package com.dhb.tank.abstractfactory;


import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		tf.strategyMap.put(FourDirFireStrategy.class.getSimpleName(), FourDirFireStrategy.getInstance());
		tf.strategyMap.put(DefaultFireStrategy.class.getSimpleName(), DefaultFireStrategy.getInstance());

		int initTankCount = Integer.parseInt((String) ProrertyMgr.get("initTankCount"));
		//初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			tf.tanks.add(tf.gf.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
//			tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
		}


		new Thread(() -> new Audio("audio/war1.wav").loop()).start();
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(50);
				tf.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
