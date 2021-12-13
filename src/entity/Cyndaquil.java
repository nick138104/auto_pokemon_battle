package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Cyndaquil extends Monster {

	public Cyndaquil() {
		super("Cyndaquil", 5, 3, MonsterElement.FIRE, 12);
		// TODO Auto-generated constructor stub
	}

	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Cyndaquil")) {
			monster.setName("Quilava");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(13);
			return true;
		} else if (monster.getName().equals("Quilava")) {
			monster.setName("Typhlosion");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(14);
			return true;
		}
		return false;
	}
}
