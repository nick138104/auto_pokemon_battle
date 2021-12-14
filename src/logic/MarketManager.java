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
import entity.base.MonsterElement;
import gui.MonsterCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import resource.ResourceHolder;

public class MarketManager {

	public static ObservableList<Label> statList = FXCollections.observableArrayList();
	public static ObservableList<Monster> monsters = FXCollections.observableArrayList();
	public static ObservableList<MonsterCell> board = FXCollections.observableArrayList();
	public static ObservableList<Tooltip> boardtooltip = FXCollections.observableArrayList();
	public static ObservableList<Gameobject> objects = FXCollections.observableArrayList();
	public static ObservableList<Button> marketList = FXCollections.observableArrayList();
	public static ObservableList<Tooltip> marketlisttooltip = FXCollections.observableArrayList();
	public static int money;
	public static int win;
	public static int health;
	private static Button selectedButton;

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
			if (Objects.isNull(objects.get(i)) || !objects.get(i).isFreez()) {
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
		switch (food) {
		case 0:
			return new Food("Cheri Berry", 1, 1, 0);
		case 1:
			return new Food("Chesto Berry", 2, 0, 0);
		case 2:
			return new Food("Pecha Berry", 0, 2, 2);
		case 3:
			return new Food("Rowst Berry", 2, 2, 3);
		case 4:
			return new Food("Aspear Berry", 2, 3, 4);
		case 5:
			return new Food("Leppa Berry", 3, 2, 5);
		case 6:
			return new Food("Oran Berry", 3, 3, 6);
		default:
			return null;
		}
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
				updateCombo(indexU);
				updateAfterManage();
			} else {
				if (monster.isLevelUp(monsters.get(indexU))) {
					objects.set(indexL, null);
					money -= 3;
					updateCombo(indexU);
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

	public static void updateTooltip() {
		for (int i = 0; i < 5; i++) {
			if (Objects.nonNull(monsters.get(i))) {
				boardtooltip.get(i).setText(monsters.get(i).toString());
			}
			if (Objects.nonNull(objects.get(i))) {
				marketlisttooltip.get(i).setText(objects.get(i).toString());
			}
		}
	}

	private static void updateAfterManage() {
		updateMonster();
		updateMarket();
		setSelectedButton(null);
		updateMoney();
		MarketManager.updateTooltip();
	}

	private static void updateCombo(int indexU) {
		switch (monsters.get(indexU).getElement()) {
		case FIRE:
			updateFirecase();
			return;
		case WATER:
			updeteWatercase();
			return;
		case PLANT:
			updatePlantcase();
			return;
		default:
			return;
		}
	}

	private static void updatePlantcase() {
		// TODO Auto-generated method stub
		int total = 0;
		int attack = 0;
		int life = 0;
		for (Monster mon : monsters) {
			if (Objects.nonNull(mon) && mon.getElement() == MonsterElement.PLANT) {
				total += 1;
			}
		}
		if (total == 3) {
			attack = 1;
		} else if (total == 4) {
			attack = 3;
			life = 1;
		} else if (total == 5) {
			attack = 4;
			life = 2;
		}
		updateAllmonster(attack, life);
	}

	private static void updeteWatercase() {
		// TODO Auto-generated method stub
		int total = 0;
		int attack = 0;
		int life = 0;
		for (Monster mon : monsters) {
			if (Objects.nonNull(mon) && mon.getElement() == MonsterElement.WATER) {
				total += 1;
			}
		}
		if (total == 3) {
			attack = 1;
		} else if (total == 4) {
			attack = 2;
			life = 2;
		} else if (total == 5) {
			attack = 3;
			life = 3;
		}
		updateAllmonster(attack, life);
	}

	private static void updateFirecase() {
		// TODO Auto-generated method stub
		int total = 0;
		int attack = 0;
		int life = 0;
		for (Monster mon : monsters) {
			if (Objects.nonNull(mon) && mon.getElement() == MonsterElement.FIRE) {
				total += 1;
			}
		}
		if (total == 3) {
			life = 1;
		} else if (total == 4) {
			attack = 1;
			life = 3;
		} else if (total == 5) {
			attack = 2;
			life = 4;
		}
		updateAllmonster(attack, life);
	}

	private static void updateAllmonster(int attack, int life) {
		for (Monster mon : monsters) {
			if (Objects.nonNull(mon)) {
				mon.setAttack(attack + mon.getAttack());
				mon.setLifepoint(life + mon.getLifepoint());
			}
		}
	}

	public static void updateMarket() {
		selectedButton = null;
		updateMoney();
		updateWin();
		updateLife();
		updateTooltip();
		for (int i = 0; i < 5; i++) {
			if (Objects.nonNull(objects.get(i))) {
				int pic_num = objects.get(i).getId();
				ImageView image;
				if (i < 3) {
					image = new ImageView(ResourceHolder.getInstance().monster.get(pic_num));
				} else {
					image = new ImageView(ResourceHolder.getInstance().food.get(pic_num));
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
				board.get(i).setBackground(ResourceHolder.getInstance().monster.get(index));
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
