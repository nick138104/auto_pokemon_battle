package entity.base;

import interfacepackage.IRenderable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import logic.BattleUtils;
import resource.ResourceHolder;

public class Monster extends Gameobject implements IRenderable {

	private String name;
	private int attack;
	private int lifepoint;
	private MonsterElement element;
	private Point2D pos;
	private boolean visible;

	public Monster(String name, int attack, int lifepoint, MonsterElement element, int id) {
		super(id);
		setName(name);
		setAttack(attack);
		setLifepoint(lifepoint);
		setElement(element);
		pos = new Point2D(0, 0);
		visible = true;
	}

	public void attack(Monster mon) {
		mon.setLifepoint(mon.getLifepoint() - this.getAttack());
		this.setLifepoint(this.getLifepoint() - mon.getAttack());
	}

	public Monster createCopy() {
		return new Monster(getName(), getAttack(), getLifepoint(), getElement(), getId());
	}

	public void move(int side) {
		// TODO Auto-generated method stub
		double pos_x = pos.getX() + side * 9.5;
		if (side == 1) {
			if (pos_x > BattleUtils.POS_CENTER_LEFT) {
				pos_x = BattleUtils.POS_CENTER_LEFT;
			}
		} else {
			if (pos_x < BattleUtils.POS_CENTER_RIGHT) {
				pos_x = BattleUtils.POS_CENTER_RIGHT;
			}
		}
		pos = new Point2D(pos_x, pos.getY());
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ResourceHolder.getInstance().monster.get(getId()), pos.getX(), pos.getY(), 70, 70);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isDead() {
		return lifepoint <= 0;
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

	public Point2D getPos() {
		return pos;
	}

	public void setPos(Point2D pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String monster = "Name : " + getName() + "\nAttack : " + getAttack() + "\nLifepoint : " + lifepoint
				+ "\nElement : " + getElement();
		return monster;
	}

}
