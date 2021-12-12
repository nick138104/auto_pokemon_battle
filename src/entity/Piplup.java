package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Piplup extends Monster implements LevelUpable{

	public Piplup() {
		super("Piplup", 6, 6, MonsterElement.WATER);
		// TODO Auto-generated constructor stub
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Piplup") {
			setName("Prinplup");
			setAttack(getAttack() + 1);
			setLifepoint(getLifepoint() + 2);
		} else if (getName() == "Prinplup") {
			setName("");
			setAttack(getAttack() + 1);
			setLifepoint(getLifepoint() + 2);
		}
	}

}
