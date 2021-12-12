package logic;

import java.util.Objects;
import java.util.Random;

import entity.Bulbasaur;
import entity.Charmander;
import entity.Chikorita;
import entity.Chimchar;
import entity.Cyndaquil;
import entity.Magikarp;
import entity.Mudkip;
import entity.Pikachu;
import entity.Piplup;
import entity.Squirtle;
import entity.Torchic;
import entity.Totodile;
import entity.Treecko;
import entity.Turtwig;
import entity.base.Food;
import entity.base.Gameobject;
import entity.base.Monster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import resource.RenderableHolder;

public class MarketManager {

	public static ObservableList<Gameobject> objects = FXCollections.observableArrayList();
	public static ObservableList<Button> marketList = FXCollections.observableArrayList();
	public static ObservableList<Label> statList = FXCollections.observableArrayList();
	public static int money;
	public static int win;
	public static int life;
	public static int turn;
	private static Button selectedButton;

	public static void startMarket() {
		objects.clear();
		money = 10;
		win = 0;
		life = 5;
		turn = 0;
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			int mon = rand.nextInt(14);
			if (mon == 0) {
				objects.add(new Bulbasaur());
			} else if (mon == 1) {
				objects.add(new Charmander());
			} else if (mon == 2) {
				objects.add(new Chikorita());
			} else if (mon == 3) {
				objects.add(new Chimchar());
			} else if (mon == 4) {
				objects.add(new Cyndaquil());
			} else if (mon == 5) {
				objects.add(new Magikarp());
			} else if (mon == 6) {
				objects.add(new Mudkip());
			} else if (mon == 7) {
				objects.add(new Pikachu());
			} else if (mon == 8) {
				objects.add(new Piplup());
			} else if (mon == 9) {
				objects.add(new Squirtle());
			} else if (mon == 10) {
				objects.add(new Torchic());
			} else if (mon == 11) {
				objects.add(new Totodile());
			} else if (mon == 12) {
				objects.add(new Treecko());
			} else {
				objects.add(new Turtwig());
			}
		}
		for (int i = 0; i < 2; i++) {
			int food = rand.nextInt(7);
			String name;
			int attack = 0;
			int life = 0;
			int id;
			if (food == 0) {
				name = "Cheri Berry";
				attack = 1;
				life = 1;
				id = 0;
			} else if (food == 1) {
				name = "Chesto Berry";
				attack = 2;
				id = 1;
			} else if (food == 2) {
				name = "Pecha Berry";
				life = 2;
				id = 2;
			} else if (food == 3) {
				name = "Rowst Berry";
				attack = 2;
				life = 2;
				id = 3;
			} else if (food == 4) {
				name = "Aspear Berry";
				attack = 2;
				life = 3;
				id = 4;
			} else if (food == 5) {
				name = "Leppa Berry";
				attack = 3;
				life = 2;
				id = 5;
			} else {
				name = "Oran Berry";
				attack = 3;
				life = 3;
				id = 6;
			}
			objects.add(new Food(name, attack, life, id));
		}
	}

	public static void randomMarket() {
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			if (Objects.isNull(objects.get(i)) || !objects.get(i).isFreez()) {
				int mon = rand.nextInt(14);
				Monster monster;
				if (mon == 0) {
					monster = new Bulbasaur();
				} else if (mon == 1) {
					monster = new Charmander();
				} else if (mon == 2) {
					monster = new Chikorita();
				} else if (mon == 3) {
					monster = new Chimchar();
				} else if (mon == 4) {
					monster = new Cyndaquil();
				} else if (mon == 5) {
					monster = new Magikarp();
				} else if (mon == 6) {
					monster = new Mudkip();
				} else if (mon == 7) {
					monster = new Pikachu();
				} else if (mon == 8) {
					monster = new Piplup();
				} else if (mon == 9) {
					monster = new Squirtle();
				} else if (mon == 10) {
					monster = new Torchic();
				} else if (mon == 11) {
					monster = new Totodile();
				} else if (mon == 12) {
					monster = new Treecko();
				} else {
					monster = new Turtwig();
				}
				objects.set(i, monster);
			}
		}
		for (int i = 3; i < 5; i++) {
			if (!objects.get(i).isFreez()) {
				int food = rand.nextInt(7);
				String name;
				int attack = 0;
				int life = 0;
				int id;
				if (food == 0) {
					name = "Cheri Berry";
					attack = 1;
					life = 1;
					id = 0;
				} else if (food == 1) {
					name = "Chesto Berry";
					attack = 2;
					id = 1;
				} else if (food == 2) {
					name = "Pecha Berry";
					life = 2;
					id = 2;
				} else if (food == 3) {
					name = "Rowst Berry";
					attack = 2;
					life = 2;
					id = 3;
				} else if (food == 4) {
					name = "Aspear Berry";
					attack = 2;
					life = 3;
					id = 4;
				} else if (food == 5) {
					name = "Leppa Berry";
					attack = 3;
					life = 2;
					id = 5;
				} else {
					name = "Oran Berry";
					attack = 3;
					life = 3;
					id = 6;
				}
				objects.set(i, new Food(name, attack, life, id));
			}
		}
	}

	public static void freezMarket() {
		// can throw exception
		if (Objects.isNull(selectedButton))
			return;
		int index = Integer.parseInt(selectedButton.getId());
		objects.get(index).setFreez(!objects.get(index).isFreez());
		if (objects.get(index).isFreez()) {
			MarketManager.marketList.get(index).setBackground(
					new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		} else {
			MarketManager.marketList.get(index).setBackground(
					new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		}

	}

	public static void updateMarket() {
		selectedButton = null;
		for (int i = 0; i < 5; i++) {
			if (Objects.nonNull(objects.get(i))) {
				int pic_num = MarketManager.objects.get(i).getId();
				ImageView image;
				if (i < 3) {
					image = new ImageView(RenderableHolder.monster.get(pic_num));
				} else {
					image = new ImageView(RenderableHolder.food.get(pic_num));
				}
				image.setFitHeight(48);
				image.setFitWidth(48);
				MarketManager.marketList.get(i).setGraphic(image);
				if (objects.get(i).isFreez()) {
					MarketManager.marketList.get(i).setBackground(
							new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				} else {
					MarketManager.marketList.get(i).setBackground(
							new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				// setTooltip();
			} else {
				MarketManager.marketList.get(i).setGraphic(null);
				MarketManager.marketList.get(i).setBackground(
						new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}

	public static Button getSelectedButton() {
		return selectedButton;
	}

	public static void setSelectedButton(Button selectedButton) {
		MarketManager.selectedButton = selectedButton;
	}

	public static void updateMoney() {
		statList.get(0).setText("Money : " + money);

	}

	public static void updateWin() {
		statList.get(0).setText("Win : " + win + " / 5");

	}

	public static void updateLife() {
		statList.get(0).setText("Life : " + life);

	}

	public static void updateTurn() {
		statList.get(0).setText("Turn : " + turn);

	}
}
