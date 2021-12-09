package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {

	private Parent createContent() {
		Pane root = new Pane();

		root.setPrefSize(1050, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/background_menu.png"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}

		Title title = new Title("Auto Pokemon Battle");
		title.setTranslateX(270);
		title.setTranslateY(200);

		MenuBox vbox = new MenuBox(new MenuItem("PLAY"), new MenuItem("HOW TO PLAY"), new MenuItem("EXIT"));
		vbox.setTranslateX(410);
		vbox.setTranslateY(300);

		root.getChildren().addAll(title, vbox);

		return root;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String path = "res/music_menu.mp3";
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				mediaPlayer.seek(javafx.util.Duration.ZERO);
			}
		});
		mediaPlayer.setAutoPlay(true);
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("Auto_Pokemon_Battle");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static class Title extends StackPane {
		public Title(String name) {

			Text text = new Text(name);
			text.setFill(Color.BLACK);
			text.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, 50));
			text.setStroke(Color.BLANCHEDALMOND);
			text.setStrokeWidth(2);

			setAlignment(Pos.CENTER);
			getChildren().add(text);
		}
	}

	private static class MenuBox extends VBox {
		public MenuBox(MenuItem... items) {
			getChildren().add(createSeperator());

			for (MenuItem item : items) {
				getChildren().addAll(item, createSeperator());
			}
		}

		private Line createSeperator() {
			Line sep = new Line();
			sep.setEndX(210);
			sep.setStroke(Color.BLUE);
			return sep;
		}

	}

	private static class MenuItem extends StackPane {
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKBLUE), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKBLUE)

					});

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
			});

		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}