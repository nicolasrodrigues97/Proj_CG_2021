package engine;

import graphics.Renderer;
import scene.Scene;

public class EventLoop {
	
	private static boolean running = false;
	
	private static int updates = 0;
	private static final int MAX_UPDATES = 5;
	
	private static long lastUpdateTime = 0;
	
	private static int targetFPS = 60;
	private static int targetTime = 1000000000 / targetFPS;
	
	public static void start () {
		Thread thread = new Thread () {
                    public void run () {
                        running = true;	
                        lastUpdateTime = System.nanoTime();
                        int fps = 0;
                        long lastFpsCheck = System.nanoTime();
                        while (running) {
                            long currentTime = System.nanoTime();	
                            updates = 0;	
                            while (currentTime - lastUpdateTime >= targetTime) {
                                Scene.update();
                                lastUpdateTime += targetTime;
                                updates ++;	
                                if (updates > MAX_UPDATES) {
					break;
				}
                            }
                            Renderer.render();
                            fps++;
                            if (System.nanoTime() >= lastFpsCheck + 1000000000) {
                                //System.out.println(fps);
                                fps = 0;
                                lastFpsCheck = System.nanoTime();
                            }
					
                            long timeTaken = System.nanoTime() - currentTime;
                	    if (targetTime > timeTaken) {
                                try {
                                    Thread.sleep((targetTime - timeTaken) / 1000000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
					
                        }		
                    }
		};
		thread.setName("GameLoop");
		thread.start();
    }
    public static float updatePos(){
        return 1.0f / 1000000000 * targetTime;
    }
}
