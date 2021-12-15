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
import resource.ResourceHolder;

public class SceneManager {
	private static final SceneManager instance;
	public Scene menu_scene;
	public Scene game_scene;
	public Scene play_scene;
	public Scene win_scene;
	public Scene lose_scene;
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
		ImageView img = new ImageView(ResourceHolder.getInstance().background.get(1));
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
		Animation animation = new Animation();
		graphicsContext = canvas.getGraphicsContext2D();
		this.animation = animation;
		root.getChildren().add(canvas);
		return root;
	}

	private Parent createContent4() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		// add win sence
		// root.getChildren().add();
		return root;
	}

	private Parent createContent5() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		// add lost sence
		// root.getChildren().add();
		return root;
	}

	public static SceneManager getInstance() {
		return instance;
	}
}
