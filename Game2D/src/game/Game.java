package game;

import graphics.Quad;
import graphics.RenderOrganizer;

public class Game {

	public Game() {
		
	}
	
	public void update() {
		RenderOrganizer.getInstance().addShape(new Quad(100,100,100,100));
	}
}
