package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import logic.MarketManager;

public class GamePane {
	GridPane statPane;
	GridPane gamePane;
	GridPane monsterPane;
	GameButton gameButton;

	public GamePane() {
		gameButton = new GameButton();
		MarketManager.startMarket();
		initializestatPane();
		initializemonsterPane();
		initializegamePane();
	}

	private void initializestatPane() {
		statPane = new GridPane();

	}

	private void initializegamePane() {
		gamePane = new GridPane();
		gamePane.setPrefSize(200, 600);
		gamePane.setHgap(1);
		gamePane.setVgap(10);
		gamePane.add(gameButton.getButtons().get(1), 0, 0);
		MarketPane marketPane = new MarketPane();
		gamePane.add(marketPane, 1, 0);
		gamePane.add(gameButton.getButtons().get(2), 2, 0);
		gamePane.add(gameButton.getButtons().get(3), 3, 0);
		gamePane.add(gameButton.getButtons().get(4), 4, 0);
		gamePane.setTranslateY(400);
	}

	private void initializemonsterPane() {

	}

	public Button getbackButton() {
		return gameButton.getButtons().get(0);
	}

	public GridPane getStatPane() {
		return statPane;
	}

	public GridPane getGamePane() {
		return gamePane;
	}

	public GridPane getMonsterPane() {
		return monsterPane;
	}

}
