package com.dhb.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {

	@Test
	void test() {
		try {
			BufferedImage image = ImageIO.read(new File("D:\\workspace-mashibing\\MyTankTest\\src\\main\\java\\images\\bulletU.gif"));
			Assertions.assertNotNull(image);
			BufferedImage images = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images\\bulletU.gif"));
			Assertions.assertNotNull(images);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
