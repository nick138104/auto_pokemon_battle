package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Chimchar extends Monster {

	public Chimchar() {
		super("Chimchar", 7, 5, MonsterElement.FIRE, 9);
		// TODO Auto-generated constructor stub
	}

	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Chimchar")) {
			monster.setName("Monferno");
			monster.setAttack(getAttack() + 1);
			monster.setLifepoint(getLifepoint() + 2);
			monster.setId(10);
			return true;
		} else if (monster.getName().equals("Monferno")) {
			monster.setName("Infernape");
			monster.setAttack(getAttack() + 1);
			monster.setLifepoint(getLifepoint() + 2);
			monster.setId(11);
			return true;
		}
		return false;
	}

}