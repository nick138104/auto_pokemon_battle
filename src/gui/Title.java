package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Title extends StackPane {

	public Title(String name) {

		Text text = new Text(name);
		text.setFill(Color.BLACK);
		text.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, 55));
		text.setStroke(Color.BLANCHEDALMOND);
		text.setStrokeWidth(2);

		setAlignment(Pos.CENTER);
		getChildren().add(text);
	}
}