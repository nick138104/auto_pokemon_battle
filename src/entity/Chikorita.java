package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Chikorita extends Monster implements LevelUpable{

	public Chikorita() {
		super("Chikorita", 3, 5, MonsterElement.PLANT);
		// TODO Auto-generated constructor stub
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Chikorita") {
			setName("Bayleef");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 3);
		} else if (getName() == "Bayleef") {
			setName("Meganium");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 3);
		}
		
	}

}
