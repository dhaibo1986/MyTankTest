package com.dhb.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ResourseMgr {

	public static BufferedImage tankL,tankU,tankR,tankD;

	public static BufferedImage bulletL,bulletU,bulletR,bulletD;

	static {
		try {
			tankL = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankL.gif"));
			tankU = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankU.gif"));
			tankR = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankR.gif"));
			tankD = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankD.gif"));

			bulletL = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\bulletL.gif"));
			bulletU = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\bulletU.gif"));
			bulletR = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\bulletR.gif"));
			bulletD = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\bulletD.gif"));


		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
