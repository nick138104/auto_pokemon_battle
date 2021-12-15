package animation;

import javafx.animation.AnimationTimer;
import logic.BattleUtils;
import resource.RenderableHolder;

public class Animation {

	public Animation() {
		GameScreen gameScreen = new GameScreen();
		BattleUtils logic = new BattleUtils();
		logic.startBattle();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
			}
		};
		animation.start();
	}
}
