package core;

import java.time.LocalTime;

import org.lwjgl.opengl.GL11;

import camera.Camera;
import gui.Gui;
import input.Input;

public class Game {

	private DisplayScreen screen = DisplayScreen.getInstance();
	private Input input = Input.getInstance();
	private Settings settings = Settings.getInstance();
	private Gui gui = Gui.getInstance();
	private Camera camera = Camera.getInstance();
	
	public Game() {
		
		this.start();
		
	}
	private void start() {
		screen.start();
		
		double previous = LocalTime.now().getNano();
		double lag = 0.0;
				
		while(screen.isOpen()) {
			
			double current = LocalTime.now().getNano();
			double elapsed = current - previous;
			double fps =1_000_000_000 / elapsed;
			//System.out.println("FPS: " +fps +"  Elapsed: "+ elapsed);
				
						
			previous = current;
			lag += elapsed;
			fps++;
			
			this.inputUpdate();
			while(lag >= settings.OPTIMAL_TIME) {
				this.updateGame();
				lag -= settings.OPTIMAL_TIME;
			}
			
			
			
			
			
			this.updateGraphics();
			
		}
		this.close();
	}
	
	private void updateGame() {
		camera.update();
		
	}
	
	private void inputUpdate() {
		
		input.update();
	}
	
	private void updateGraphics() {
		gui.update();
		screen.update();
	}
	
	private void close() {
		screen.close();
	}

}
