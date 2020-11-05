package com.dhb.tank;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
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
