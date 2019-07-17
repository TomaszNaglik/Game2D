package graphics;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;

public abstract class Shape {

		public Vector2f position = new Vector2f(0,0);
		
		public List<Vector2f> points = new ArrayList<>();	
		
		public abstract void draw();
}
