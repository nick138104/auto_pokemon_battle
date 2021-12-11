package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Mudkip extends Monster implements LevelUpable{

	public Mudkip() {
		super("Mudkip", 4, 6, MonsterElement.WATER);
		// TODO Auto-generated constructor stub
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Mudkip") {
			setName("Marshtomp");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 2);
		} else if (getName() == "Marshtomp") {
			setName("Swampert");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 2);
		}
		
	}

}
