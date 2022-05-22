package engine;

import graphics.Renderer;
import objects.*;
import scene.Scene;

public class Main {	
	public static void main(String[] args) {
                // começa o renderizador e loop
		Renderer.init();
		EventLoop.start();		
		// objetos
		Scene.addObject(new Circle());
                Scene.addObject(new Square());
                Scene.addObject(new Triangle());
                Scene.addObject(new Rectangle());
	}
	
}