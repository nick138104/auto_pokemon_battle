package gui;

import java.util.ArrayList;

import animation.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import logic.MarketManager;
import main.Main;
import resource.ResourceHolder;
import scenepackage.SceneManager;

public class GameButton {
	private ArrayList<Button> buttons;

	public GameButton() {
		buttons = new ArrayList<Button>();
		initializeBackButton();
		initializeRandomButton();
		initializeFreezButton();
		initializeSellButton();
		initializePlayButton();
	}

	private void initializeBackButton() {
		Button backButton = new Button("BACK");
		backButton.setFont(new Font("Serif", 16));
		backButton.setPrefWidth(70);
		backButton.setPrefHeight(30);
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Main.primaryStage.setScene(SceneManager.getInstance().menu_scene);
				ResourceHolder.getInstance().music.get(0).stop();
				ResourceHolder.getInstance().music.get(0).play(0.3);
				ResourceHolder.getInstance().music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
			}
		});
		buttons.add(backButton);
	}

	private void initializeRandomButton() {
		Button randomButton = new Button("Random");
		randomButton.setFont(new Font("Serif", 16));
		randomButton.setMinWidth(90);
		randomButton.setPrefHeight(30);
		randomButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (MarketManager.money > 0) {
					MarketManager.randomMarket();
					MarketManager.updateMarket();
					MarketManager.money -= 1;
					MarketManager.updateMoney();
				}
			}
		});
		buttons.add(randomButton);
	}

	private void initializeFreezButton() {
		Button freezButton = new Button("FREEZ");
		freezButton.setFont(new Font("Serif", 16));
		freezButton.setMinWidth(90);
		freezButton.setPrefHeight(30);
		freezButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				MarketManager.freezMarket();
			}
		});
		buttons.add(freezButton);
	}

	private void initializeSellButton() {
		Button sellButton = new Button("SELL");
		sellButton.setFont(new Font("Serif", 16));
		sellButton.setMinWidth(90);
		sellButton.setPrefHeight(30);
		sellButton.setId("5");
		sellButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				MarketManager.setSelectedButton(sellButton);
			}
		});
		buttons.add(sellButton);
	}

	private void initializePlayButton() {
		Button playButton = new Button("PLAY");
		playButton.setFont(new Font("Serif", 16));
		playButton.setMinWidth(90);
		playButton.setPrefHeight(30);
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ResourceHolder.getInstance().music.get(0).stop();
				ResourceHolder.getInstance().music.get(1).play(0.4);
				ResourceHolder.getInstance().music.get(1).setCycleCount(MediaPlayer.INDEFINITE);
				Main.primaryStage.setScene(SceneManager.getInstance().play_scene);
				new Animation();
			}
		});
		buttons.add(playButton);
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}
}
