package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Pikachu extends Monster {

	public Pikachu() {
		super("Pikachu", 5, 5, MonsterElement.ELECTRIC, 19);
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
