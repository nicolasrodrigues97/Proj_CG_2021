package graphics;

import com.jogamp.newt.event.KeyAdapter;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import input.KeyInput;

public class Renderer {  
    private static GLWindow window = null;
    private static GLProfile profile = null;    
    public static int screenWidth = 1280;
    public static int screenHeight = 720;
    public static float unitsWide = 10;    
    
    public static void render(){
        if (window == null) {
            return;
        }
        window.display();
    }
    
    public static void init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);        
        GLCapabilities caps = new GLCapabilities(profile);        
        
        window = GLWindow.create(caps);
        window.setSize(1280, 720);
        window.setResizable(false);
        window.addGLEventListener(new EventListener());
        window.setTitle("Java Open GL - 2D CG 2021  APERTE ESC PARA ENCERRAR");        
        window.addKeyListener(new KeyInput());
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();
        window.setVisible(true);
        //window.setFullscreen(true);
        
        window.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    animator.stop();
                    window.destroy();
                    System.exit(0);
                }
            }
        });           
    }
    public static int getWindowWidth () {
	return window.getWidth();
    }
	
    public static int getWindowHeight () {
	return window.getHeight();
    }
	
    public static GLProfile getProfile () {
	return profile;
    }    
}
