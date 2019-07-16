package camera;

import gui.Gui;

public class Camera {
	private static Camera instance;
	
	private Camera() {}
	
	public static final Camera getInstance() {
		if(instance == null)
			instance = new Camera();
		return instance;
			
	}
	
	public void update() {
		
	}
}

