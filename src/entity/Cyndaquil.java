package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Cyndaquil extends Monster implements LevelUpable {

	public Cyndaquil() {
		super("Cyndaquil", 5, 3, MonsterElement.FIRE);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Cyndaquil") {
			setName("Quilava");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 3);
		} else if (getName() == "Quilava") {
			setName("Typhlosion");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 3);
		}
	}
}