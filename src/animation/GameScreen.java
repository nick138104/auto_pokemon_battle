package animation;

import interfacepackage.IRenderable;
import resource.RenderableHolder;
import resource.ResourceHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
//		SceneManager.getInstance().graphicsContext.setFill(Color.AQUA);
//		SceneManager.getInstance().graphicsContext.fillRect(960, 0, 80, 30);// back button
//		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
//		SceneManager.getInstance().graphicsContext.setFont(new Font("Comic Sans MS", 25));
//		SceneManager.getInstance().graphicsContext.fillText("MENU", 962, 23);
		SceneManager.getInstance().graphicsContext.drawImage(ResourceHolder.getInstance().background.get(1), 0, 0, 1050,
				600);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible()) {
				entity.draw(SceneManager.getInstance().graphicsContext);
			}
		}
	}

//	public void addListerner() {
//
//	}
}
