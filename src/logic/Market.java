package logic;

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

public class Market {

	private ObservableList<Gameobject> objects = FXCollections.observableArrayList();

	public void startMarket() {
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
			if (food == 0) {
				name = "Cheri Berry";
				attack = 1;
				life = 1;
			} else if (food == 1) {
				name = "Chesto Berry";
				attack = 2;
			} else if (food == 2) {
				name = "Pecha Berry";
				life = 2;
			} else if (food == 3) {
				name = "Rowst Berry";
				attack = 2;
				life = 2;
			} else if (food == 4) {
				name = "Aspear Berry";
				attack = 2;
				life = 3;
			} else if (food == 5) {
				name = "Leppa Berry";
				attack = 3;
				life = 2;
			} else {
				name = "Oran Berry";
				attack = 3;
				life = 3;
			}
			objects.add(new Food(name, attack, life));
		}
	}

	public void randomMonster() {
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			if (!objects.get(i).isFreez()) {
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
				if (food == 0) {
					name = "Cheri Berry";
					attack = 1;
					life = 1;
				} else if (food == 1) {
					name = "Chesto Berry";
					attack = 2;
				} else if (food == 2) {
					name = "Pecha Berry";
					life = 2;
				} else if (food == 3) {
					name = "Rowst Berry";
					attack = 2;
					life = 2;
				} else if (food == 4) {
					name = "Aspear Berry";
					attack = 2;
					life = 3;
				} else if (food == 5) {
					name = "Leppa Berry";
					attack = 3;
					life = 2;
				} else {
					name = "Oran Berry";
					attack = 3;
					life = 3;
				}
				objects.set(i, new Food(name, attack, life));
			}
		}
	}
}
