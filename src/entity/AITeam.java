package entity;

import java.util.ArrayList;

import entity.base.Monster;

public class AITeam {
	
	private String name;
	private ArrayList<Monster> team;
	
	public AITeam(String name) {
		team = new ArrayList<Monster>();
		setName(name);
		addMonsters();
	}
	
	public void addMonsters() {
		if (this.getName().equals("level1")) {
			team.add(new Bulbasaur());
			team.add(new Charmander());
			team.add(new Squirtle());
		} else if(this.getName().equals("level2")) {
			team.add(new Pikachu());
			team.add(new Chikorita());
			team.add(new Cyndaquil());
			team.add(new Totodile());
		} else if(this.getName().equals("level3")) {
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
		} else if(this.getName().equals("level4")) {
			Chimchar chim = new Chimchar();
			chim.isLevelUp(chim);
			Piplup pip = new Piplup();
			pip.isLevelUp(pip);
			Turtwig turt = new Turtwig();
			turt.isLevelUp(turt);
			team.add(new Pikachu());
			team.add(new Magikarp());
			team.add(chim);
			team.add(turt);
			team.add(pip);
		} else if(this.getName().equals("level5")) {
			Pikachu pika = new Pikachu();
			pika.setAttack(10);
			pika.setLifepoint(10);
			Chimchar chim = new Chimchar();
			chim.isLevelUp(chim);
			chim.isLevelUp(chim);
			Piplup pip = new Piplup();
			pip.isLevelUp(pip);
			pip.isLevelUp(pip);
			Turtwig turt = new Turtwig();
			turt.isLevelUp(turt);
			turt.isLevelUp(turt);
			Magikarp magi = new Magikarp();
			magi.setAttack(6);
			magi.setLifepoint(14);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
