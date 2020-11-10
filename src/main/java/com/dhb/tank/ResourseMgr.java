package com.dhb.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ResourseMgr {

	public static BufferedImage goodTankU,goodTankL,goodTankR,goodTankD;
	public static BufferedImage badTankU,badTankL,badTankR,badTankD;

	public static BufferedImage bulletL,bulletU,bulletR,bulletD;

	public static BufferedImage[] explodes = new BufferedImage[16];


	static {
		try {
			badTankU = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU,-90);
			badTankR = ImageUtil.rotateImage(badTankU,90);
			badTankD = ImageUtil.rotateImage(badTankU,180);

			goodTankU = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU,-90);
			goodTankR = ImageUtil.rotateImage(goodTankU,90);
			goodTankD = ImageUtil.rotateImage(goodTankU,180);


			bulletU = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU,-90);
			bulletR = ImageUtil.rotateImage(bulletU,90);
			bulletD = ImageUtil.rotateImage(bulletU,180);

			for(int i=0;i<16;i++) {
				explodes[i] = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\e"+(i+1)+".gif"));
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
