package com.dhb.tank.decorator;

import com.dhb.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {

	GameObject go;

	public GODecorator(GameObject go) {
		this.go = go;
	}

	@Override
	public void paint(Graphics g) {
		go.paint(g);
	}

}
