package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Squirtle extends Monster {

	public Squirtle() {
		super("Squirtle", 2, 4, MonsterElement.WATER, 23);
		// TODO Auto-generated constructor stub
	}

	public boolean isLevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Squirtle")) {
			monster.setName("Wartortle");
			monster.setAttack(getAttack() + 3);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(24);
			return true;
		} else if (monster.getName().equals("Wartortle")) {
			monster.setName("Blastoise");
			monster.setAttack(getAttack() + 3);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(25);
			return true;
		}
		return false;
	}
}
