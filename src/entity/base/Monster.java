package entity.base;

public abstract class Monster extends Gameobject {

	private String name;
	private int attack;
	private int lifepoint;
	private MonsterElement element;

	public Monster(String name, int attack, int lifepoint, MonsterElement element) {
		super();
		setName(name);
		setAttack(attack);
		setLifepoint(lifepoint);
		setElement(element);
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

}
