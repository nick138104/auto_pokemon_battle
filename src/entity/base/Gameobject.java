package entity.base;

public abstract class Gameobject {
	
	boolean isFreez;

	public boolean isFreez() {
		return isFreez;
	}

	public void setFreez(boolean isFreez) {
		this.isFreez = isFreez;
	}

	@Override
	public abstract String toString();
	
}
