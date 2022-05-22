package objects;

import com.jogamp.newt.event.KeyEvent;
import engine.EventLoop;
import graphics.ShapeTracer;
import input.KeyInput;
import scene.SceneObject;

public class Circle extends SceneObject {
	
	public void update () {
            float xInput = 0;
            float yInput = 0;
            if(KeyInput.getKey(KeyEvent.VK_LEFT)){
                xInput --;
            }
            if(KeyInput.getKey(KeyEvent.VK_RIGHT)){
                xInput ++;
            }
            if(KeyInput.getKey(KeyEvent.VK_UP)){
                yInput ++;
            }
            if(KeyInput.getKey(KeyEvent.VK_DOWN)){
                yInput --;
            }
            x += xInput * EventLoop.updatePos();
            y += yInput * EventLoop.updatePos();
            
	}
	
	public void render () {
            ShapeTracer.drawCircle(x, y, width, height);
	}
	
}