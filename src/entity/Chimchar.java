package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Chimchar extends Monster implements LevelUpable {

	public Chimchar() {
		super("Chimchar", 7, 5, MonsterElement.FIRE, 9);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Chimchar") {
			setName("Monferno");
			setAttack(getAttack() + 1);
			setLifepoint(getLifepoint() + 2);
			setId(10);
		} else if (getName() == "Monferno") {
			setName("Infernape");
			setAttack(getAttack() + 1);
			setLifepoint(getLifepoint() + 2);
			setId(11);
		}
	}

}