package graphics;

import com.jogamp.opengl.GL2;

public class ShapeTracer {
	
	private static float rotation = 0;
	
	public static void drawCircle (float xv, float yv, float width, float height){
            GL2 gl = EventListener.gl;
            int numVertices = 30;
            double radius = width;
            float [] colorArray = new float[]{0.3f, 0.7f, 0.5f};
            gl.glColor3f(colorArray[0], colorArray[1], colorArray[2]);            
            gl.glBegin(GL2.GL_POLYGON);        
                float angle = 0;
                float angleIncrement = (float) (2 * Math.PI / numVertices);
                for (int n = 0; n < numVertices; n++) {
                    angle = n * angleIncrement;
                    float xAxis = xv; float yAxis = yv;
                    float x = (float) (radius * Math.cos(angle)+xAxis);
                    float y = (float) (radius * Math.sin(angle)+yAxis);
                gl.glVertex2d(x, y);
            }
            gl.glEnd();             
                        
        }
	
	public static void drawSquare (float x, float y, float width, float height) {
            GL2 gl = EventListener.gl;
            gl.glTranslatef(x, y, 0);
            gl.glColor3f(1f, 0.3f, 0f);
            gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(-width / 2, -height / 2); // esquerdobaixo
		gl.glVertex2f(width / 2, -height / 2); // direitobaixo
		gl.glVertex2f(width / 2, height / 2); // topodireito
		gl.glVertex2f(-width / 2, height / 2); // topoesquerdo
            gl.glEnd();
            gl.glFlush();
            gl.glTranslatef(-x, -y, 0);
	}
	public static void drawRectangle (float x, float y, float width, float height) {
            GL2 gl = EventListener.gl;
            gl.glTranslatef(x, y, 0);
            float [] colorArray = new float[]{0.9f, 0.7f, 0.1f};
            gl.glColor3f(colorArray[0], colorArray[1], colorArray[2]);            
            gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(-width / 2, -height / 2); // esquerdobaixo
		gl.glVertex2f(width / 2, -height / 2); // direitobaixo
		gl.glVertex2f(width / 2, height / 2); // topodireito
		gl.glVertex2f(-width / 2, height / 2); // topoesquerdo
            gl.glEnd();
            gl.glFlush();;
            gl.glTranslatef(-x, -y, 0);
	}
        
        public static void drawTriangle (float x, float y, float width, float height) {
            GL2 gl = EventListener.gl;
            //gl.glTranslatef(x, y, 0);
            float [] colorArray = new float[]{0.4f, 0.2f, 0.9f};
            gl.glColor3f(colorArray[0], colorArray[1], colorArray[2]);            
            gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(1, -1); // esquerdobaixo
		gl.glVertex2f(2, -1); // direitobaixo
		gl.glVertex2f(1, 0.5f); // topodireito
		gl.glVertex2f(1,0.5f); // topoesquerdo
            gl.glEnd();
            gl.glFlush();;
            gl.glTranslatef(-x, -y, 0);
            
        }	

	public static void setRotation (float r) {
		rotation = r;
	}
}
