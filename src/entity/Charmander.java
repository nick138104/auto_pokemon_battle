package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Charmander extends Monster {

	public Charmander() {
		super("Charmander", 4, 2, MonsterElement.FIRE, 3);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Charmander")) {
			monster.setName("Charmeleon");
			monster.setAttack(monster.getAttack() + 3);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(4);
			return true;
		} else if (monster.getName().equals("Charmeleon")) {
			monster.setName("Charlizard");
			monster.setAttack(monster.getAttack() + 3);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(5);
			return true;
		}
		return false;
	}
}
