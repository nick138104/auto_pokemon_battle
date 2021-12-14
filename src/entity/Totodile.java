package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Totodile extends Monster {

	public Totodile() {
		super("Totodile", 4, 4, MonsterElement.WATER, 29);
		// TODO Auto-generated constructor stub
	}

	public boolean isLevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Totodile")) {
			monster.setName("Croconaw");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(30);
			return true;
		} else if (monster.getName().equals("Croconaw")) {
			monster.setName("Feraligatr");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(31);
			return true;
		}
		return false;
	}
}
