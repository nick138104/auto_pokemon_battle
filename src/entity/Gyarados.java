package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Gyarados extends Monster {

	public Gyarados() {
		super("Gyarados", 4, 6, MonsterElement.WATER, 15);
	}

	public void preRoundActs() {
		setAttack(getAttack() + 1);
		setLifepoint(getLifepoint() + 1);
	}

	public boolean isLevelUp(Monster monster) {
		return false;
	}
}
