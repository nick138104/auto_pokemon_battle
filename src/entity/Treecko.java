package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Treecko extends Monster implements LevelUpable{

	public Treecko() {
		super("Treecko", 6, 4, MonsterElement.PLANT);
		// TODO Auto-generated constructor stub
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Treecko") {
			setName("Grovyle");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 2);
		} else if (getName() == "Grovyle") {
			setName("Sceptile");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 2);
		}
		
	}

}
