package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Squirtle extends Monster implements LevelUpable{

	public Squirtle() {
		super("Squirtle", 2, 4, MonsterElement.WATER);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Squirtle") {
			setName("Wartortle");
			setAttack(getAttack() + 3);
			setLifepoint(getLifepoint() + 3);
		} else if (getName() == "Wartortle") {
			setName("Blastoise");
			setAttack(getAttack() + 3);
			setLifepoint(getLifepoint() + 3);
		}

	}

}
