package core;


import java.time.LocalTime;

import camera.Camera;
import game.Game;
import gui.Gui;
import input.Input;
import menu.Menu;

public class Application {

	private DisplayScreen screen = DisplayScreen.getInstance();
	private Input input = Input.getInstance();
	private Settings settings = Settings.getInstance();
	private Gui gui = Gui.getInstance();
	private Camera camera = Camera.getInstance();
	
	private enum APP_STATE  {MENU, GAME};
	private APP_STATE currentState = APP_STATE.GAME;
	
	private double previous = LocalTime.now().getNano();
	private double lag = 0.0;
	private double current;
	private double elapsed;
	
	private Game game;
	private Menu menu;
	
	
	public Application() throws Exception {
		screen.start();
		this.start();
		
	}
	private void start() throws Exception {
		
		//TEMPORARY SOLUTION BEFORE MENU IS IMPLEMENTED
		game = new Game();
		
		while(screen.isOpen()) {
			
			updateMetrics();
			updateInput();
			while(lag >= settings.OPTIMAL_TIME) {
				camera.update();
				switch (currentState){
				case MENU: menu.update(); break;
				case GAME: game.update(); break;
				
				default: throw new Exception();
				}
				lag -= settings.OPTIMAL_TIME;
			}
			updateGraphics();
			
		}
		this.close();
	}
	
	protected void update() {
		
		
	}
	
	private void updateInput() {
		
		input.update();
	}
	
	private void updateGraphics() {
		gui.update();
		screen.update();
	}
	
	private void close() {
		screen.close();
	}
	
	private void updateMetrics() {
		current = LocalTime.now().getNano();
		elapsed = current - previous;
		previous = current;
		lag += elapsed;
	}

}
