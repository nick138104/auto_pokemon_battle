package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Chimchar extends Monster {

	public Chimchar() {
		super("Chimchar", 7, 5, MonsterElement.FIRE, 9);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Chimchar")) {
			monster.setName("Monferno");
			monster.setAttack(monster.getAttack() + 1);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(10);
			return true;
		} else if (monster.getName().equals("Monferno")) {
			monster.setName("Infernape");
			monster.setAttack(monster.getAttack() + 1);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(11);
			return true;
		}
		return false;
	}
}