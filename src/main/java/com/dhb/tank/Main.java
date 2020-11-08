package com.dhb.tank;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		TankFrame tf = new TankFrame();

		//初始化敌方坦克
		for(int i=0;i<5;i++) {
			tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tf));
		}

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
