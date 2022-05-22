package objects;

import graphics.ShapeTracer;
import scene.SceneObject;

public class Rectangle extends SceneObject {
	
	public void update () {
            //	
        }
	
	public void render () {
            ShapeTracer.drawRectangle(x+1.5f, y+1.5f, width+1, height);
            
	}
}
