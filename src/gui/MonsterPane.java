package gui;

import java.util.Objects;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.MarketManager;

public class MonsterPane extends GridPane {

	public MonsterPane() {
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
			Tooltip tooltip = new Tooltip();
			tooltip.setFont(new Font(12));
			monstercell.setOnMouseMoved((MouseEvent e) -> {
				int index = Integer.parseInt(monstercell.getId());
				if (Objects.nonNull(MarketManager.monsters.get(index))) {
					tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
				}
			});
			monstercell.setOnMouseExited((MouseEvent e) -> {
				tooltip.hide();
			});
			MarketManager.boardtooltip.add(tooltip);
		}
	}
}
