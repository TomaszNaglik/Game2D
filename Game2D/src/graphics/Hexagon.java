package graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Hexagon extends GraphicsObject {
	
	private static final float PI_THIRD = (float) Math.PI/3;
	private float radius;
	private Vector3f color;
	public Hexagon (Vector2f _position, float _radius) {
		position = _position;
		radius = _radius;
		color = new Vector3f(1,1,1);
		
		for(int i = 0; i<6; i++) {
			
			float theta = i*PI_THIRD;
			points.add(new Vector2f(position.x + radius*(float)Math.cos(theta), position.y + radius*(float)Math.sin(theta)));
			
		}
		
		vertices = new float[points.size()*3];
		for(int i = 0,  j = 0; i< points.size(); i++) {
			vertices[j++] = points.get(i).x;
			vertices[j++] = points.get(i).y;
			vertices[j++] = 0;
			
		}
		
		indices = new byte[]{0,1,5,1,2,5,2,4,5,2,3,4};
;
		
		
		
	}
	
	public Hexagon (float x, float y, float R) {
		this(new Vector2f(x,y), R);
	}

	
	public void draw() {
//		GL11.glColor3f(color.x, color.y, color.z);
//		
//	    GL11.glBegin(GL11.GL_LINE_LOOP);
//	    points.stream().forEach(p -> GL11.glVertex2f(p.x, p.y));
//	    GL11.glEnd();
		
	}

	
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
