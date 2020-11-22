package com.dhb.tank.observer;

import com.dhb.tank.GameModel;
import com.dhb.tank.ProrertyMgr;
import com.dhb.tank.Tank;

public class TankFireHandler  implements TankFireObserver{

	@Override
	public void actionOnFire(TankFireEvent e) {
		Tank t = e.getSource();
		String skey = ProrertyMgr.getString("goodFs");
		t.fire(GameModel.getInstance().getStrategyMap().get(skey));
	}
}
