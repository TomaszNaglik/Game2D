package game;

import camera.Camera;
import graphics.Hexagon;

import graphics.Renderer;

public class Game {
	
	private WorldDimensions worldDimensions = WorldDimensions.SMALL;
	private Camera camera = Camera.getInstance();
	
	
	public Game() {
		camera.setWorldSize(worldDimensions.dimensions);
		int k = 30;
		int radius = 100;
		float small_radius = radius*(float)Math.sqrt(3)/2;
		float spaceBetweenHexes = 1.01f;
		
		
		for(int i = 0; i<k ; i++)
			for(int j = 0; j< k; j++) {
				if(i%2==0)
					Renderer.getInstance().addGraphicsObject(new Hexagon(i*radius*1.5f*spaceBetweenHexes,j*small_radius*spaceBetweenHexes*2, radius));
				if(i%2==1)
					Renderer.getInstance().addGraphicsObject(new Hexagon(i*radius*1.5f*spaceBetweenHexes,j*2*small_radius*spaceBetweenHexes+small_radius, radius));
			}
			
		
	} 
	
	public void update() {
		
		
		
		
		
	}
}
