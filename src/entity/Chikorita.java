package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Chikorita extends Monster {

	public Chikorita() {
		super("Chikorita", 3, 5, MonsterElement.PLANT, 6);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Chikorita")) {
			monster.setName("Bayleef");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(7);
			return true;
		} else if (monster.getName().equals("Bayleef")) {
			monster.setName("Meganium");
			monster.setAttack(getAttack() + 2);
			monster.setLifepoint(getLifepoint() + 3);
			monster.setId(8);
			return true;
		}
		return false;
	}

}
