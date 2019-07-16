
public class Game {

	private DisplayScreen screen = DisplayScreen.getInstance();
	
	public Game() {
		
		
	}
	public void start() {
		screen.start();
		
		//game loop
		while(screen.isOpen()) {
			screen.update();
		}
		
		//closing
		screen.close();
		
	}

}
