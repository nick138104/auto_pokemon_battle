package entity.base;

import interfacepackage.Consumeable;

public class Food extends Gameobject implements Consumeable {

	private String name;
	private int attackBonus;
	private int lifePointBonus;

	public Food(String name, int attackBonus, int lifePointBonus, int id) {
		super(id);
		setName(name);
		this.attackBonus = attackBonus;
		this.lifePointBonus = lifePointBonus;
	}

	public void eatFood(Monster monster) {
		monster.setAttack(getAttackBonus() + monster.getAttack());
		monster.setLifepoint(getLifePointBonus() + monster.getLifepoint());
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
		String food = "Name : " + getName() + "\nAttack Bonus : " + getAttackBonus() + "\nLifepoint Bonus : " + getLifePointBonus();
		return food;
	}

}
