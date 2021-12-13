package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import logic.MarketManager;

public class MonsterPane extends GridPane {

	public MonsterPane() {
		// TODO complete the FieldPane's constructor
		setPrefWidth(500);
		setAlignment(Pos.CENTER);
		setVgap(12);
		setHgap(12);
		setPadding(new Insets(8.0));
		setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		for (int i = 0; i < 5; i++) {
			MonsterCell monstercell = new MonsterCell();
			MarketManager.monsters.add(null);
			MarketManager.board.add(monstercell);
			monstercell.setId("" + i);
			add(monstercell, i, 0);
		}
	}
}
