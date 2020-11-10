package com.dhb.tank;

import java.io.IOException;
import java.util.Properties;

public class ProrertyMgr {

	static Properties props = new Properties();

	static {
		try {
			props.load(ProrertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object get(String key) {
		if(props == null) {
			return null;
		}
		return props.get(key);
	}

	public static void main(String[] args) {
		System.out.println(ProrertyMgr.get("initTankCount"));
	}
}
