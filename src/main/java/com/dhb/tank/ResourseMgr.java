package com.dhb.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ResourseMgr {

	public static BufferedImage tankL,tankU,tankR,tankD;

	static {
		try {
			tankL = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankL.gif"));
			tankU = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankU.gif"));
			tankR = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankR.gif"));
			tankD = ImageIO.read(ResourseMgr.class.getClassLoader().getResourceAsStream("images\\tankD.gif"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
