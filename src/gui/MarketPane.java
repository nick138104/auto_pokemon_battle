package gui;

import java.util.Objects;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.MarketManager;
import resource.ResourceHolder;

public class MarketPane extends GridPane {

	public MarketPane() {
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);
		for (int i = 0; i < 5; i++) {
			int pic_num = MarketManager.objects.get(i).getId();
			Button b = new Button();
			b.setId("" + i);
			int index = Integer.parseInt(b.getId());
			b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					if (Objects.nonNull(MarketManager.objects.get(index))) {
						resetButtonsBackGroundColor();
						MarketManager.setSelectedButton(b);
						highlight(index);
					}
				}
			});
			b.setPadding(new Insets(5.0));
			b.setMinWidth(60);
			b.setMinHeight(60);
			ImageView image;
			if (i < 3) {
				image = new ImageView(ResourceHolder.getInstance().monster.get(pic_num));
			} else {
				image = new ImageView(ResourceHolder.getInstance().food.get(pic_num));
			}
			image.setFitHeight(48);
			image.setFitWidth(48);
			b.setGraphic(image);
			b.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			b.setBorder(new Border(
					new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			Tooltip tooltip = new Tooltip();
			tooltip.setFont(new Font(12));
			b.setOnMouseMoved((MouseEvent e) -> {
				if (Objects.nonNull(MarketManager.objects.get(index))) {
					tooltip.show(b, e.getScreenX(), e.getScreenY() + 10);
				}
			});
			b.setOnMouseExited((MouseEvent e) -> {
				tooltip.hide();
			});
			MarketManager.marketList.add(b);
			MarketManager.marketlisttooltip.add(tooltip);
		}
		for (int i = 0; i < 5; i++) {
			add(MarketManager.marketList.get(i), i, 0);
		}
	}

	public void highlight(int index) {
		Background n = new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY));
		if (MarketManager.objects.get(index).isFreez()) {
			n = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY));
		}
		MarketManager.marketList.get(index).setBackground(n);
	}

	public void resetButtonsBackGroundColor() {
		for (int i = 0; i < 5; i++) {
			Background n = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
			if (Objects.nonNull(MarketManager.objects.get(i)) && MarketManager.objects.get(i).isFreez()) {
				n = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY));
			}
			MarketManager.marketList.get(i).setBackground(n);
		}
	}
}