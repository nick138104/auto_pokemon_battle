package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Totodile extends Monster {

	public Totodile() {
		super("Totodile", 4, 4, MonsterElement.WATER, 29);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Totodile")) {
			monster.setName("Croconaw");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(30);
			return true;
		} else if (monster.getName().equals("Croconaw")) {
			monster.setName("Feraligatr");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(31);
			return true;
		}
		return false;
	}
}
