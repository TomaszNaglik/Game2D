package graphics;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector2f;

import camera.Camera;

public class Renderer {


	
	private List<Integer[]> vaoData = new ArrayList<>();
	private static Renderer instance;
	private static Camera camera = Camera.getInstance();

	private static List<Float> mapElements = new ArrayList<>();
	
	
	private Renderer() {}
	
	public static Renderer getInstance() {
		if(instance == null)
			instance = new Renderer();
		return instance;
	}

	
	public void start() {
		/*
		for (final Float value: mapElements) {
			   vertices.get(i++) = value;
			}
		vertexCount = vertices.length;*/
		
		
	}
	
	public void addGraphicsObject(GraphicsObject object) {
		
		Integer[] data = new Integer[4];
		FloatBuffer verticesBuffer = createFloatBuffer(object.getVertices());
		ByteBuffer indicesBuffer  = createFloatBuffer(object.getIndices());
		
		data[0] = BindVAO();
		data[1] = BindVBO(verticesBuffer);
		data[2] = BindVBO(indicesBuffer);
		data[3] = object.getIndices().length;
		
		vaoData.add(data);
		
	}
	
	private int BindVBO(ByteBuffer buffer) {
		int i = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, i);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL30.glBindVertexArray(0);
		return i;
	}

	private int BindVBO(FloatBuffer buffer) {
		int i = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, i);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL30.glBindVertexArray(0);
		return i;
	}

	private int BindVAO() {
		int i = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(i);
		return i;
	}

	private FloatBuffer createFloatBuffer(float[] array) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(array.length);
		buffer.put(array);
		buffer.flip();
		return buffer;
	}
	private ByteBuffer createFloatBuffer(byte[] array) {
		ByteBuffer buffer = BufferUtils.createByteBuffer(array.length);
		buffer.put(array);
		buffer.flip();
		return buffer;
	}

	public void update() {
		
		camera.update();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		 
		for( Integer[] i : vaoData) {
			GL30.glBindVertexArray(i[0]);
			GL20.glEnableVertexAttribArray(0);
			 
			// Draw the vertices
			GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, i[2]);
			GL11.glDrawElements(GL11.GL_TRIANGLES, i[3], GL11.GL_UNSIGNED_BYTE, 0);
			 
			// Put everything back to default (deselect)
			GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
			GL20.glDisableVertexAttribArray(0);
			GL30.glBindVertexArray(0);
		}
	}
		
		
		
	
	public void close() {
		GL20.glDisableVertexAttribArray(0);
		for( Integer[] i : vaoData) {
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
			GL15.glDeleteBuffers(i[1]);
			
			
			GL30.glBindVertexArray(0);
			GL30.glDeleteVertexArrays(i[0]);
			
			GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
			GL15.glDeleteBuffers(i[2]);
		}
		
	}
	
}
