package gui;

public class Gui {
	
	private static Gui instance;
	
	private Gui() {}
	
	public static final Gui getInstance() {
		if(instance == null)
			instance = new Gui();
		return instance;
			
	}
	
	public void update() {
		
	}
}
