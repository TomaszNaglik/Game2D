package input;

public final class Input {
	//Singleton implementation that manages all input 
	
	private static Input instance;
	
	private Input() {}
	
	public static final Input getInstance() {
		if(instance == null)
			instance = new Input();
		return instance;
	}
	
	public void update() {
	
	}
}
