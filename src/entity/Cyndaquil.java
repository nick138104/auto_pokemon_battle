package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Cyndaquil extends Monster {

	public Cyndaquil() {
		super("Cyndaquil", 5, 3, MonsterElement.FIRE, 12);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Cyndaquil")) {
			monster.setName("Quilava");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(13);
			return true;
		} else if (monster.getName().equals("Quilava")) {
			monster.setName("Typhlosion");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(14);
			return true;
		}
		return false;
	}
}
