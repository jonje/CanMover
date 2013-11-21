package com.nxt;

public class Robot {
	private DriveSystem driveSystem;
	private Timer timer;
	private CanDetector canDetector;
	
	private final int ROTATE_AMOUNT = 32;
	private final int MAX_CANS = 3;
	
	private int cansRemoved = 0;
	/**
	 *Initialize
	 *	Determine # of cans to clear
		Initialize DriveSystem
		Initialize Timer
		Initialize CanDetector
	 */
	
	public void Robot() {
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
		while(!timer.isTimeUp() || !areCansCleared()) {
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
		
		System.out.println("Took " + timer.getTime() + " seconds");
		
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
		driveSystem.moveForward();
		
		if(canDetector.isTouchingCan()) {
			cansRemoved++;
		}
		
	}

}
