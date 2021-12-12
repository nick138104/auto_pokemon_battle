package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Bulbasaur extends Monster implements LevelUpable{

	public Bulbasaur() {
		super("Bulbasaur", 3, 3, MonsterElement.PLANT);
		// TODO Auto-generated constructor stub
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Bulbasuar") {
			setName("Ivysaur");
			setAttack(getAttack() + 3);
			setLifepoint(getLifepoint() + 3);
		} else if (getName() == "Ivysaur") {
			setName("Venusaur");
			setAttack(getAttack() + 3);
			setLifepoint(getLifepoint() + 3);
		}
		
	}
	
}
