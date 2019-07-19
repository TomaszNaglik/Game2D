package camera;
import org.lwjgl.input.Keyboard;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import core.Settings;

public class Camera {
	private static Camera instance;
	
	private Vector2f viewPort = Settings.getInstance().screenDimensions;
	private Vector2f worldSize = Settings.getInstance().screenDimensions;
	private Vector2f position = new Vector2f(worldSize.x/2, worldSize.y/2);
	private Vector2f speed = new Vector2f(0,0);
		
	private boolean hasWorldSizeChanged = false;
	
	private float maxSpeed = 1;
	private float friction = 1.00f;
	private float deltaA = 100;

	
		
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
		
		this.position = new Vector2f(worldSize.x/2, worldSize.y/2);
		Keyboard.enableRepeatEvents(true);
		
	}

	public void setWorldSize(Vector2f size) {
		this.worldSize = size;
		this.hasWorldSizeChanged = true;
	}
	
	private void move() {
		if(true)//Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			System.out.println("Left is Michal");//accelerate(new Vector2f(-deltaA,0));
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			accelerate(new Vector2f(deltaA,0));
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			accelerate(new Vector2f(0, -deltaA));
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			accelerate(new Vector2f(0, deltaA));
	}
	
	private void accelerate(Vector2f direction) {
		Vector2f.add(speed, direction, speed);
	}

	public void update() {
		
		
		if(hasWorldSizeChanged) {
			 init();
			 hasWorldSizeChanged = false;
		 }
		move();
		applyMax(speed, maxSpeed);
		Vector2f.add(position, speed, position);
		
		GL11.glTranslatef(speed.x, speed.y, 0);
		speed.scale(friction);
		
		//System.out.println(this);
	}
	
	private void applyMax(Vector2f vector, float max) {
		vector.x = Math.min(vector.x, max);
		vector.y = Math.min(vector.y, max);
	}

	public String toString() {
		return "Cam_Pos: "+ position.toString()+ "   Cam_Speed: " + speed.toString();
	}
		
}

