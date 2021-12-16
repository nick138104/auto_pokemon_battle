package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Treecko extends Monster {

	public Treecko() {
		super("Treecko", 6, 4, MonsterElement.PLANT, 32);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Treecko")) {
			monster.setName("Grovyle");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(33);
			return true;
		} else if (monster.getName().equals("Grovyle")) {
			monster.setName("Sceptile");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(34);
			return true;
		}
		return false;
	}
}
