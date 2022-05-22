package objects;

import graphics.ShapeTracer;
import scene.SceneObject;

public class Triangle extends SceneObject {
	
	public void update () {
            //	
        }
	
	public void render () {
            ShapeTracer.drawTriangle(x, y, width, height);
	}
}
