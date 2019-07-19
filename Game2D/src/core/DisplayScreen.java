package core;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import camera.Camera;
import graphics.RenderOrganizer;

public final class DisplayScreen {
	//This is a singleton application
	
	private static DisplayScreen instance;
	
	public static final DisplayScreen getInstance() {
		if (instance == null)
			instance = new DisplayScreen();
		return instance;
	}
	
	private DisplayScreen() {
		
	}
	
	
	
	public void start() {
		try {
            Display.setDisplayMode(new DisplayMode((int)Settings.getInstance().screenDimensions.x,(int)Settings.getInstance().screenDimensions.y));
            Display.create();
            Display.setInitialBackground(1, 1, 1);
            initGL();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
	
	private void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glOrtho(0, (int)Settings.getInstance().screenDimensions.x,(int)Settings.getInstance().screenDimensions.y, 0, 1, -1);
	    GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    GL11.glDisable(GL11.GL_TEXTURE_2D);
	}

	public void update() {
		
		//float x = Camera.getInstance().getSpeed().x;
		//float y = Camera.getInstance().getSpeed().y;
		
		
		
		GL11.glClearColor(1, 1, 1, 1);
		
		//GL11.glOrtho(0, (int)Settings.getInstance().screenDimensions.x,(int)Settings.getInstance().screenDimensions.y, 0, 1, -1);
	    //GL11.glTranslatef(Settings.getInstance().screenDimensions.x/2,Settings.getInstance().screenDimensions.y/2,0);
	    //GL11.glTranslatef(x, y, 0);
		
		//GL11.glRotatef(0.1f, 0, 0, 1);
	    //GL11.glOrtho(5000, 1800, 1000, 500, 0, 0);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    //GL11.glDisable(GL11.GL_TEXTURE_2D);
	    
		RenderOrganizer.getInstance().render();
		Display.update();
		Display.sync(Settings.getInstance().TARGET_FPS);
	}
	
	public void close() {
		Display.destroy();
	}

	public boolean isOpen() {
		return !(Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE));
	}
}
