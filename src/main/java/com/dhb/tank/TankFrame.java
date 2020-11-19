package com.dhb.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	GameModel gm = new GameModel();

	public static final int SPEED = 10;


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
		gm.paint(g);
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
					String skey = ProrertyMgr.getString("goodFs");
					gm.getMainTank().fire(gm.strategyMap.get(skey));
					break;
				default:
					break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			Tank myTank = gm.getMainTank();
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
