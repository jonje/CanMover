package com.nxt;

import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class DriveSystem {
	ColorSensor c;
	
	  /*
	  Initialize
				Initialize ColorSensor
		*/
		public DriveSystem()
		{
			c = new ColorSensor(SensorPort.S1);
		}
		
		
		/*
		moveForward
				turn the both motors forward simultaneously until the ColorSensor sees the edge of the circle 
		*/
		public void moveForward()
		{
		  Motor.A.forward();
		  Motor.B.forward();
		  while(c.getColorID() != c.BLACK)
		  {
			  System.out.println("Pushing...");
		  }
		  stop();
		  System.out.println("Completed");
		}
		
		
	  /*
	  moveBackward
				turn both motors backward simultaneously for the specified time
	  */
	  public void moveBackward(int time) throws InterruptedException
	  {
	    Motor.A.backward();
	    Motor.B.backward();
	    Thread.sleep(time);
	    stop();
	  }
	  
	  
	  /*
	  rotate
				turn the right Motor backwards and the left Motor forwards simultaneously
	      		for the specified time 
	  */
	  public void rotate(int time) throws InterruptedException
	  {
	    Motor.A.backward();
	    Motor.B.forward();
	    Thread.sleep(time);
	    stop();
	  }
	  
	  
	  /*
	  stop
		    Stop both motors rotation
	  */
	  public void stop()
	  {
	    Motor.A.stop();
	    Motor.B.stop();
	  }
	}
