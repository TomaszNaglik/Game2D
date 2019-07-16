import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class DisplayScreen {
	//This is a singleton application
	
	private static DisplayScreen instance;
	
	public static DisplayScreen getInstance() {
		if (instance == null)
			instance = new DisplayScreen();
		return instance;
	}
	
	private DisplayScreen() {}
	
	
	
	public void start() {
		try {
            Display.setDisplayMode(new DisplayMode(Settings.getInstance().screenWidth,Settings.getInstance().screenHeight));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
	
	public void update() {
		Display.update();
	}
	
	public void close() {
		Display.destroy();
	}

	public boolean isOpen() {
		return !Display.isCloseRequested();
	}
}
