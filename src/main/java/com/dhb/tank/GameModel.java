package com.dhb.tank;

import com.dhb.tank.cor.ColiderChain;
import com.dhb.tank.strategy.DefaultFireStrategy;
import com.dhb.tank.strategy.FireStrategy;
import com.dhb.tank.strategy.FourDirFireStrategy;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModel implements Serializable {

	static {
		GameModel.getInstance().init();
	}

	Map<String, FireStrategy> strategyMap = new HashMap<>();
	ColiderChain chain = new ColiderChain();
	Tank myTank;
	private List<GameObject> objects = new ArrayList<>();

	private void init() {
		strategyMap.put(FourDirFireStrategy.class.getSimpleName(), FourDirFireStrategy.getInstance());
		strategyMap.put(DefaultFireStrategy.class.getSimpleName(), DefaultFireStrategy.getInstance());
		int initTankCount = Integer.parseInt((String) ProrertyMgr.get("initTankCount"));
		//初始化主战坦克
		myTank = new Tank(200, 400, Dir.UP, Group.GOOD);
		//初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
		}
		//初始化墙
		new Wall(150, 150, 200, 50);
		new Wall(550, 150, 200, 50);
		new Wall(300, 300, 50, 200);
		new Wall(650, 300, 50, 200);
	}

	private GameModel() {

	}

	public static GameModel getInstance() {
		return Sigleton.INSTANCE.getInstance();
	}

	public void add(GameObject go) {
		this.objects.add(go);
	}

	public List<GameObject> getGameObjects() {
		return objects;
	}

	public void remove(GameObject go) {
		this.objects.remove(go);
	}

	public Map<String, FireStrategy> getStrategyMap() {
		return strategyMap;
	}

	public void setStrategyMap(Map<String, FireStrategy> strategyMap) {
		this.strategyMap = strategyMap;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
//		g.drawString("子弹的数量："+bullets.size(),10,60);
//		g.drawString("敌方坦克数量："+tanks.size(),10,75);
//		g.drawString("爆炸数量："+explodes.size(),10,90);
		g.setColor(c);
		myTank.paint(g);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).paint(g);
		}

		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				chain.colide(o1, o2);
			}
		}

		//碰撞逻辑
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);

			}
		}
	}

	public Tank getMainTank() {
		return myTank;
	}

	private enum Sigleton {
		INSTANCE;

		private GameModel instance;


		Sigleton() {
			instance = new GameModel();
		}

		public GameModel getInstance() {
			return instance;
		}

	}

	public void save() {
		File f = new File("e:/test/tank.data");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));) {
			oos.writeObject(myTank);
			oos.writeObject(objects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		File f = new File("e:/test/tank.data");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));){
			myTank = (Tank) ois.readObject();
			objects = (List)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
