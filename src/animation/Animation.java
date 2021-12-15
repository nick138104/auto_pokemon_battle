package animation;

import javafx.animation.AnimationTimer;
import javafx.scene.media.MediaPlayer;
import logic.BattleUtils;
import logic.MarketManager;
import main.Main;
import resource.ResourceHolder;
import scenepackage.SceneManager;

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
			}
		};
		animation.start();
	}

	public static void endBattleSence() {
		ResourceHolder.getInstance().music.get(1).stop();
		animation.stop();
		if (MarketManager.win == 5) {
			Main.primaryStage.setScene(SceneManager.getInstance().win_scene);
			ResourceHolder.getInstance().music.get().play(0.08);
		} else if (MarketManager.health == 0) {
			Main.primaryStage.setScene(SceneManager.getInstance().lose_scene);
			ResourceHolder.getInstance().music.get().play(0.08);
		}
		Main.primaryStage.setScene(SceneManager.getInstance().game_scene);
		ResourceHolder.getInstance().music.get(0).play(0.05);
		ResourceHolder.getInstance().music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
	}
}
