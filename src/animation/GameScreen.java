package animation;

import interfacepackage.IRenderable;
import resource.RenderableHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
		SceneManager.getInstance().graphicsContext.fillRect(0,0,10,10);
//		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
//			// System.out.println(entity.getZ());
//			if (true) {
//				//entity.draw(SceneManager.getInstance().graphicsContext);
//				
//			}
//		}
	}
}
