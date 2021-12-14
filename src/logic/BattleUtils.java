package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import entity.base.Gameobject;
import entity.base.HitLine;
import entity.base.Monster;
import interfacepackage.IRenderable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import resource.RenderableHolder;

public class BattleUtils {

	private ObservableList<IRenderable> playerMonster = FXCollections.observableArrayList();
	private ObservableList<IRenderable> enemyMonster = FXCollections.observableArrayList();
	private ObservableList<IRenderable> hitlineContainer = FXCollections.observableArrayList();
	private int player;
	private int enemy;
	private boolean isCenterleft;
	private boolean isCenterright;

	public void startBattle() {
		// TODO Auto-generated method stub
		player = 0;
		enemy = 0;
		isCenterleft = false;
		isCenterright = false;
		Random rand = new Random();
		List<Integer> num = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		List<Point2D> pos1 = Arrays.asList(new Point2D(300, 400), new Point2D(230, 400), new Point2D(160, 400),
				new Point2D(90, 400), new Point2D(20, 400));
		List<Point2D> pos2 = Arrays.asList(new Point2D(690, 400), new Point2D(760, 400), new Point2D(830, 400),
				new Point2D(900, 400), new Point2D(970, 400));
		for (int i = 0; i < 5; i++) {
			int randomIndex = rand.nextInt(num.size());
			if (Objects.nonNull(MarketManager.monsters.get(num.get(randomIndex)))) {
				Monster mon = MarketManager.monsters.get(num.get(randomIndex)).createCopy();
				mon.setPos(pos1.get(player));
				player += 1;
				addNewObject(mon);
			}
			if (Objects.nonNull(MarketManager.monsters.get(num.get(randomIndex)))) {
				Monster mon = MarketManager.monsters.get(num.get(randomIndex)).createCopy();
				mon.setPos(pos2.get(enemy));
				enemy += 1;
				addNewObject(mon);
			}
			num.remove(randomIndex);
		}
		for (int i = 0; i < 12; i++) {
			// addNewObject(new HitLine());
		}
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
}
