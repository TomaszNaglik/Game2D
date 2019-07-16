package core;

public final class Settings {
	// This will be a singleton implementation of game settings.
	
	//Screen settings
	public final int screenWidth = 1800;
	public final int screenHeight = 1000;
	
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
