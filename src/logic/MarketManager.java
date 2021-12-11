package logic;

import java.util.ArrayList;

import entity.Bulbasaur;
import entity.Charmander;
import entity.Chikorita;
import entity.Chimchar;
import entity.Cyndaquil;
import entity.Magikarp;
import entity.base.Monster;

public class MarketManager {

	public static ArrayList<Monster> monster;

	public static void generateMonster() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		Chikorita chikorita = new Chikorita();
		Chimchar chimcher = new Chimchar();
		Cyndaquil cyndaquil = new Cyndaquil();
		Magikarp magikarp = new Magikarp();
	}
}
