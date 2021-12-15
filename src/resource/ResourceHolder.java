package resource;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ResourceHolder {
	private static final ResourceHolder instance;

	public ArrayList<Image> monster = new ArrayList<Image>();
	public ArrayList<Image> background = new ArrayList<Image>();
	public ArrayList<AudioClip> music = new ArrayList<AudioClip>();
	public ArrayList<Image> food = new ArrayList<Image>();
	public Image hitline;

	static {
		instance = new ResourceHolder();
	}

	public ResourceHolder() {
		loadAudioClip(music, "music_menu.mp3");
		loadAudioClip(music, "music_fight.mp3");
		loadAudioClip(music, "hit_sound.mp3");
		loadAudioClip(music, "freez_sound.mp3");
		loadAudioClip(music, "eat_sound.mp3");
		loadAudioClip(music, "error_sound.mp3");
		loadAudioClip(music, "levelup_sound.mp3");
		loadAudioClip(music, "sell_sound.mp3");
		loadAudioClip(music, "select_sound.mp3");
		loadAudioClip(music, "buy_sound.mp3");
		loadAudioClip(music, "music_win.mp3");
		loadAudioClip(music, "music_lose.mp3");

		loadImage(background, "background_menu.png");
		loadImage(background, "background_play.jpg");
		loadImage(background, "background_win.jpg");
		loadImage(background, "background_lose.jpg");
		loadImage(background, "background_market.jpg");

		loadImage(monster, "Bulbasaur1.png");
		loadImage(monster, "Bulbasaur2.png");
		loadImage(monster, "Bulbasaur3.png");
		loadImage(monster, "Charmander1.png");
		loadImage(monster, "Charmander2.png");
		loadImage(monster, "Charmander3.png");
		loadImage(monster, "Chikorita1.png");
		loadImage(monster, "Chikorita2.png");
		loadImage(monster, "Chikorita3.png");
		loadImage(monster, "Chimchar1.png");
		loadImage(monster, "Chimchar2.png");
		loadImage(monster, "Chimchar3.png");
		loadImage(monster, "Cyndaquil1.png");
		loadImage(monster, "Cyndaquil2.png");
		loadImage(monster, "Cyndaquil3.png");
		loadImage(monster, "Magikarp2.png");
		loadImage(monster, "Mudkip1.png");
		loadImage(monster, "Mudkip2.png");
		loadImage(monster, "Mudkip3.png");
		loadImage(monster, "Pikachu1.png");
		loadImage(monster, "Piplup1.png");
		loadImage(monster, "Piplup2.png");
		loadImage(monster, "Piplup3.png");
		loadImage(monster, "Squirtle1.png");
		loadImage(monster, "Squirtle2.png");
		loadImage(monster, "Squirtle3.png");
		loadImage(monster, "Torchic1.png");
		loadImage(monster, "Torchic2.png");
		loadImage(monster, "Torchic3.png");
		loadImage(monster, "Totodile1.png");
		loadImage(monster, "Totodile2.png");
		loadImage(monster, "Totodile3.png");
		loadImage(monster, "Treecko1.png");
		loadImage(monster, "Treecko2.png");
		loadImage(monster, "Treecko3.png");
		loadImage(monster, "Turtwig1.png");
		loadImage(monster, "Turtwig2.png");
		loadImage(monster, "Turtwig3.png");

		loadImage(food, "Cheri_Berry.png");
		loadImage(food, "Chesto_Berry.png");
		loadImage(food, "Pecha_Berry.png");
		loadImage(food, "Rawst_Berry.png");
		loadImage(food, "Aspear_Berry.png");
		loadImage(food, "Leppa_Berry.png");
		loadImage(food, "Oran_Berry.png");

		hitline = new Image(ClassLoader.getSystemResource("hit_effect.png").toString());

	}

	public static ResourceHolder getInstance() {
		return instance;
	}

	public void loadAudioClip(ArrayList<AudioClip> a, final String path) {
		a.add(new AudioClip(ClassLoader.getSystemResource(path).toString()));
	}

	public void loadImage(ArrayList<Image> a, final String path) {
		a.add(new Image(ClassLoader.getSystemResource(path).toString()));
	}
}