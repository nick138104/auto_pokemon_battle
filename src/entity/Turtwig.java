package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Turtwig extends Monster implements LevelUpable {

	public Turtwig() {
		super("Turtwig", 5, 7, MonsterElement.PLANT, 35);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Turtwig") {
			setName("Grotle");
			setAttack(getAttack() + 1);
			setLifepoint(getLifepoint() + 2);
			setId(36);
		} else if (getName() == "Grotle") {
			setName("Torterra");
			setAttack(getAttack() + 1);
			setLifepoint(getLifepoint() + 2);
			setId(37);
		}

	}

}
