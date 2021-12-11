package entity;

import entity.base.Item;
import entity.base.Monster;

public class Food extends Item {

	private int attackBonus;
	private int lifePointBonus;

	public Food(String name, int attackBonus, int lifePointBonus) {
		super(name);
		// TODO Auto-generated constructor stub
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

}
