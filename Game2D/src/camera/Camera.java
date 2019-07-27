package camera;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import core.Settings;

public class Camera {
	private static Camera instance;
	
	private Vector2f viewPort = Settings.getInstance().screenDimensions;
	private Vector2f worldSize = Settings.getInstance().screenDimensions;
	private Vector2f position = new Vector2f(0,0);//worldSize.x/2, worldSize.y/2);
	private Vector2f speed = new Vector2f(0,0);
		
	private boolean hasWorldSizeChanged = false;
	private float inititalMaxSpeed = 10;
	private float maxSpeed = 10;
	private float friction = 0.96f;
	private float deltaA = 3;

	private float zoom = 1;

	private float zoomSpeed = 0f;
	private float zoomAcc = 0.001f;
	private float maxZoom = 1.1f;
	private float currentZoom = 0;

	
	

	
		
	public static final Camera getInstance() {
		if(instance == null)
			instance = new Camera();
		return instance;
			
	}
	
	private Camera() {
		init();
		
	}
	
		
	public Vector2f getSpeed() {
		return speed;
	}
	private void init() {
		
		this.position = new Vector2f(0,0);//worldSize.x/2, worldSize.y/2);
		
	}

	public void setWorldSize(Vector2f size) {
		this.worldSize = size;
		this.hasWorldSizeChanged = true;
	}
	
	private void move() {
		
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Mouse.getX() < 100)
			accelerate(new Vector2f(deltaA,0));
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)|| Mouse.getX() > viewPort.x - 100)
			accelerate(new Vector2f(-deltaA,0));
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)   || Mouse.getY() > viewPort.y - 100)
			accelerate(new Vector2f(0, deltaA));
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Mouse.getY() < 100)
			accelerate(new Vector2f(0, -deltaA));
		
		
		
		applyMax(speed, maxSpeed);
		GL11.glTranslatef(-position.x, -position.y, 0); // move back view to origin
		Vector2f.add(position, speed, position);
		
		GL11.glTranslatef(position.x, position.y, 0);
		applyMapConstraints();
		//System.out.println("Position: " + position);// + "   ViewPort: " + viewPort);
		
		speed.scale(friction);
		 
	}
	
	private void applyMapConstraints() {
		
		if(position.x < -(worldSize.x - viewPort.x))
			position.x = -(worldSize.x - viewPort.x);
		if(position.x > 0)
			position.x = 0;
		if(position.y < -(worldSize.y - viewPort.y))
			position.y = -(worldSize.y - viewPort.y);
		if(position.y > 0)
			position.y = 0;
		
	}
	
	private void scale() {
		
		int dWheel = Mouse.getDWheel();
		if(Keyboard.isKeyDown(Keyboard.KEY_PRIOR) || dWheel>0)
			zoomSpeed += zoomAcc;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NEXT)|| dWheel<0)
			zoomSpeed -= zoomAcc;
		currentZoom += zoomSpeed;
		zoom += zoomSpeed;
		zoom = Math.min(maxZoom, zoom);
		zoomSpeed *= friction;
		if(zoom != 1) {
			GL11.glTranslatef(-position.x , -position.y, 0);
			GL11.glScalef(zoom, zoom, 1);
			GL11.glTranslatef(position.x * zoom, position.y *zoom , 0);
			
			zoom = 1;
		}
		
	}

	private void accelerate(Vector2f direction) {
		
		Vector2f.add(speed, direction, speed);
	}

	public void update() {
		
		if(hasWorldSizeChanged) {
			 init();
			 hasWorldSizeChanged = false;
		 }
		
		scale();
		modifySpeedParametersDueToScale();
		move();
		
	}
	
	private void modifySpeedParametersDueToScale() {
		maxSpeed = inititalMaxSpeed *(1-currentZoom);
		
	}

	private void applyMax(Vector2f vector, float max) {
		vector.x = vector.x > 0? Math.min(vector.x, max) : Math.max(vector.x, -max);
		vector.y = vector.y > 0? Math.min(vector.y, max) : Math.max(vector.y, -max);
	}

	public String toString() {
		return "Cam_Pos: "+ position.toString()+ "   Cam_Speed: " + speed.toString();
	}
		
}

