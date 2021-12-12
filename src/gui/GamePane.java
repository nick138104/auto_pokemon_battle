package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jdk.vm.ci.code.site.Mark;
import logic.MarketManager;
import sun.jvm.hotspot.oops.CellTypeStateList;

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
		statPane.setHgap(25);
		statPane.setVgap(10);
		Label money_label = new Label("Money : " + MarketManager.money);
		Label win_label = new Label("Win : " + MarketManager.win + " / 5");
		Label life_label = new Label("Life : " + MarketManager.life);
		Label turn_label = new Label("Turn : " + MarketManager.turn);
		MarketManager.statList.add(money_label);
		MarketManager.statList.add(win_label);
		MarketManager.statList.add(life_label);
		MarketManager.statList.add(turn_label);
		money_label.setBorder(
				new Border(new BorderStroke(Color.DARKORANGE, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
		win_label.setBorder(
				new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
		life_label
				.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
		turn_label.setBorder(
				new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
		for (int i = 0; i < MarketManager.statList.size(); i++) {
			statPane.add(MarketManager.statList.get(i), i, 0);
			MarketManager.statList.get(i).setFont(new Font("Comic Sans MS", 25));
			MarketManager.statList.get(i).setPadding(new Insets(0, 5, 0, 5));
		}
		statPane.setTranslateX(50);
		statPane.setTranslateY(15);
	}

	private void initializegamePane() {
		gamePane = new GridPane();
		gamePane.setPrefSize(200, 600);
		gamePane.setHgap(20);
		gamePane.setVgap(10);
		gamePane.add(gameButton.getButtons().get(1), 0, 0);
		MarketPane marketPane = new MarketPane();
		gamePane.add(marketPane, 1, 0);
		gamePane.add(gameButton.getButtons().get(2), 2, 0);
		gamePane.add(gameButton.getButtons().get(3), 3, 0);
		gamePane.add(gameButton.getButtons().get(4), 4, 0);
		gamePane.setTranslateX(120);
		gamePane.setTranslateY(520);
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
