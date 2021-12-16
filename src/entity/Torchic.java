package entity;

import entity.base.Monster;
import entity.base.MonsterElement;

public class Torchic extends Monster {

	public Torchic() {
		super("Torchic", 5, 5, MonsterElement.FIRE, 26);
	}

	public boolean isLevelUp(Monster monster) {
		if (monster.getName().equals("Torchic")) {
			monster.setName("Combusken");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(27);
			return true;
		} else if (monster.getName().equals("Combusken")) {
			monster.setName("Blaziken");
			monster.setAttack(monster.getAttack() + 2);
			monster.setLifepoint(monster.getLifepoint() + 2);
			monster.setId(28);
			return true;
		}
		return false;
	}
}
