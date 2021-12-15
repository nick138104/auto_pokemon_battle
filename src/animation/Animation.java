package animation;

import javafx.animation.AnimationTimer;
import logic.BattleUtils;
import resource.RenderableHolder;

public class Animation {
	private static GameScreen gameScreen;
	private static BattleUtils logic;
	private static AnimationTimer animation;

	public Animation() {
		gameScreen = new GameScreen();
		logic = new BattleUtils();
	}

	public static void startBattleSence() {
		logic.startBattle();
		animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
			}
		};
		animation.start();
	}

	public static void endBattleSence() {
		animation.stop();
	}
}
