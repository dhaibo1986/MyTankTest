package com.dhb.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModel {

	Tank myTank = new Tank(200, 400, Dir.UP,Group.GOOD,this);
	List<Bullet> bullets = new ArrayList<>();
	List<Tank>  tanks = new ArrayList<>();
	List<Explode> explodes = new ArrayList<>();

	Map<String,FireStrategy> strategyMap = new HashMap<>();



	public GameModel() {
		strategyMap.put(FourDirFireStrategy.class.getSimpleName(), FourDirFireStrategy.getInstance());
		strategyMap.put(DefaultFireStrategy.class.getSimpleName(), DefaultFireStrategy.getInstance());
		int initTankCount = Integer.parseInt((String) ProrertyMgr.get("initTankCount"));
		//初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			this.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
		}
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量："+bullets.size(),10,60);
		g.drawString("敌方坦克数量："+tanks.size(),10,75);
		g.drawString("爆炸数量："+explodes.size(),10,90);
		g.setColor(c);
		myTank.paint(g);
		for(int i=0;i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
		for(int i=0;i< bullets.size();i++){
			bullets.get(i).paint(g);
		}

		for(int i=0;i<bullets.size();i++) {
			for(int j=0;j<tanks.size();j++) {
				System.out.println("i is ["+i+"] bullets size is ["+bullets.size()+"] j is ["+j+"] + tanks size is ["+tanks.size()+"]");
				if(i<bullets.size()) {
					bullets.get(i).collideWith(tanks.get(j));
				}
			}
		}

		for(int i=0;i<explodes.size();i++) {
			explodes.get(i).paint(g);
		}
	}

	public Tank getMainTank() {
		return myTank;
	}
}
