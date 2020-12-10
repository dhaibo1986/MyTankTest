package com.dhb.tank.strategy;

import com.dhb.tank.Tank;

import java.io.Serializable;

public interface FireStrategy extends Serializable {

	public void fire(Tank t);
}
