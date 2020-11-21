package com.dhb.tank.decorator;

import com.dhb.tank.GameModel;
import com.dhb.tank.GameObject;

import java.awt.*;

public class RectDecorator  extends GODecorator{

	public RectDecorator(GameObject go) {
		super(go);
		GameModel.getInstance().add(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.drawRect(super.go.x,super.go.y,this.getWidth()+2,this.getHeight()+2);
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
