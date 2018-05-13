package com.earth;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.cricle.OpenGl;
import com.cricle.Point;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javafx.scene.chart.PieChart.Data;

public class Earth  extends JFrame implements GLEventListener{

	
	 final private int width = 800;  
	 final private int height = 800;  
     private float rtri;
	 private float dona;
     
	public Earth() {
		// TODO Auto-generated constructor stub
		
       GLProfile profile = GLProfile.get(GLProfile.GL4);  
       GLCapabilities capabilities = new GLCapabilities(profile);  
       GLCanvas canvas = new GLCanvas();  
       canvas.addGLEventListener(this);  
         
       
        
       
       this.setTitle("这是我的地球");  
       this.setName("Minimal OpenGL");  
         
       this.getContentPane().add(canvas);  
         
         
       this.setSize(width,height);  
       this.setLocationRelativeTo(null);  
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
       this.setVisible(true);  
       this.setResizable(false);  
       canvas.requestFocusInWindow();  
	
       FPSAnimator animator = new FPSAnimator(canvas, 300, true);
	   animator.start();
		
	}

	//DDA
	public   void  drawDDA(GLAutoDrawable  drawable,List<Point> sphereCenter,List<Float> radius,Point spinCenter,float velocity) {
	
		
		  GL2 gl = drawable.getGL().getGL2();
	      
	      
	      
	      
	      
		  gl.glClear (GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );    //清除缓存 
	      gl.glLoadIdentity();                  // Reset The View  重新加载
	      
	      gl.glRotatef( rtri, spinCenter.getX(), spinCenter.getY(), spinCenter.getZ() );//triangle rotation  旋转角度
		     
	      
	      
	      
	      for(int num=0;num<sphereCenter.size();num++) {
	      
	      gl.glBegin (GL2.GL_POLYGON);//static field
		        
	    	  
	      //float  i=0f,j=1f;   //模拟x,y制造出曲线z
	      float  x=0.0f;
	      float  y=radius.get(num);
	      float  z=0f;
	      float  dota=0.01f;
		   
	      for(;z<=radius.get(num);) {
	    	 //i=i+j*dota;
	    	 //j=j-x*dota;
	    	// z=radius-j;
	    	 
	    	 
	    	 z=z+y*dota;
	    	 y=y-z*dota;
	    	 
	    	 float  saveY=y;
	    	 for(;y>=0;) {
	    		  x=x+y*dota;
		    	  y=y-x*dota;
		    	    	  
		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(1f, 1f, 0f);
		    	  gl.glVertex3f(x+sphereCenter.get(num).getX(),y+sphereCenter.get(num).getY(),z+sphereCenter.get(num).getZ()); //1
		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(0.5f, 0.5f, 0f);
		    	  gl.glVertex3f(x+sphereCenter.get(num).getX(),y+sphereCenter.get(num).getY(),-z+sphereCenter.get(num).getZ()); //1
		    	  
		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(0f, 1f, 1f);
		    	  gl.glVertex3f(-x+sphereCenter.get(num).getX(),y+sphereCenter.get(num).getY(),z+sphereCenter.get(num).getZ()); //2
		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(0f, 0.5f, 0.5f);
		    	  gl.glVertex3f(-x+sphereCenter.get(num).getX(),y+sphereCenter.get(num).getY(),-z+sphereCenter.get(num).getZ()); //2
			    	  
		    	  

		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(1f, 0f, 1f);
		    	  gl.glVertex3f(-x+sphereCenter.get(num).getX(),-y+sphereCenter.get(num).getY(),z+sphereCenter.get(num).getZ()); //3
		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(0.5f, 0f, 0.5f);
		    	  gl.glVertex3f(-x+sphereCenter.get(num).getX(),-y+sphereCenter.get(num).getY(),-z+sphereCenter.get(num).getZ()); //3
		    	  

		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(1f, 1f, 1f);
		    	  gl.glVertex3f(x+sphereCenter.get(num).getX(),-y+sphereCenter.get(num).getY(),z+sphereCenter.get(num).getZ()); //4
		    	  if(sphereCenter.get(num).getX()==0f){
		    		  gl.glColor3f(0.95f, 0.45f, 0f);
		    	  }else
		    	  gl.glColor3f(0f, 0f, 0f);
		    	  gl.glVertex3f(x+sphereCenter.get(num).getX(),-y+sphereCenter.get(num).getY(),-z+sphereCenter.get(num).getZ()); //4
				    	    	  
		    	  

	        }
	    	 
	    	//状态归还
	    	x=0f;
	    	y=saveY;
	    	 
	      }
	      
	      gl.glEnd();	   
	      
	      }
	      
	      
	      
	      gl.glFlush();
	      rtri=rtri+velocity;

	      
	      //光的色度偏转      
	     /* gl.glEnable( GL2.GL_LIGHTING ); 
	      gl.glEnable( GL2.GL_LIGHT0 ); 
	      gl.glEnable( GL2.GL_NORMALIZE );
	      float[] ambientLight = { 0.1f, 0.f, 0.f,0f }; // weak RED ambient 
	      gl.glLightfv( GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0 ); 
	      float[] diffuseLight = { 1f,2f,1f,0f }; //multi color diffuse 
	      gl.glLightfv( GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0 );
	
	*/
	
	}
	
	
	
	@Override
	public void display(GLAutoDrawable  drawable) {
		// TODO Auto-generated method stub
	
		  //DDA算法
		 List<Point> points=new ArrayList<>();
		 List<Float> radiuses= new ArrayList<>();
		 points.add(new Point(0.4f,0.4f,0.8f));
		 radiuses.add(0.6f);
		 points.add(new Point(-1.0f,-1.0f,-1.0f));
		 radiuses.add(0.8f);

		 points.add(new Point(0.0f,0.0f,0.0f));
		 radiuses.add(0.2f);
		 
		 Point spinPoint =new Point(0.2f,-0.2f, -0.0f);   //旋转中心
	     float velocity=0.5f;   //旋转速度
	     drawDDA(drawable,points,radiuses,spinPoint,velocity); 
		
					
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	
	   
	
	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	    GL4 gl = drawable.getGL().getGL4();  
       gl.glClearColor(0.392f, 0.584f, 0.929f, 0.5f);  
       
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}


	public void play(){  
         
	 }
	
	public  static  void main(String  args[]) {
		 Earth g = new Earth(); 
		 System.out.println("你好 地球");
	}
	
	
}
