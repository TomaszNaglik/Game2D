package graphics;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;

public class GraphicsObject {

	protected Vector2f position;
	public List<Vector2f> points = new ArrayList<>();
	protected float[] vertices;
	protected float[] textCoords;
	protected byte[] indices;
	public GraphicsObject() {
		
	
	}
	
	public float[] getVertices() {
		return vertices;
	}
	public float[] getTextCoords() {
		return textCoords;
	}
	public byte[] getIndices() {
		return indices;
	}
}
