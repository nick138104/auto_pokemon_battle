package logic;

import java.util.ArrayList;

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
import entity.base.Monster;

public class AITeam {

	private int level;
	private ArrayList<Monster> team;

	public AITeam(int level) {
		team = new ArrayList<Monster>();
		this.level = level;
		addMonsters();
	}

	public void addMonsters() {
		if (level == 0) {
			team.add(new Bulbasaur());
			team.add(new Charmander());
			team.add(new Squirtle());
		} else if (level == 1) {
			team.add(new Pikachu());
			team.add(new Chikorita());
			team.add(new Cyndaquil());
			team.add(new Totodile());
			team.add(new Magikarp());
		} else if (level == 2) {
			Torchic torc = new Torchic();
			torc.isLevelUp(torc);
			Mudkip mudk = new Mudkip();
			mudk.isLevelUp(mudk);
			Treecko tree = new Treecko();
			tree.isLevelUp(tree);
			team.add(tree);
			team.add(torc);
			team.add(mudk);
			team.add(new Pikachu());
			team.add(new Magikarp());
		} else if (level == 3) {
			Chimchar chim = new Chimchar();
			chim.isLevelUp(chim);
			chim.isLevelUp(chim);
			Piplup pip = new Piplup();
			pip.isLevelUp(pip);
			pip.isLevelUp(pip);
			Turtwig turt = new Turtwig();
			turt.isLevelUp(turt);
			turt.isLevelUp(turt);
			team.add(new Pikachu());
			team.add(new Magikarp());
			team.add(chim);
			team.add(turt);
			team.add(pip);
		} else if (level == 4) {
			Pikachu pika = new Pikachu();
			pika.setAttack(20);
			pika.setLifepoint(20);
			Chimchar chim = new Chimchar();
			chim.isLevelUp(chim);
			chim.isLevelUp(chim);
			chim.setAttack(20);
			chim.setLifepoint(15);
			Piplup pip = new Piplup();
			pip.isLevelUp(pip);
			pip.isLevelUp(pip);
			pip.setAttack(15);
			pip.setLifepoint(20);
			Turtwig turt = new Turtwig();
			turt.isLevelUp(turt);
			turt.isLevelUp(turt);
			turt.setLifepoint(10);
			turt.setLifepoint(25);
			Magikarp magi = new Magikarp();
			magi.setAttack(10);
			magi.setLifepoint(30);
			team.add(pika);
			team.add(chim);
			team.add(turt);
			team.add(pip);
			team.add(magi);

		}
		while (team.size() != 5) {
			team.add(null);
		}
	}

	public ArrayList<Monster> getTeam() {
		return team;
	}
}
