package animation;

import interfacepackage.IRenderable;
import resource.RenderableHolder;
import scenepackage.SceneManager;

public class GameScreen {

	public void paintComponent() {
		SceneManager.getInstance().graphicsContext.fillRect(20,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(90,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(160,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(230,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(300,400,60,60);
		
		SceneManager.getInstance().graphicsContext.fillRect(455,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(535,400,60,60);
		
		SceneManager.getInstance().graphicsContext.fillRect(970,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(900,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(830,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(760,400,60,60);
		SceneManager.getInstance().graphicsContext.fillRect(690,400,60,60);
		
		SceneManager.getInstance().graphicsContext.fillRect(980,0,70,30);//back button
//		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
//			// System.out.println(entity.getZ());
//			if (true) {
//				//entity.draw(SceneManager.getInstance().graphicsContext);
//				
//			}
//		}
	}
}
