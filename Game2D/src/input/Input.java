package input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public final class Input {
	//Singleton implementation that manages all input 
	
	private static Input instance;
	
		
	private Input() {}
	
	public void start() {
		try {
			Keyboard.create();
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final Input getInstance() {
		if(instance == null)
			instance = new Input();
		return instance;
	}
	
	public void update() {
		//System.out.println(Mouse.getX()+"  "+ Mouse.getY());
	}
	
	public void close() {
		Keyboard.destroy();
	}
	
}
