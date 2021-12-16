package entity.base;

import interfacepackage.IRenderable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import resource.ResourceHolder;

public class HitLine extends Gameobject implements IRenderable {
	private boolean isVisible;
	private Point2D pos;

	public HitLine() {
		super(-1);
		setVisible(false);
		setPos(new Point2D(0, 0));
	}

	public int getZ() {
		return 2;
	}

	public void draw(GraphicsContext gc) {
		gc.drawImage(ResourceHolder.getInstance().hitline, pos.getX(), pos.getY(), 70, 70);
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public boolean isDead() {
		return false;
	}

	public String toString() {
		return null;
	}

	public Point2D getPos() {
		return pos;
	}

	public void setPos(Point2D pos) {
		this.pos = pos;
	}
}
