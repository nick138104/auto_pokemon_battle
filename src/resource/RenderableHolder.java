package resource;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	// private <IRenderable> entities;
	// private Comparator<IRenderable> comparator;
	public static ArrayList<Image> monster;
	public static ArrayList<Image> background;
	public static ArrayList<AudioClip> music;
	public static ArrayList<Image> food;

	static {
		loadResource();
	}

	public RenderableHolder() {
		monster = new ArrayList<Image>();
		background = new ArrayList<Image>();
		music = new ArrayList<AudioClip>();
		food = new ArrayList<Image>();

	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		AudioClip musicMenu = new AudioClip(ClassLoader.getSystemResource("music_menu.mp3").toString());
		music.add(musicMenu);
		AudioClip musicFight = new AudioClip(ClassLoader.getSystemResource("music_fight.mp3").toString());
		music.add(musicFight);
		AudioClip hitsound = new AudioClip(ClassLoader.getSystemResource("hit_sound.mp3").toString());
		music.add(hitsound);
		AudioClip freezsound = new AudioClip(ClassLoader.getSystemResource("freez_sound.mp3").toString());
		music.add(freezsound);

		Image backgroundMenu = new Image(ClassLoader.getSystemResource("background_menu.png").toString());
		background.add(backgroundMenu);
		Image backgroundPlay = new Image(ClassLoader.getSystemResource("background_play.jpg").toString());
		background.add(backgroundPlay);

		Image bulbasaur1 = new Image(ClassLoader.getSystemResource("Bulbasaur1.png").toString());
		monster.add(bulbasaur1);
		Image bulbasaur2 = new Image(ClassLoader.getSystemResource("Bulbasaur2.png").toString());
		monster.add(bulbasaur2);
		Image bulbasaur3 = new Image(ClassLoader.getSystemResource("Bulbasaur3.png").toString());
		monster.add(bulbasaur3);
		Image charmander1 = new Image(ClassLoader.getSystemResource("Charmander1.png").toString());
		monster.add(charmander1);
		Image charmander2 = new Image(ClassLoader.getSystemResource("Charmander2.png").toString());
		monster.add(charmander2);
		Image charmander3 = new Image(ClassLoader.getSystemResource("Charmander3.png").toString());
		monster.add(charmander3);
		Image chikorita1 = new Image(ClassLoader.getSystemResource("Chikorita1.png").toString());
		monster.add(chikorita1);
		Image chikorita2 = new Image(ClassLoader.getSystemResource("Chikorita2.png").toString());
		monster.add(chikorita2);
		Image chikorita3 = new Image(ClassLoader.getSystemResource("Chikorita3.png").toString());
		monster.add(chikorita3);
		Image chimchar1 = new Image(ClassLoader.getSystemResource("Chimchar1.png").toString());
		monster.add(chimchar1);
		Image chimchar2 = new Image(ClassLoader.getSystemResource("Chimchar2.png").toString());
		monster.add(chimchar2);
		Image chimchar3 = new Image(ClassLoader.getSystemResource("Chimchar3.png").toString());
		monster.add(chimchar3);
		Image cyndaquil1 = new Image(ClassLoader.getSystemResource("Cyndaquil1.png").toString());
		monster.add(cyndaquil1);
		Image cyndaquil2 = new Image(ClassLoader.getSystemResource("Cyndaquil2.png").toString());
		monster.add(cyndaquil2);
		Image cyndaquil3 = new Image(ClassLoader.getSystemResource("Cyndaquil3.png").toString());
		monster.add(cyndaquil3);
		Image magikarp2 = new Image(ClassLoader.getSystemResource("Magikarp2.png").toString());
		monster.add(magikarp2);
		Image mudkip1 = new Image(ClassLoader.getSystemResource("Mudkip1.png").toString());
		monster.add(mudkip1);
		Image mudkip2 = new Image(ClassLoader.getSystemResource("Mudkip2.png").toString());
		monster.add(mudkip2);
		Image mudkip3 = new Image(ClassLoader.getSystemResource("Mudkip3.png").toString());
		monster.add(mudkip3);
		Image pikachu1 = new Image(ClassLoader.getSystemResource("Pikachu1.png").toString());
		monster.add(pikachu1);
		Image piplup1 = new Image(ClassLoader.getSystemResource("Piplup1.png").toString());
		monster.add(piplup1);
		Image piplup2 = new Image(ClassLoader.getSystemResource("Piplup2.png").toString());
		monster.add(piplup2);
		Image piplup3 = new Image(ClassLoader.getSystemResource("Piplup3.png").toString());
		monster.add(piplup3);
		Image squirtle1 = new Image(ClassLoader.getSystemResource("Squirtle1.png").toString());
		monster.add(squirtle1);
		Image squirtle2 = new Image(ClassLoader.getSystemResource("Squirtle2.png").toString());
		monster.add(squirtle2);
		Image squirtle3 = new Image(ClassLoader.getSystemResource("Squirtle3.png").toString());
		monster.add(squirtle3);
		Image torchic1 = new Image(ClassLoader.getSystemResource("Torchic1.png").toString());
		monster.add(torchic1);
		Image torchic2 = new Image(ClassLoader.getSystemResource("Torchic2.png").toString());
		monster.add(torchic2);
		Image torchic3 = new Image(ClassLoader.getSystemResource("Torchic3.png").toString());
		monster.add(torchic3);
		Image totodile1 = new Image(ClassLoader.getSystemResource("Totodile1.png").toString());
		monster.add(totodile1);
		Image totodile2 = new Image(ClassLoader.getSystemResource("Totodile2.png").toString());
		monster.add(totodile2);
		Image totodile3 = new Image(ClassLoader.getSystemResource("Totodile3.png").toString());
		monster.add(totodile3);
		Image treecko1 = new Image(ClassLoader.getSystemResource("Treecko1.png").toString());
		monster.add(treecko1);
		Image treecko2 = new Image(ClassLoader.getSystemResource("Treecko2.png").toString());
		monster.add(treecko2);
		Image treecko3 = new Image(ClassLoader.getSystemResource("Treecko3.png").toString());
		monster.add(treecko3);
		Image turtwig1 = new Image(ClassLoader.getSystemResource("Turtwig1.png").toString());
		monster.add(turtwig1);
		Image turtwig2 = new Image(ClassLoader.getSystemResource("Turtwig2.png").toString());
		monster.add(turtwig2);
		Image turtwig3 = new Image(ClassLoader.getSystemResource("Turtwig3.png").toString());
		monster.add(turtwig3);

		Image cheri = new Image(ClassLoader.getSystemResource("Cheri_Berry.png").toString());
		food.add(cheri);
		Image chesto = new Image(ClassLoader.getSystemResource("Chesto_Berry.png").toString());
		food.add(chesto);
		Image pecha = new Image(ClassLoader.getSystemResource("Pecha_Berry.png").toString());
		food.add(pecha);
		Image rawst = new Image(ClassLoader.getSystemResource("Rawst_Berry.png").toString());
		food.add(rawst);
		Image aspear = new Image(ClassLoader.getSystemResource("Aspear_Berry.png").toString());
		food.add(aspear);
		Image leppa = new Image(ClassLoader.getSystemResource("Leppa_Berry.png").toString());
		food.add(leppa);
		Image oran = new Image(ClassLoader.getSystemResource("Oran_Berry.png").toString());
		food.add(oran);
	}
}