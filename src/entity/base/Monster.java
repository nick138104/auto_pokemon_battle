package entity.base;

public abstract class Monster extends Gameobject {

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

	public void attack(Monster m) {
		m.setLifepoint(m.getLifepoint() - this.getAttack());
		this.setLifepoint(this.getLifepoint() - m.getAttack());
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

	public abstract boolean islevelUp(Monster monster);

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String monster = "Name : " + getName() + "\nAttack : " + getAttack() + "\nLifepoint : " + lifepoint
				+ "\nElement : ";
		return monster;
	}

}
