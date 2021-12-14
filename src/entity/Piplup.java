package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Piplup extends Monster{

	public Piplup() {
		super("Piplup", 6, 6, MonsterElement.WATER, 20);
		// TODO Auto-generated constructor stub
	}

	public boolean isLevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Piplup")) {
			monster.setName("Prinplup");
			monster.setAttack(monster.getAttack() + 1);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(21);
			return true;
		} else if (monster.getName().equals("Prinplup")) {
			monster.setName("Empoleon");
			monster.setAttack(monster.getAttack() + 1);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(22);
			return true;
		}
		return false;
	}
}
