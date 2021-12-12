package entity;

import entity.base.Monster;
import entity.base.MonsterElement;
import interfacepackage.LevelUpable;

public class Torchic extends Monster implements LevelUpable {

	public Torchic() {
		super("Torchic", 5, 5, MonsterElement.FIRE, 26);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {
		// TODO Auto-generated method stub
		if (getName() == "Torchic") {
			setName("Combusken");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 2);
			setId(27);
		} else if (getName() == "Combusken") {
			setName("Blaziken");
			setAttack(getAttack() + 2);
			setLifepoint(getLifepoint() + 2);
			setId(28);
		}

	}

}
