package engine;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) {        
        Cube cb = new Cube();
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        // canvas 
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        glcanvas.addGLEventListener(cb);
        glcanvas.setSize(600, 600);
        final JFrame frame = new JFrame("Cubo 3D");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final FPSAnimator animator = new FPSAnimator(glcanvas, 60, true);
        animator.start();

        glcanvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                System.out.println("parei de girar");
            }
            @Override 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    System.out.println("girando");
                    cb.rotateCube(); // rotaciona o cubo
                }
            }            
        });
        Pyramid pi = new Pyramid();
        // canvas 
        final GLCanvas glcanvas2 = new GLCanvas(capabilities);
        glcanvas2.addGLEventListener(new Pyramid());
        glcanvas2.setSize(600, 600);
        final JFrame frame2 = new JFrame("Pirâmide 3D");
        frame2.getContentPane().add(glcanvas2);
        frame2.setSize(frame2.getContentPane().getPreferredSize());
        frame2.setVisible(true);
        frame2.setLocation(70,70);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final FPSAnimator animator2 = new FPSAnimator(glcanvas2, 60, true);
        animator2.start(); 
        glcanvas2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                //
            }
            @Override 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    System.out.println("aumentando");
                    pi.aumenta(); // aumenta a escala da pirâmide
                }
                else if (e.getKeyCode() == KeyEvent.VK_D) {
                    System.out.println("diminuindo");
                    pi.diminui(); // diminui a escala da pirâmide               
                }
            }            
        });                
        
        Rect3d rct = new Rect3d();
        // canvas 
        final GLCanvas glcanvas3 = new GLCanvas(capabilities);
        glcanvas3.addGLEventListener(new Rect3d());
        glcanvas3.setSize(600, 600);
        final JFrame frame3 = new JFrame("Retângulo 3D");
        frame3.getContentPane().add(glcanvas3);
        frame3.setSize(frame3.getContentPane().getPreferredSize());
        frame3.setVisible(true);
        frame3.setLocation(1280,70);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final FPSAnimator animator3 = new FPSAnimator(glcanvas3, 60, true);
        animator3.start();         
    }

}