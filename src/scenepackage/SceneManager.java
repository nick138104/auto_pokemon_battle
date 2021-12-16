package scenepackage;

import animation.Animation;
import gui.GamePane;
import gui.MenuBox;
import gui.MenuItem;
import gui.Title;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import main.Main;
import resource.ResourceHolder;

public class SceneManager {
	private static final SceneManager instance;
	public Scene menu_scene;
	public Scene game_scene;
	public Scene play_scene;
	public Scene win_scene;
	public Scene lose_scene;
	public Scene how_to_play_scene;
	public GraphicsContext graphicsContext;
	public Animation animation;

	static {
		instance = new SceneManager();
	}

	public SceneManager() {
		menu_scene = new Scene(createContent1());
		game_scene = new Scene(createContent2());
		play_scene = new Scene(createContent3());
		win_scene = new Scene(createContent4());
		lose_scene = new Scene(createContent5());
		how_to_play_scene = new Scene(createContent6());
	}

	private Parent createContent1() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		ImageView img = new ImageView(ResourceHolder.getInstance().background.get(0));
		img.setFitWidth(1050);
		img.setFitHeight(600);
		root.getChildren().add(img);
		Title title = new Title("Auto Pokemon Battle");
		title.setTranslateX(245);
		title.setTranslateY(200);
		MenuBox vbox = new MenuBox(new MenuItem("PLAY"), new MenuItem("HOW TO PLAY"), new MenuItem("EXIT"));
		vbox.setTranslateX(410);
		vbox.setTranslateY(300);
		root.getChildren().addAll(title, vbox);
		return root;
	}

	private Parent createContent2() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		ImageView img = new ImageView(ResourceHolder.getInstance().background.get(4));
		img.setFitWidth(1050);
		img.setFitHeight(600);
		root.getChildren().add(img);
		GamePane panes = new GamePane();
		Button backbutton = panes.getbackButton();
		backbutton.setTranslateX(980);
		root.getChildren().addAll(backbutton, panes.getStatPane(), panes.getMonsterPane(), panes.getGamePane());
		return root;
	}

	private Parent createContent3() {
		StackPane root = new StackPane();
		Canvas canvas = new Canvas(1050, 600);
		this.animation = new Animation();
		graphicsContext = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		return root;
	}

	private Parent createContent4() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		ImageView img = new ImageView(ResourceHolder.getInstance().background.get(2));
		img.setFitWidth(1050);
		img.setFitHeight(600);
		MenuItem back_item = new MenuItem("BACK");
		back_item.setTranslateX(410);
		back_item.setTranslateY(450);
		back_item.setOnMouseReleased(event -> {
			Main.primaryStage.setScene(SceneManager.getInstance().menu_scene);
			ResourceHolder.getInstance().music.get(10).stop();
			ResourceHolder.getInstance().music.get(0).play(0.08);
			ResourceHolder.getInstance().music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
		});
		root.getChildren().add(img);
		root.getChildren().add(back_item);
		return root;
	}

	private Parent createContent5() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		ImageView img = new ImageView(ResourceHolder.getInstance().background.get(3));
		img.setFitWidth(1050);
		img.setFitHeight(600);
		MenuItem back_item = new MenuItem("BACK");
		back_item.setTranslateX(410);
		back_item.setTranslateY(450);
		back_item.setOnMouseReleased(event -> {
			Main.primaryStage.setScene(SceneManager.getInstance().menu_scene);
			ResourceHolder.getInstance().music.get(11).stop();
			ResourceHolder.getInstance().music.get(0).play(0.08);
			ResourceHolder.getInstance().music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
		});
		root.getChildren().add(img);
		root.getChildren().add(back_item);
		return root;
	}

	private Parent createContent6() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		ImageView img = new ImageView(ResourceHolder.getInstance().background.get(0));
		img.setFitWidth(1050);
		img.setFitHeight(600);
		Title title = new Title("How To Play");
		title.setTranslateX(365);
		title.setTranslateY(150);
		Rectangle rect = new Rectangle(820, 175);
		rect.setTranslateX(115);
		rect.setTranslateY(245);
		rect.setOpacity(0.5);
		rect.setFill(Color.WHITE);
		Text massage = new Text("Auto Pokemon Battle is an auto battler game \nthat contains many "
				+ "characters from the Pokemon series.\nIn this game, you have "
				+ "to build your own team \n strengthen your Pokemon to defeat opponents.");
		massage.setTranslateX(135);
		massage.setTranslateY(280);
		massage.setTextAlignment(TextAlignment.CENTER);
		massage.setFont(new Font("Comic Sans MS", 30));
		MenuItem back_item = new MenuItem("BACK");
		back_item.setTranslateX(410);
		back_item.setTranslateY(450);
		back_item.setOnMouseReleased(event -> {
			Main.primaryStage.setScene(SceneManager.getInstance().menu_scene);
		});
		root.getChildren().addAll(img, title, rect, massage, back_item);
		return root;
	}

	public static SceneManager getInstance() {
		return instance;
	}
}
