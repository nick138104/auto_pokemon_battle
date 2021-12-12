package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Charmander extends Monster implements LevelUpable{

	public Charmander() {
		super("Charmander", 4, 2, MonsterElement.FIRE);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Charmander") {
			setName("Charmeleon");
			setAttack(getAttack() + 3);
			setLifepoint(getLifepoint() + 3);
		} else if (getName() == "Charmeleon") {
			setName("Charlizard");
			setAttack(getAttack() + 3);
			setLifepoint(getLifepoint() + 3);
		}
		
	}

	
}
