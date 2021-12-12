package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Totodile extends Monster implements LevelUpable{

	public Totodile() {
		super("Totodile", 4, 4, MonsterElement.WATER);
		// TODO Auto-generated constructor stub
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Totodile") {
			setName("Croconaw");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 3);
		} else if (getName() == "Croconaw") {
			setName("Feraligatr");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 3);
		}
		
	}

}
