package game;

import org.lwjgl.util.vector.Vector2f;

public enum WorldDimensions { 
	
	HUGE 	(new Vector2f(20_000, 15_000)), 
	BIG		(new Vector2f(15_000, 10_000)), 
	MEDIUM	(new Vector2f(10_000, 5_000)), 
	SMALL	(new Vector2f(3_000, 2_000)), 
	TINY	(new Vector2f(1_800, 1_000)); 
	
	public Vector2f dimensions;
	
	WorldDimensions(Vector2f _dimensions){
		dimensions = _dimensions;
	}
}
