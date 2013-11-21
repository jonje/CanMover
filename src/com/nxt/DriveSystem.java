package com.nxt;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorConstants;
import lejos.nxt.SensorPort;

public class DriveSystem {
	LightSensor l;
	
	  /*
	  Initialize
				Initialize ColorSensor
		*/
		public DriveSystem()
		{
			l = new LightSensor(SensorPort.S1);
			//Motor.A.setSpeed();
			//Motor.B.setAcceleration(6000);
			//Motor.A.setAcceleration();
		}	
		
		
		/*
		moveForward
				turn the both motors forward simultaneously until the ColorSensor sees the edge of the circle 
		*/
		public boolean moveForward(CanDetector c)
		{
			boolean removedCan = false;
			
			Motor.A.forward();
			Motor.B.forward();
			
			while(l.getLightValue() > 39) {
				System.out.println("Pushing");
				if(c.isTouchingCan() && !removedCan)
				{
					removedCan = true;
				}
			}
			
			stop();
		
			return removedCan;
		}
		
		
	  /*
	  moveBackward
				turn both motors backward simultaneously for the specified time
	  */
	  public void moveBackward(int time) throws InterruptedException
	  {
		System.out.println("Move backward started"); 
	    Motor.A.backward();
	    Motor.B.backward();
	    Thread.sleep(time);
	    
	    stop();
	    System.out.println("Move backward stopped");
	  }
	  
	  
	  /*
	  rotate
				turn the right Motor backwards and the left Motor forwards simultaneously
	      		for the specified time 
	  */
	  public void rotate(int time) throws InterruptedException
	  {
	    Motor.A.rotate(time);
	    Motor.B.rotate(-time);
	    Thread.sleep(time);
	    
	    System.out.println("Port A: " + Motor.A.getSpeed() + " Port B: " + Motor.B.getSpeed());
		System.out.println("Port A: " + Motor.A.getAcceleration() + " Port B: " + Motor.B.getSpeed());
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
