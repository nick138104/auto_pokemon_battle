package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import entity.base.Gameobject;
import entity.base.HitLine;
import entity.base.Monster;
import interfacepackage.IRenderable;
import javafx.collections.ObservableList;
import resource.RenderableHolder;

public class BattleUtils {

	private ObservableList<IRenderable> gameObjectContainer;

	public void startBattle() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		List<Integer> num = new ArrayList<>();
		num.add(0);
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		for (int i = 0; i < 5; i++) {
			int randomIndex = rand.nextInt(num.size());
			if (Objects.nonNull(MarketManager.monsters.get(randomIndex)))
				//addNewObject(MarketManager.monsters.get(randomIndex).createCopy());
			num.remove(randomIndex);
		}
		for (int i = 0; i < 12; i++) {
			// addNewObject(new HitLine());
		}
	}

	protected void addNewObject(Gameobject object) {
		if (object instanceof Monster) {
			Monster mon = (Monster) object;
			gameObjectContainer.add(mon);
			RenderableHolder.getInstance().add(mon);
		} else {
			HitLine hitline = (HitLine) object;
			gameObjectContainer.add(hitline);
			RenderableHolder.getInstance().add(hitline);
		}

	}
}
