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

	static {
		loadResource();
	}

	public RenderableHolder() {
		monster = new ArrayList<Image>();
		background = new ArrayList<Image>();
		music = new ArrayList<AudioClip>();

	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		AudioClip musicMenu = new AudioClip(ClassLoader.getSystemResource("music_menu.mp3").toString());
		music.add(musicMenu);
		AudioClip musicFight = new AudioClip(ClassLoader.getSystemResource("music_fight.mp3").toString());
		music.add(musicFight);
		Image backgroundMenu = new Image(ClassLoader.getSystemResource("background_menu.png").toString());
		background.add(backgroundMenu);
		Image backgroundPlay = new Image(ClassLoader.getSystemResource("background_play.jpg").toString());
		background.add(backgroundPlay);
	}
}
