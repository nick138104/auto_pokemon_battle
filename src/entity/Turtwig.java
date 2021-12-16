package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Turtwig extends Monster {

	public Turtwig() {
		super("Turtwig", 5, 7, MonsterElement.PLANT, 35);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Turtwig")) {
			monster.setName("Grotle");
			monster.setAttack(monster.getAttack() + 1);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(36);
			return true;
		} else if (monster.getName().equals("Grotle")) {
			monster.setName("Torterra");
			monster.setAttack(monster.getAttack() + 1);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(37);
			return true;
		}
		return false;
	}
}
