package com.dhb.tank;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		TankFrame tf = new TankFrame();

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
