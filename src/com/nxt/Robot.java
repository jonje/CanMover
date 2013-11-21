package com.nxt;

import lejos.nxt.Button;

public class Robot {
	private DriveSystem driveSystem;
	private Timer timer;
	private CanDetector canDetector;
	
	private final int ROTATE_AMOUNT = 60;
	private final int MAX_CANS = 3;
	
	private int cansRemoved = 0;
	/**
	 *Initialize
	 *	Determine # of cans to clear
		Initialize DriveSystem
		Initialize Timer
		Initialize CanDetector
	 */
	
	public Robot() {
		driveSystem = new DriveSystem();
		timer = new Timer();
		canDetector = new CanDetector();
		
		
		
	}
	
	/**
	 * run
		while time is not up and not all cans are cleared…
			Rotate robot small amount
			if the CanDetector finds a can,
				remove the can
	 */
	public void run() {
		
		timer.start();
		while(!timer.isTimeUp() && !areCansCleared() && !Button.ESCAPE.isDown()) {
			
				try {
					driveSystem.rotate(ROTATE_AMOUNT);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			if(canDetector.isCanTargeted()) {
				removeCan();
			}
		}
		timer.stop();
		System.out.println("Took " + timer.getTime() + " seconds");
		Button.waitForAnyPress();
		
	}
	
	private boolean areCansCleared() {
		return cansRemoved == MAX_CANS;
	}
	
	/**
	 * removeCan
			until the DriveSystem finds the edge of circle...
				 DriveSystem moveforward 
 DriveSystem stop
			if touching a can,
				add one to cans cleared
				DriveSystem moveBackward a short distance
	 * 
	 */
	
	public void removeCan() {
		
		System.out.println("Ran before if");
		if(driveSystem.moveForward(canDetector)) {
			System.out.println("RANNNNNN");
			cansRemoved++;
		}
		
		try {
			System.out.println("Done in try");
			driveSystem.moveBackward(2500);
			System.out.println("Moving backwards called");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Epic failness");
		}
		
		
	}

}
