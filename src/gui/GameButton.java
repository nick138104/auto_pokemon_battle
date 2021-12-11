package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import main.Main;
import resource.RenderableHolder;
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
		// backButton.setBackground(new Background());
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				backButtonHandler();
			}
		});
		buttons.add(backButton);
	}

	private void initializeRandomButton() {
		Button randomButton = new Button("Random");
		randomButton.setFont(new Font("Serif", 16));
		randomButton.setPrefWidth(90);
		randomButton.setPrefHeight(30);
		// backButton.setBackground(new Background());
		randomButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// backButtonHandler();
			}
		});
		buttons.add(randomButton);
	}

	private void initializeFreezButton() {
		Button freezButton = new Button("FREEZ");
		freezButton.setFont(new Font("Serif", 16));
		freezButton.setPrefWidth(90);
		freezButton.setPrefHeight(30);
		// backButton.setBackground(new Background());
		freezButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// backButtonHandler();
			}
		});
		buttons.add(freezButton);
	}

	private void initializeSellButton() {
		Button sellButton = new Button("FREEZ");
		sellButton.setFont(new Font("Serif", 16));
		sellButton.setPrefWidth(90);
		sellButton.setPrefHeight(30);
		// backButton.setBackground(new Background());
		sellButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// backButtonHandler();
			}
		});
		buttons.add(sellButton);
	}

	private void initializePlayButton() {
		Button playButton = new Button("PLAY");
		playButton.setFont(new Font("Serif", 16));
		playButton.setPrefWidth(90);
		playButton.setPrefHeight(30);
		// backButton.setBackground(new Background());
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// backButtonHandler();
			}
		});
		buttons.add(playButton);
	}

	private void backButtonHandler() {
		Main.primaryStage.setScene(SceneManager.menu_scene);
		RenderableHolder.music.get(0).stop();
		RenderableHolder.music.get(0).play();
		RenderableHolder.music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}
}
