package scenepackage;

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
import resource.RenderableHolder;

public class SceneManager {
	private static final SceneManager instance = new SceneManager();
	public static Scene menu_scene;
	public static Scene game_scene;
	public static Scene play_scene;

	private Parent createContent1() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		ImageView img = new ImageView(RenderableHolder.background.get(0));
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
		ImageView img = new ImageView(RenderableHolder.background.get(1));
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
		GraphicsContext gc = canvas.getGraphicsContext2D();
		ImageView img = new ImageView(RenderableHolder.background.get(1));
		img.setFitWidth(1050);
		img.setFitHeight(600);
		root.getChildren().add(img);
		root.getChildren().add(canvas);
		return root;
	}

	public SceneManager() {
		menu_scene = new Scene(createContent1());
		game_scene = new Scene(createContent2());
		play_scene = new Scene(createContent3());
	}

	public static SceneManager getInstance() {
		return instance;
	}
}
