package resource;

import java.util.Collections;
import java.util.Comparator;

import interfacepackage.IRenderable;
import javafx.collections.ObservableList;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private ObservableList<IRenderable> entities;
	private Comparator<IRenderable> comparator;

	public RenderableHolder() {
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}
//
//	public void update() {
//		for (int i = entities.size() - 1; i >= 0; i--) {
//			if (entities.get(i).isDestroyed())
//				entities.remove(i);
//		}
//	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public ObservableList<IRenderable> getEntities() {
		return entities;
	}
}
