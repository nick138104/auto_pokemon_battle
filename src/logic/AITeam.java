package logic;

import java.util.ArrayList;

import entity.Bulbasaur;
import entity.Charmander;
import entity.Chikorita;
import entity.Chimchar;
import entity.Cyndaquil;
import entity.Gyarados;
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
			Chikorita chi = new Chikorita();
			chi.isLevelUp(chi);
			Cyndaquil cyn = new Cyndaquil();
			cyn.isLevelUp(cyn);
			Totodile toto = new Totodile();
			toto.isLevelUp(toto);
			team.add(chi);
			team.add(cyn);
			team.add(toto);
			team.add(new Gyarados());
		} else if (level == 2) {
			Torchic torc = new Torchic();
			torc.isLevelUp(torc);
			torc.isLevelUp(torc);
			Mudkip mudk = new Mudkip();
			mudk.isLevelUp(mudk);
			mudk.isLevelUp(mudk);
			Treecko tree = new Treecko();
			tree.isLevelUp(tree);
			tree.isLevelUp(tree);
			team.add(tree);
			team.add(torc);
			team.add(mudk);
			team.add(new Pikachu());
			team.add(new Gyarados());
		} else if (level == 3) {
			Chimchar chim = new Chimchar();
			chim.setAttack(12);
			chim.setLifepoint(10);
			chim.isLevelUp(chim);
			chim.isLevelUp(chim);
			Piplup pip = new Piplup();
			pip.setAttack(11);
			pip.setLifepoint(11);
			pip.isLevelUp(pip);
			pip.isLevelUp(pip);
			Turtwig turt = new Turtwig();
			turt.setAttack(10);
			turt.setLifepoint(12);
			turt.isLevelUp(turt);
			turt.isLevelUp(turt);
			team.add(new Pikachu());
			team.add(new Gyarados());
			team.add(chim);
			team.add(turt);
			team.add(pip);
		} else if (level == 4) {
			Pikachu pika = new Pikachu();
			pika.setAttack(30);
			pika.setLifepoint(30);
			Chimchar chim = new Chimchar();
			chim.isLevelUp(chim);
			chim.isLevelUp(chim);
			chim.setAttack(25);
			chim.setLifepoint(20);
			Piplup pip = new Piplup();
			pip.isLevelUp(pip);
			pip.isLevelUp(pip);
			pip.setAttack(20);
			pip.setLifepoint(25);
			Turtwig turt = new Turtwig();
			turt.isLevelUp(turt);
			turt.isLevelUp(turt);
			turt.setLifepoint(15);
			turt.setLifepoint(30);
			Gyarados magi = new Gyarados();
			magi.setAttack(10);
			magi.setLifepoint(60);
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
