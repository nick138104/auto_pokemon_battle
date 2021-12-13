package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Charmander extends Monster {

	public Charmander() {
		super("Charmander", 4, 2, MonsterElement.FIRE, 3);
		// TODO Auto-generated constructor stub
	}

	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Charmander")) {
			monster.setName("Charmeleon");
			monster.setAttack(getAttack() + 3);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(4);
			return true;
		} else if (monster.getName().equals("Charmeleon")) {
			monster.setName("Charlizard");
			monster.setAttack(getAttack() + 3);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(5);
			return true;
		}
		return false;
	}

}
