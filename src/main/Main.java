package main;

import gui.MenuBox;
import gui.MenuItem;
import gui.Title;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import resource.RenderableHolder;
import scenepackage.SceneManager;

public class Main extends Application {

	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		RenderableHolder.music.get(0).play();
		RenderableHolder.music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("Auto_Pokemon_Battle");
		primaryStage.setResizable(false);
		primaryStage.setScene(SceneManager.menu_scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}