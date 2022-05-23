package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.DisplayMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Cube implements GLEventListener{
    public  DisplayMode dm, dm_old;
    private final GLU glu = new GLU();
    private float rquad = 0.0f;
    private GL2 gl;
    private int value = 0;
        
    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);        
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        //
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0f, 0f, -5.0f);

        gl.glRotatef(rquad, 1, 0, 0);
        
        gl.glBegin(GL2.GL_QUADS); 
        gl.glColor3f(1f, 0f, 0f);   //vermelho
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // topo direita (lado do topo)
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // topo esquerda (lado do topo)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // baixo esquerda (lado do topo)
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // baixo direita (lado do topo)
        gl.glColor3f(0f, 1f, 0f); //verde
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // topo direita (lado de baixo)
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // topo esquerda (lado de baixo)
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // baixo esquerda (lado de baixo)
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // baixo direita (lado de baixo) 
        gl.glColor3f(0f, 0f, 1f); //azul
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // topo direito (lado da frente)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // topo esquerdo (lado da frente)
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // baixo esquerdo (lado da frente)
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // baixo direito (lado da frente)
        gl.glColor3f(1f, 1f, 0f); //amarelo
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // baixo esquerdo (lado de trás) 
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // baixo direito (lado de trás)
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // topo direito  (lado de trás)
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // topo esquerdo (lado de trás)
        gl.glColor3f(1f, 0f, 1f); //roxo
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // topo direito (lado esquerdo)
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // topo esquerdo (lado esquerdo)
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // baixo esquerdo (lado esquerdo) 
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // baixo direito (lado esquerdo) 
        gl.glColor3f(0f, 1f, 1f); //azul claro
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // topo direito(lado direito)
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // topo esquerdo (lado direito)
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // baixo esquerdo (lado direito) 
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // baixo direito (lado direito)
        gl.glEnd(); 
        gl.glFlush();           
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }    
    public void rotateCube(){ // rotaciona o cubo
        rquad -= 1f;
    }
}
