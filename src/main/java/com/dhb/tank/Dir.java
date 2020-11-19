package com.dhb.tank;

public enum Dir {
	LEFT,RIGHT,DOWN,UP;

	public static Dir getOppositeDir(Dir dir) {
		if(dir == LEFT) {
			return RIGHT;
		} else if (dir == RIGHT) {
			return LEFT;
		} else if (dir == UP) {
			return DOWN;
		}else if(dir == DOWN) {
			return UP;
		}else {
			return DOWN;
		}
	}
}
