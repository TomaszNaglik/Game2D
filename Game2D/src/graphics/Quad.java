package graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Quad extends Shape {

	private Vector2f size;
	public Quad(Vector2f _position, Vector2f _size) {
		
		position = _position;
		size = _size;
		points.add(new Vector2f(position.x,         position.y        ));
		points.add(new Vector2f(position.x + size.x, position.y        ));
		points.add(new Vector2f(position.x + size.x, position.y + size.y));
		points.add(new Vector2f(position.x,         position.y + size.y));
	}
	
	public Quad(float x, float y, float sizeX, float sizeY) {
		this(new Vector2f(x,y), new Vector2f(sizeX, sizeY));
	}
	
	@Override
	public void draw() {
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
		GL11.glColor3f(0.0f,0.0f,0.0f);
		
	    GL11.glBegin(GL11.GL_QUADS);
	    points.stream().forEach(p -> GL11.glVertex2f(p.x, p.y));
	    GL11.glEnd();
		
	}

}
