package entity.base;

import interfacepackage.IRenderable;
import javafx.scene.canvas.GraphicsContext;

public class HitLine extends Gameobject implements IRenderable {

	public HitLine() {
		super(-1);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 10;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
