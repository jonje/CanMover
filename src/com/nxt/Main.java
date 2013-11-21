package com.nxt;

import lejos.nxt.Button;
import lejos.nxt.Motor;

public class Main {

	public static void main(String[] args) {
		//Motor.A.forward();
		//Motor.B.forward();
		//Button.waitForAnyPress();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		Robot robot = new Robot();
		robot.run();

	}

}
