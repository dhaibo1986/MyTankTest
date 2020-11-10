package com.dhb.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

	public static final int SPEED = 10;
	Tank myTank = new Tank(200, 400, Dir.UP,Group.GOOD,this);
	List<Bullet> bullets = new ArrayList<>();
	List<Tank>  tanks = new ArrayList<>();
	List<Explode> explodes = new ArrayList<>();


	public static final int GAME_WIDTH = ProrertyMgr.getInt("gameWidth");
	public static final int GAME_HEIGHT = ProrertyMgr.getInt("gameHeight");



	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(new MyKeyListener());
	}

	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0,null);
	}

	@Override
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

	class MyKeyListener extends KeyAdapter {

		boolean BL = false;
		boolean BR = false;
		boolean BU = false;
		boolean BD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getExtendedKeyCode();
			switch (key) {
				case KeyEvent.VK_LEFT:
					BL = true;
					break;
				case KeyEvent.VK_UP:
					BU = true;
					break;
				case KeyEvent.VK_DOWN:
					BD = true;
					break;
				case KeyEvent.VK_RIGHT:
					BR = true;
					break;
				default:
					break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getExtendedKeyCode();
			switch (key) {
				case KeyEvent.VK_LEFT:
					BL = false;
					break;
				case KeyEvent.VK_UP:
					BU = false;
					break;
				case KeyEvent.VK_DOWN:
					BD = false;
					break;
				case KeyEvent.VK_RIGHT:
					BR = false;
					break;

				case KeyEvent.VK_CONTROL:
					myTank.fire();
					break;
				default:
					break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if (!BL && !BR && !BU && !BD) {
				myTank.setMoveing(false);
			} else {
				myTank.setMoveing(true);
				if (BL) {
					myTank.setDir(Dir.LEFT);
				}
				if (BR) {
					myTank.setDir(Dir.RIGHT);
				}
				if (BU) {
					myTank.setDir(Dir.UP);
				}
				if (BD) {
					myTank.setDir(Dir.DOWN);
				}

			}
		}
	}
}
