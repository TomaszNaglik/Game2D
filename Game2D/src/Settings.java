
public class Settings {
	// This will be a singleton implementation of game settings.
	
	//Screen settings
	public final int screenWidth = 1800;
	public final int screenHeight = 1200;
	
	
	private static Settings instance;
	
	private Settings() {
		initialize();
	}
	
	public static Settings getInstance() {
		if(instance == null)
			instance = new Settings();
		return instance;
	}
	
	private void initialize() {
		
	}
}
