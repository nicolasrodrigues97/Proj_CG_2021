package scene;

import java.util.ArrayList;
public class Scene {
	
	private static ArrayList<SceneObject> sceneObjects = new ArrayList<SceneObject>();
	
	public static void update () {
		// itera sobre o vetor de objetos e realiza update em cada
		for (SceneObject o : sceneObjects) {
                    o.update();
		}
	}
	
	public static void render () {
		// renderizar todos objetos
		for (SceneObject o : sceneObjects) {
                    o.render();
		}
	}
	
	public static void addObject (SceneObject o) {
		sceneObjects.add(o);
	}
	
}