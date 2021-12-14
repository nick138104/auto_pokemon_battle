package animation;

import interfacepackage.IRenderable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import resource.RenderableHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
//		SceneManager.getInstance().graphicsContext.fillRect(455, 400, 60, 60);
//		SceneManager.getInstance().graphicsContext.fillRect(535, 400, 60, 60);
//		SceneManager.getInstance().graphicsContext.setFill(Color.AQUA);
//		SceneManager.getInstance().graphicsContext.fillRect(960, 0, 80, 30);// back button
//		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
//		SceneManager.getInstance().graphicsContext.setFont(new Font("Comic Sans MS", 25));
//		SceneManager.getInstance().graphicsContext.fillText("MENU", 962, 23);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.getZ());
			if (entity.isVisible()) {
				entity.draw(SceneManager.getInstance().graphicsContext);

			}
		}
	}

	public void addListerner() {

	}
}
