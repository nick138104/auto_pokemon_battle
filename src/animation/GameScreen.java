package animation;

import interfacepackage.IRenderable;
import resource.RenderableHolder;
import resource.ResourceHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
		Font theFont = Font.font("Comic Sans MS", FontWeight.BOLD, 32);
		SceneManager.getInstance().graphicsContext.drawImage(ResourceHolder.getInstance().background.get(1), 0, 0, 1050,
				600);
		SceneManager.getInstance().graphicsContext.setFont(theFont);
		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
		SceneManager.getInstance().graphicsContext.fillText("Your Team", 125, 300);
		SceneManager.getInstance().graphicsContext.fillText("Opponent's Team", 625, 300);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible()) {
				entity.draw(SceneManager.getInstance().graphicsContext);
			}
		}
	}