package animation;

import interfacepackage.IRenderable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import resource.RenderableHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
		SceneManager.getInstance().graphicsContext.fillRect(20,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(90,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(160,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(230,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(300,390,70,70);
		
		SceneManager.getInstance().graphicsContext.fillRect(455,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(535,390,70,70);
		
		SceneManager.getInstance().graphicsContext.fillRect(970,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(900,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(830,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(760,390,70,70);
		SceneManager.getInstance().graphicsContext.fillRect(690,390,70,70);
		
		SceneManager.getInstance().graphicsContext.fillRect(980,0,70,30);//back button
		
		Font theFont = Font.font("Comic Sans MS", FontWeight.BOLD, 32);
		SceneManager.getInstance().graphicsContext.setFont(theFont);
		
		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
		SceneManager.getInstance().graphicsContext.fillText("Your Team", 125, 300);
		
		SceneManager.getInstance().graphicsContext.setFill(Color.BLACK);
		SceneManager.getInstance().graphicsContext.fillText("Opponent's Team", 725, 300);
		//SceneManager.getInstance().graphicsContext.setStroke(Color.BLACK);
//		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
//			// System.out.println(entity.getZ());
//			if (true) {
//				//entity.draw(SceneManager.getInstance().graphicsContext);
//				
//			}
//		}
	}
}
