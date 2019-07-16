/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaders;

/**
 *
 * @author Paulius
 */
public class StaticShader extends ShaderProgram {
    
    private static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
    private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";
    
    
    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0,"position");
    }
    
}
