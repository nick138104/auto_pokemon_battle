package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import animation.Animation;
import entity.base.Gameobject;
import entity.base.HitLine;
import entity.base.Monster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.media.MediaPlayer;
import main.Main;
import resource.RenderableHolder;
import resource.ResourceHolder;
import scenepackage.SceneManager;

public class BattleUtils {

	private ObservableList<Monster> playerMonster = FXCollections.observableArrayList();
	private ObservableList<Monster> enemyMonster = FXCollections.observableArrayList();
	private ObservableList<HitLine> hitlineContainer = FXCollections.observableArrayList();
	private int player;
	private int enemy;
	private int count;
	private boolean fightover;
	public static final int POS_CENTER_LEFT = 455;
	public static final int POS_CENTER_RIGHT = 535;

	public void startBattle() {
		// TODO Auto-generated method stub
		player = 0;
		enemy = 0;
		count = 0;
		fightover = false;
		RenderableHolder.getInstance().getEntities().clear();
		playerMonster.clear();
		enemyMonster.clear();
		hitlineContainer.clear();
		AITeam aiteam = new AITeam(MarketManager.win);
		Random rand = new Random();
		List<Integer> num = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		List<Point2D> pos1 = Arrays.asList(new Point2D(300, 400), new Point2D(230, 400), new Point2D(160, 400),
				new Point2D(90, 400), new Point2D(20, 400));
		List<Point2D> pos2 = Arrays.asList(new Point2D(690, 400), new Point2D(760, 400), new Point2D(830, 400),
				new Point2D(900, 400), new Point2D(970, 400));
		for (int i = 0; i < 5; i++) {
			int randomIndex = rand.nextInt(num.size());
			if (Objects.nonNull(MarketManager.monsters.get(num.get(randomIndex)))) {
				Monster mon1 = MarketManager.monsters.get(num.get(randomIndex)).createCopy();
				mon1.setPos(pos1.get(player));
				player += 1;
				addNewObject(mon1);
			}
			if (Objects.nonNull(aiteam.getTeam().get(num.get(randomIndex)))) {
				Monster mon2 = aiteam.getTeam().get(num.get(randomIndex)).createCopy();
				mon2.setPos(pos2.get(enemy));
				enemy += 1;
				addNewObject(mon2);
			}
			num.remove(randomIndex);
		}
		HitLine hitline1 = new HitLine();
		HitLine hitline2 = new HitLine();
		hitline1.setPos(new Point2D(POS_CENTER_LEFT, 400));
		hitline2.setPos(new Point2D(POS_CENTER_RIGHT, 400));
		addNewObject(hitline1);
		addNewObject(hitline2);
	}

	protected void addNewObject(Gameobject object) {
		if (object instanceof Monster) {
			Monster mon = (Monster) object;
			if (mon.getPos().getX() > 500) {
				enemyMonster.add(mon);
			} else {
				playerMonster.add(mon);
			}
			RenderableHolder.getInstance().add(mon);
		} else {
			HitLine hitline = (HitLine) object;
			hitlineContainer.add(hitline);
			RenderableHolder.getInstance().add(hitline);
		}

	}

	public void logicUpdate() {
		// TODO Auto-generated method stub
		if (fightover) {
			Animation.endBattleSence();
			return;
		}
		if (count != 1) {
			count += 1;
			return;
		} else {
			count = 0;
		}
		if (playerMonster.isEmpty() || enemyMonster.isEmpty()) {
			if (!playerMonster.isEmpty()) {
				if (enemyMonster.isEmpty()) {
					MarketManager.win += 1;
					Main.primaryStage.setScene(SceneManager.getInstance().game_scene);
					fightover = true;
					ResourceHolder.getInstance().music.get(0).play(0.05);
					ResourceHolder.getInstance().music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
				}
			} else {
				if (!enemyMonster.isEmpty()) {
					MarketManager.health -= 1;
				}
				fightover = true;
				Main.primaryStage.setScene(SceneManager.getInstance().game_scene);
				ResourceHolder.getInstance().music.get(0).play(0.05);
				ResourceHolder.getInstance().music.get(0).setCycleCount(MediaPlayer.INDEFINITE);
			}
			MarketManager.updateMarket();
			return;
		}
		Monster playermonster = playerMonster.get(0);
		Monster enemymonster = enemyMonster.get(0);
		if (playermonster.getPos().getX() != POS_CENTER_LEFT || enemymonster.getPos().getX() != POS_CENTER_RIGHT) {
			hitlineContainer.get(0).setVisible(false);
			hitlineContainer.get(1).setVisible(false);
			if (playermonster.getPos().getX() != POS_CENTER_LEFT) {
				playermonster.move(1);
			}
			if (enemymonster.getPos().getX() != POS_CENTER_RIGHT) {
				enemymonster.move(-1);
			}
		} else {
			if (playermonster.isDead() || enemymonster.isDead()) {
				if (playermonster.isDead()) {
					playermonster.setVisible(false);
					playerMonster.remove(0);
				}
				if (enemymonster.isDead()) {
					enemymonster.setVisible(false);
					enemyMonster.remove(0);
				}
			} else {
				playermonster.attack(enemymonster);
				hitlineContainer.get(0).setVisible(true);
				hitlineContainer.get(1).setVisible(true);
				ResourceHolder.getInstance().music.get(2).play();
			}
		}
	}
}
