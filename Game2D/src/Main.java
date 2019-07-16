import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Main {

	public static void main(String[] args) {
		
		Settings.getInstance();
		Game game = new Game();
		
		game.start();
		
	}	
		
	
}
