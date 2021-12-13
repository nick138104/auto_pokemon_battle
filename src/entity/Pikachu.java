package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.PreRoundActable;

public class Pikachu extends Monster implements PreRoundActable {

	public Pikachu() {
		super("Pikachu", 5, 5, MonsterElement.ELECTRIC, 19);
		// TODO Auto-generated constructor stub
	}

	public void preRoundActs() {
		setAttack(getAttack() + 1);
		setLifepoint(getLifepoint() + 1);

	}

	@Override
	public boolean islevelUp(Monster monster) {
		// TODO Auto-generated method stub
		return false;
	}

}
