package game;

import camera.Camera;
import graphics.Quad;
import graphics.RenderOrganizer;

public class Game {
	
	private WorldDimensions worldDimensions = WorldDimensions.TINY;
	private Camera camera = Camera.getInstance();
	
	
	public Game() {
		camera.setWorldSize(worldDimensions.dimensions);
		RenderOrganizer.getInstance().addShape(new Quad(850,450,50,50));
	} 
	
	public void update() {
		camera.update();
		
		
	}
}
