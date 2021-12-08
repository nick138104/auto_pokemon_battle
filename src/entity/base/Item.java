package entity.base;

public abstract class Item extends Gameobject {

	private String name;

	public Item(String name) {
		super();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
