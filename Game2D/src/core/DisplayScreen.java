package core;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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
            Display.setDisplayMode(new DisplayMode(Settings.getInstance().screenWidth,Settings.getInstance().screenHeight));
            Display.setTitle("2D Game");
            Display.create();
            
            //GL.createCapabilities()
    		GL11.glMatrixMode(GL11.GL_PROJECTION);
    		GL11.glOrtho(0, 640, 480, 0, 1, -1);
    	    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    	    GL11.glDisable(GL11.GL_TEXTURE_2D);
            Display.setInitialBackground(1, 1, 1);
            
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
	
	public void update() {
		// Clear the screen and depth buffer
		GL11.glClearColor(1, 1, 1, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
		GL11.glColor3f(0.0f,0.0f,0.0f);
		
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(100,100);
		GL11.glVertex2f(100+200,100);
		GL11.glVertex2f(100+200,100+200);
		GL11.glVertex2f(100,100+200);
	    GL11.glEnd();
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
