package com.nxt;

public class Robot {
	private DriveSystem driveSystem;
	private Timer timer;
	private CanDetector canDetector;
	
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
		
	}

}
