package entity.base;

public abstract class Gameobject {

	private boolean isFreez;
	private int id;

	public Gameobject(int id) {
		super();
		setFreez(false);
		setId(id);
	}

	public boolean isFreez() {
		return isFreez;
	}

	public void setFreez(boolean isFreez) {
		this.isFreez = isFreez;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract String toString();
}
