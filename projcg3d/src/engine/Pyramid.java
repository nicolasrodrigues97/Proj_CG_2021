package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import java.awt.DisplayMode;

public class Pyramid implements GLEventListener{
    public  DisplayMode dm, dm_old;
    private final GLU glu = new GLU();
    private float rtri = 0.0f;
    private GL2 gl;
    private float escala = 30;
    
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
      System.out.println(escala);
      final GL2 gl = drawable.getGL().getGL2();

      gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
      gl.glLoadIdentity();
      gl.glTranslatef( -0.5f, 0.0f, -6.0f );
      
      gl.glRotatef( rtri, 0, 1, 0 );
      
      gl.glScalef(escala, escala, escala); // mult pela escala 
      
      gl.glBegin( GL2.GL_TRIANGLES );  
      // frente
      gl.glColor3f( 0, 0, 1); // azul
      gl.glVertex3f( 0f, 0f, 0f); // topo (lado da frente)
		
      gl.glColor3f( 0, 0, 1); // azul
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // esquerda (lado da frente)
		
      gl.glColor3f( 0, 0, 1); // azul
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // direita (lado da frente)
        
      // direita
      gl.glColor3f( 1, 1, 0 ); // amarelo
      gl.glVertex3f( 0f, 0f, 0f); // topo(lado direito)
		
      gl.glColor3f( 1, 1, 0 ); // amarelo
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // esquerda (lado direito)
		
      gl.glColor3f( 1, 1, 0 ); // amarelo
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // direita(lado direito)
        
      // atrás
      gl.glColor3f( 1, 0, 0); // vermelho
      gl.glVertex3f( 0f, 0f, 0f); // topo (lado de trás)
		
      gl.glColor3f( 1, 0, 0 );
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // esquerda (lado de trás)
		
      gl.glColor3f( 1, 0, 0);
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // direita (lado de trás)
      
      // esquerda 
      gl.glColor3f( 0, 1, 0); // verde
      gl.glVertex3f( 0f, 0f, 0f); // topo (lado esquerdo)
		
      gl.glColor3f( 0, 1, 0); // verde
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // esquerda (lado esquerdo)
		
      gl.glColor3f( 0, 1, 0); // verde
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // direita (lado esquerdo)      
		
      gl.glEnd(); 
      gl.glFlush();
      rtri += 0.2f; 
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      final GL2 gl = drawable.getGL().getGL2();		
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 45.0f, h, 1.0, 20);
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
    }    
    public void aumenta(){ // aumenta a escala da pirâmide
        escala += 1;
    }
    public void diminui(){ // diminui a escala da pirâmide
        escala -= 1;
    }
    
}
