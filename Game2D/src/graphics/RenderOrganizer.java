package graphics;

import java.util.ArrayList;
import java.util.List;

public class RenderOrganizer {
	//Singleton implementation
	
	private static RenderOrganizer instance;
	private List<Shape> shapes = new ArrayList<>();
	
	private RenderOrganizer() {};
	
	public static RenderOrganizer getInstance() {
		if(instance == null)
			instance = new RenderOrganizer();
		return instance;
	}
	
	public List<Shape> getList(){
		return shapes;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void render() {
		shapes.forEach(Shape::draw);
	}
}
