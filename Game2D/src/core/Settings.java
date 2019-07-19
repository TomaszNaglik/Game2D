package core;

import org.lwjgl.util.vector.Vector2f;

public final class Settings {
	// This will be a singleton implementation of game settings.
	
	//Screen settings
	public final Vector2f screenDimensions = new Vector2f(1800, 1000);
	
	//Game loop
	public final int TARGET_FPS = 100;
	public final double OPTIMAL_TIME = 1_000_000_000 / TARGET_FPS;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Settings instance;
	
	private Settings() {
		initialize();
	}
	
	public static final Settings getInstance() {
		if(instance == null)
			instance = new Settings();
		return instance;
	}
	
	private void initialize() {
		
	}
}
