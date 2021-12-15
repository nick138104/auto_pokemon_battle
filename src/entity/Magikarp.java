package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Magikarp extends Monster {

	public Magikarp() {
		super("Gyarodos", 4, 6, MonsterElement.WATER, 15);
		// TODO Auto-generated constructor stub
	}

	public void preRoundActs() {
		setAttack(getAttack() + 1);
		setLifepoint(getLifepoint() + 1);

	}

	@Override
	public boolean isLevelUp(Monster monster) {
		// TODO Auto-generated method stub
		return false;
	}

}
