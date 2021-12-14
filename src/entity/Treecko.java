package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Treecko extends Monster {

	public Treecko() {
		super("Treecko", 6, 4, MonsterElement.PLANT, 32);
		// TODO Auto-generated constructor stub
	}

	public boolean isLevelUp(Monster monster) {
		// TODO Auto-generated method stub
		if (monster.getName().equals("Treecko")) {
			monster.setName("Grovyle");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(33);
			return true;
		} else if (monster.getName().equals("Grovyle")) {
			monster.setName("Sceptile");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(34);
			return true;
		}
		return false;
	}

	public Monster createCopy() {
		Monster mon = new Treecko();
		mon.setName(getName());
		mon.setAttack(getAttack());
		mon.setLifepoint(getLifepoint());
		mon.setElement(getElement());
		mon.setId(getId());
		return mon;
	}
}
