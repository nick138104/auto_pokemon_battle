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
import gui.MonsterCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import resource.RenderableHolder;

public class MarketManager {

	public static ObservableList<Label> statList = FXCollections.observableArrayList();
	public static ObservableList<Monster> monsters = FXCollections.observableArrayList();
	public static ObservableList<MonsterCell> board = FXCollections.observableArrayList();
	public static ObservableList<Gameobject> objects = FXCollections.observableArrayList();
	public static ObservableList<Button> marketList = FXCollections.observableArrayList();
	public static int money;
	public static int win;
	public static int health;
	private static Button selectedButton;
	private static Pane selectedCell;

	public static void startMarket() {
		objects.clear();
		money = 10;
		win = 0;
		health = 5;
		for (int i = 0; i < 3; i++) {
			objects.add(randomMonster());
		}
		for (int i = 0; i < 2; i++) {
			objects.add(randomFood());
		}
	}

	public static void randomMarket() {
		for (int i = 0; i < 3; i++) {
			if (Objects.isNull(objects.get(i)) || !objects.get(i).isFreez()) {
				objects.set(i, randomMonster());
			}
		}
		for (int i = 3; i < 5; i++) {
			if (Objects.nonNull(objects.get(i)) && !objects.get(i).isFreez()) {
				objects.set(i, randomFood());
			}
		}
	}

	private static Monster randomMonster() {
		Random rand = new Random();
		int mon = rand.nextInt(14);
		switch (mon) {
		case 0:
			return new Bulbasaur();
		case 1:
			return new Charmander();
		case 2:
			return new Chikorita();
		case 3:
			return new Chimchar();
		case 4:
			return new Cyndaquil();
		case 5:
			return new Magikarp();
		case 6:
			return new Mudkip();
		case 7:
			return new Pikachu();
		case 8:
			return new Piplup();
		case 9:
			return new Squirtle();
		case 10:
			return new Torchic();
		case 11:
			return new Totodile();
		case 12:
			return new Treecko();
		case 13:
			return new Turtwig();
		default:
			return null;
		}
	}

	private static Food randomFood() {
		Random rand = new Random();
		int food = rand.nextInt(7);
		String name;
		int attack = 0;
		int life = 0;
		int id = food;
		switch (food) {
		case 0:
			name = "Cheri Berry";
			attack = 1;
			life = 1;
		case 1:
			name = "Chesto Berry";
			attack = 2;
		case 2:
			name = "Pecha Berry";
			life = 2;
		case 3:
			name = "Rowst Berry";
			attack = 2;
			life = 2;
		case 4:
			name = "Aspear Berry";
			attack = 2;
			life = 3;
		case 5:
			name = "Leppa Berry";
			attack = 3;
			life = 2;
		case 6:
			name = "Oran Berry";
			attack = 3;
			life = 3;
		default:
			name = "";
		}
		return new Food(name, attack, life, id);
	}

	public static void freezMarket() {
		// can throw exception
		if (Objects.isNull(selectedButton))
			return;
		int index = Integer.parseInt(selectedButton.getId());
		objects.get(index).setFreez(!objects.get(index).isFreez());
		if (objects.get(index).isFreez()) {
			marketList.get(index).setBackground(
					new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		} else {
			marketList.get(index).setBackground(
					new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}

	public static void manageMonster(int indexL, int indexU) {
		if (indexL < 3) {
			if (money < 3)
				return;
			Monster monster = (Monster) objects.get(indexL);
			if (Objects.isNull(monsters.get(indexU))) {
				monsters.set(indexU, monster);
				objects.set(indexL, null);
				money -= 3;
				updateAfterManage();
			} else {
				if (monster.islevelUp(monsters.get(indexU))) {
					objects.set(indexL, null);
					money -= 3;
					updateAfterManage();
				}
			}
		} else if (indexL == 5) {
			if (Objects.nonNull(monsters.get(indexU))) {
				monsters.set(indexU, null);
				money += 1;
				updateAfterManage();
			}
		} else {
			if (money < 3)
				return;
			Food food = (Food) objects.get(indexL);
			if (Objects.nonNull(monsters.get(indexU))) {
				food.eatFood(monsters.get(indexU));
				objects.set(indexL, null);
				money -= 3;
				updateAfterManage();
			}
		}
	}

	private static void updateAfterManage() {
		updateMonster();
		updateMarket();
		setSelectedButton(null);
		updateMoney();
	}

	public static void updateMarket() {
		selectedButton = null;
		updateMoney();
		updateWin();
		updateLife();
		for (int i = 0; i < 5; i++) {
			if (Objects.nonNull(objects.get(i))) {
				int pic_num = objects.get(i).getId();
				ImageView image;
				if (i < 3) {
					image = new ImageView(RenderableHolder.monster.get(pic_num));
				} else {
					image = new ImageView(RenderableHolder.food.get(pic_num));
				}
				image.setFitHeight(48);
				image.setFitWidth(48);
				marketList.get(i).setGraphic(image);
				if (objects.get(i).isFreez()) {
					marketList.get(i).setBackground(
							new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				} else {
					marketList.get(i).setBackground(
							new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				// setTooltip();
			} else {
				marketList.get(i).setGraphic(null);
				marketList.get(i).setBackground(
						new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}

	public static void updateMonster() {
		for (int i = 0; i < 5; i++) {
			if (Objects.isNull(monsters.get(i))) {
				board.get(i).setBackground();
			} else {
				int index = monsters.get(i).getId();
				board.get(i).setBackground(RenderableHolder.monster.get(index));
			}
		}
	}

	public static void updateBoard() {
		for (int i = 0; i < 5; i++) {
			monsters.set(i, null);
			board.get(i).setBackground();
		}
	}

	public static Button getSelectedButton() {
		return selectedButton;
	}

	public static void setSelectedButton(Button selectedButton) {
		MarketManager.selectedButton = selectedButton;
	}

	public static Pane getSelectedCell() {
		return selectedCell;
	}

	public static void setSelectedCell(Pane selectedCell) {
		MarketManager.selectedCell = selectedCell;
	}

	public static void updateMoney() {
		statList.get(0).setText("Coin : " + money);
	}

	public static void updateWin() {
		statList.get(1).setText("Win : " + win + " / 5");
	}

	public static void updateLife() {
		statList.get(2).setText("Health : " + health);
	}

}
