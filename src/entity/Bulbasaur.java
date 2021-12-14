package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Bulbasaur extends Monster {

	public Bulbasaur() {
		super("Bulbasaur", 3, 3, MonsterElement.PLANT, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Bulbasaur")) {
			monster.setName("Ivysaur");
			monster.setAttack(monster.getAttack() + 3);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(1);
			return true;
		} else if (monster.getName().equals("Ivysaur")) {
			monster.setName("Venusaur");
			monster.setAttack(monster.getAttack() + 3);
			monster.setLifepoint(monster.getLifepoint() + 3);
			monster.setId(2);
			return true;
		}
		return false;
	}
}
