package com.dhb.tank;

import java.io.IOException;
import java.util.Properties;
/**
*@author haibo.duan
*@description  静态属性获取，将构造方法设为private，避免其他类将此类实例化
*@date  2020/11/12 19:12
*/
public class ProrertyMgr {

	private ProrertyMgr() {

	}

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

	public static Integer getInt(String key) {
		if(props == null) {
			return null;
		}
		return Integer.parseInt((String)props.get(key));
	}

	public static String getString(String key) {
		if(props == null) {
			return null;
		}
		return (String)props.get(key);
	}

	public static void main(String[] args) {
		System.out.println(ProrertyMgr.get("initTankCount"));
	}
}
