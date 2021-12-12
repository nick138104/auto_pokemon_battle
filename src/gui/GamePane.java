package gui;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class GamePane {
	HBox statPane;
	HBox gamePane;
	HBox monsterPane;
	GameButton gameButton;

	public GamePane() {
		gameButton = new GameButton();
		initializestatPane();
		initializegamePane();
		initializemonsterPane();
	}

	private void initializestatPane() {
		statPane = new HBox();
		
	}

	private void initializegamePane() {
		gamePane = new HBox();
		gamePane.setPrefSize(200, 600);
		for (int i = 1; i < gameButton.getButtons().size(); i++) {
			gamePane.getChildren().add(gameButton.getButtons().get(i));
		}
		gamePane.setTranslateY(400);
	}

	private void initializemonsterPane() {

	}

	public Button getbackButton() {
		return gameButton.getButtons().get(0);
	}

	public HBox getStatPane() {
		return statPane;
	}

	public HBox getGamePane() {
		return gamePane;
	}

	public HBox getMonsterPane() {
		return monsterPane;
	}

}
