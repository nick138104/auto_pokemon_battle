package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Mudkip extends Monster {

	public Mudkip() {
		super("Mudkip", 4, 6, MonsterElement.WATER, 16);
		// TODO Auto-generated constructor stub
	}

	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Mudkip")) {
			monster.setName("Marshtomp");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 2);
			monster.setId(17);
			return true;
		} else if (monster.getName().equals("Marshtomp")) {
			monster.setName("Swampert");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 2);
			monster.setId(18);
			return true;
		}
		return false;
	}
}
