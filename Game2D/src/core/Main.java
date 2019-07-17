package core;
public class Main {

	public static void main(String[] args) {
		
		Settings.getInstance();
		try {
			Application application = new Application();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
		
	
}
