package com.nxt;

public class Timer extends Thread {
	private int currentTime;
	private final int MAX_TIME = 10;
	private boolean isRunning;
	
	/**
	 * Start
	 * Begin recording the passing time
	 */
	
	public void startTimer() {
		run();
		
	}
	
/*Stop
	Stop the timer, do NOT reset the time*/
	
	public void stop() {
		isRunning = false;
	}
	
/*Reset
	Stop the timer AND reset the time
*/
	public void reset() {
		isRunning = false; 
		currentTime = 0;
		
	}
	
	private void timeIncrementer() {
		while(isRunning && !isTimeUp()) {
			currentTime++;
			
			try {
				Thread.sleep(1000);
				
			} catch(InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
		}
	}
	
	/*getTime
	Return the current time*/
	public int getTime(){
		return currentTime;
		
	}

/*	isTimeUp	
	return true only if getTime is greater than or equal max time,
*/
	
	public boolean isTimeUp(){
		return (currentTime == MAX_TIME);
	}

	@Override
	public void run() {
		isRunning = true;
		timeIncrementer();
		
	
	}
	
}
