package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Turtwig extends Monster {

	public Turtwig() {
		super("Turtwig", 5, 7, MonsterElement.PLANT, 35);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Turtwig")) {
			monster.setName("Grotle");
			monster.setAttack(getAttack() + 1);
			monster.setLifepoint(getLifepoint() + 2);
			monster.setId(36);
			return true;
		} else if (monster.getName().equals("Grotle")) {
			monster.setName("Torterra");
			monster.setAttack(getAttack() + 1);
			monster.setLifepoint(getLifepoint() + 2);
			monster.setId(37);
			return true;
		}
		return false;
	}

}
