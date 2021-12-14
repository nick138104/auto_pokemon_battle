package entity.base;

import interfacepackage.IRenderable;
import javafx.scene.canvas.GraphicsContext;

public class Monster extends Gameobject implements IRenderable {

	private String name;
	private int attack;
	private int lifepoint;
	private MonsterElement element;

	public Monster(String name, int attack, int lifepoint, MonsterElement element, int id) {
		super(id);
		setName(name);
		setAttack(attack);
		setLifepoint(lifepoint);
		setElement(element);
	}

	public void attack(Monster mon) {
		mon.setLifepoint(mon.getLifepoint() - this.getAttack());
		this.setLifepoint(this.getLifepoint() - mon.getAttack());
	}

	public Monster createCopy() {
		return new Monster(getName(), getAttack(), getLifepoint(), getElement(), getId());
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getLifepoint() {
		return lifepoint;
	}

	public void setLifepoint(int lifepoint) {
		this.lifepoint = lifepoint;
	}

	public MonsterElement getElement() {
		return element;
	}

	public void setElement(MonsterElement element) {
		this.element = element;
	}

	public boolean isLevelUp(Monster monster) {
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String monster = "Name : " + getName() + "\nAttack : " + getAttack() + "\nLifepoint : " + lifepoint
				+ "\nElement : ";
		return monster;
	}

}
