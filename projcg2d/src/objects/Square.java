package objects;

import graphics.ShapeTracer;
import scene.SceneObject;

public class Square extends SceneObject {
	
	public void update () {
            //	
        }
	
	public void render () {
            ShapeTracer.drawSquare(x, y-2, width, height);
            
	}
}
