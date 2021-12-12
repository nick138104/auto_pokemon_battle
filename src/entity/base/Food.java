package entity.base;

public class Food extends Gameobject {

	private String name;
	private int attackBonus;
	private int lifePointBonus;

	public Food(String name, int attackBonus, int lifePointBonus, int id) {
		super(id);
		setName(name);
		this.attackBonus = attackBonus;
		this.lifePointBonus = lifePointBonus;
	}

	public void eatFood(Monster m) {
		m.setAttack(getAttackBonus() + m.getAttack());
		m.setLifepoint(getLifePointBonus() + m.getLifepoint());
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getLifePointBonus() {
		return lifePointBonus;
	}

	public void setLifePointBonus(int lifePointBonus) {
		this.lifePointBonus = lifePointBonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
