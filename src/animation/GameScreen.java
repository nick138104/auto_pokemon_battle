package animation;

import interfacepackage.IRenderable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.BattleUtils;
import resource.RenderableHolder;
import resource.ResourceHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
		Font font1 = Font.font("Comic Sans MS", FontWeight.BOLD, 32);
		Font font2 = Font.font("Comic Sans MS", FontWeight.BOLD, 19);
		SceneManager.getInstance().graphicsContext.drawImage(ResourceHolder.getInstance().background.get(1), 0, 0, 1050,
				600);
		SceneManager.getInstance().graphicsContext.setFont(font1);
		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
		SceneManager.getInstance().graphicsContext.fillText("Your Team", 125, 300);
		SceneManager.getInstance().graphicsContext.fillText("Opponent's Team", 625, 300);
		SceneManager.getInstance().graphicsContext.setFill(Color.HOTPINK);
		SceneManager.getInstance().graphicsContext.fillRect(455, 355, 35, 35);
		SceneManager.getInstance().graphicsContext.fillRect(535, 355, 35, 35);
		SceneManager.getInstance().graphicsContext.setFill(Color.LIGHTGREEN);
		SceneManager.getInstance().graphicsContext.fillRect(490, 355, 35, 35);
		SceneManager.getInstance().graphicsContext.fillRect(570, 355, 35, 35);
		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
		SceneManager.getInstance().graphicsContext.setFont(font2);
		if (BattleUtils.left_health > 0) {
			SceneManager.getInstance().graphicsContext.fillText("" + BattleUtils.left_attack, 460, 381);
			SceneManager.getInstance().graphicsContext.fillText("" + BattleUtils.left_health, 496, 381);
		}
		if (BattleUtils.right_health > 0) {
			SceneManager.getInstance().graphicsContext.fillText("" + BattleUtils.right_attack, 539, 381);
			SceneManager.getInstance().graphicsContext.fillText("" + BattleUtils.right_health, 575, 381);
		}
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible()) {
				entity.draw(SceneManager.getInstance().graphicsContext);
			}
		}
	}
}