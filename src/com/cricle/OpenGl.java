package com.cricle;

	
	
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javafx.scene.chart.PieChart.Data;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import javax.swing.JFrame;
	public class OpenGl  extends  JFrame   implements  GLEventListener {

		
		 final private int width = 800;  
    	 final private int height = 800;  

		
		public OpenGl() {
			// TODO Auto-generated constructor stub
			
	        GLProfile profile = GLProfile.get(GLProfile.GL4);  
	        GLCapabilities capabilities = new GLCapabilities(profile);  
	        GLCanvas canvas = new GLCanvas();  
	        canvas.addGLEventListener(this);  
	          
	        
	        
	        
	        this.setTitle("这是我的原型");  
	        this.setName("Minimal OpenGL");  
	          
	        this.getContentPane().add(canvas);  
	          
	          
	        this.setSize(width,height);  
	        this.setLocationRelativeTo(null);  
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
	        this.setVisible(true);  
	        this.setResizable(false);  
	        canvas.requestFocusInWindow();  
		}

		//DDA
		public   void  drawDDA(GLAutoDrawable  drawable) {
		
			  GL2 gl = drawable.getGL().getGL2();
		      gl.glBegin (GL2.GL_POLYGON);//static field
		      
		      
		      float  x=0.0f,y=1.0f;
		      float  dota=0.01f;
		   
		      for(;y>=0;) {
		    		  x=x+y*dota;
			    	  y=y-x*dota;
			    	  
			    	  gl.glVertex2f(x,y); //1
			    	  //gl.glVertex2f(y,x); //1
			    	  
			    	  gl.glVertex2f(-x,y); //2
			    	 // gl.glVertex2f(-y,x); //2
			    	  
			    	  
			    	  gl.glVertex2f(-x,-y); //3
			    	 // gl.glVertex2f(-y,-x); //3
			    	  
			    	  
			    	  gl.glVertex2f(x,-y); //4
			    	 // gl.glVertex2f(y,-x); //4
			    	    	  
			   
		      }
		      
		      gl.glEnd();	   
		      
		      

		}
		
		public  void  drawBresenHam(GLAutoDrawable drawable) {
			GL2 gl = drawable.getGL().getGL2();
		    gl.glBegin (GL2.GL_POLYGON);//static field
		      
		      
		    float  x=0.0f;
		    float  y=1.0f;
		    float  dota=0.01f; 
		    float  d=1.25f*dota-1f;   //初始的d值
		    
		    
		    
		    float   k=0.0f;
		    for(;y>=0.7;) {
		    		if(d<=0) {
		    			d=d+2*x+3*dota;
		    			y=y;
		    		}else {
		    			d=d+2*(x-y)+5*dota;
		    		    y=y-dota;
		    		}
		    		 x=x+dota;
		    		
		    		 gl.glVertex2f(x,y); //1
			    	 gl.glVertex2f(y,x); //1
			    	  
			    	  gl.glVertex2f(-x,y); //2
			    	  gl.glVertex2f(-y,x); //2
			    	  
			    	  
			    	  gl.glVertex2f(-x,-y); //3
			    	  gl.glVertex2f(-y,-x); //3
			    	  
			    	  
			    	  gl.glVertex2f(x,-y); //4
			    	  gl.glVertex2f(y,-x); //4
			    	  
		    	}
		    gl.glEnd();

		}
		
		@Override
		public void display(GLAutoDrawable  drawable) {
			// TODO Auto-generated method stub
		
			 //DDA算法
		     //drawDDA(drawable); 
			
			//BresenHam算法
			drawBresenHam(drawable);
			
						
		}

		@Override
		public void dispose(GLAutoDrawable arg0) {
			// TODO Auto-generated method stub
			
		}

		
		   
		
		@Override
		public void init(GLAutoDrawable drawable) {
			// TODO Auto-generated method stub
			
		    GL4 gl = drawable.getGL().getGL4();  
	        gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);  
	        
			
		}

		@Override
		public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
			// TODO Auto-generated method stub
			
		}
	
	
		public void play(){  
	          
		 }
		
		public  static  void main(String  args[]) {
			 OpenGl g = new OpenGl();  
		      g.play(); 
		}
	}
	
