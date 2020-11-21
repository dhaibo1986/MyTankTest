package com.dhb.tank.decorator;

import com.dhb.tank.GameModel;
import com.dhb.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator {

	public TailDecorator(GameObject go) {
		super(go);
		GameModel.getInstance().add(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawLine(super.go.x,super.go.y,super.go.x+getWidth(),super.go.y+getHeight());
		g.setColor(c);
	}

	@Override
	public int getWidth() {
		return super.go.getWidth();
	}

	@Override
	public int getHeight() {
		return super.go.getHeight();
	}
}
