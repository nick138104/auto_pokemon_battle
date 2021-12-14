package gui;

import java.util.Objects;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.MarketManager;

public class MonsterCell extends Pane {

	public MonsterCell() {
		setPrefWidth(100.0);
		setPrefHeight(100.0);
		setPadding(new Insets(8.0));
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				onClickHandler();
			}
		});
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
		setBackground();
	}

	private void onClickHandler() {
		int indexU = Integer.parseInt(getId());
		if (Objects.isNull(MarketManager.getSelectedButton()))
			return;
		int indexL = Integer.parseInt(MarketManager.getSelectedButton().getId());
		MarketManager.manageMonster(indexL, indexU);
	}

	public void setBackground() {
		setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setBackground(Image image) {
		BackgroundFill bgFill = new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(75, 75, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		setBackground(new Background(bgFillA, bgImgA));
	}
}
