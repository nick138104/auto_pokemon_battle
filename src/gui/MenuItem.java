package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.MarketManager;
import main.Main;
import resource.ResourceHolder;
import scenepackage.SceneManager;

public class MenuItem extends StackPane {

	public MenuItem(String name) {
		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
				new Stop[] { new Stop(0, Color.DARKBLUE), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
						new Stop(1, Color.DARKBLUE) });
		Rectangle bg = new Rectangle(200, 30);
		bg.setOpacity(0.5);
		Text text = new Text(name);
		String font = javafx.scene.text.Font.getFamilies().get(20);
		text.setFill(Color.DARKGREY);
		text.setFont(Font.font(font, FontWeight.SEMI_BOLD, 20));
		setAlignment(Pos.CENTER);
		getChildren().addAll(bg, text);
		setOnMouseEntered(event -> {
			bg.setFill(gradient);
			text.setFill(Color.WHITE);
		});
		setOnMouseExited(event -> {
			bg.setFill(Color.BLACK);
			text.setFill(Color.DARKGREY);
		});
		setOnMousePressed(event -> {
			bg.setFill(Color.DARKVIOLET);
		});

		setOnMouseReleased(event -> {
			bg.setFill(gradient);
			if (name.equals("PLAY")) {
				Main.primaryStage.setScene(SceneManager.game_scene);
				MarketManager.startMarket();
				MarketManager.updateMarket();
				MarketManager.updateBoard();
				ResourceHolder.music.get(0).stop();
				ResourceHolder.music.get(0).play(0.1);
				ResourceHolder.music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
			} else if (name.equals("HOW TO PLAY")) {
				System.out.println("HOW TO PLAY SENCE");
			} else {
				Main.primaryStage.close();
			}
		});

	}
}
