package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Pikachu extends Monster {

	public Pikachu() {
		super("Pikachu", 5, 5, MonsterElement.ELECTRIC, 19);
	}

	public void preRoundActs() {
		setAttack(getAttack() + 1);
		setLifepoint(getLifepoint() + 1);

	}

	public boolean isLevelUp(Monster monster) {
		return false;
	}

}
