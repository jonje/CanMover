package com.nxt;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class CanDetector {
UltrasonicSensor s;
	TouchSensor  t;
	/*
	Initialize
	Initialize SonicSensor
	Initialize TouchSensor
	*/
	public CanDetector()
	{
		s = new UltrasonicSensor(SensorPort.S3);
		t = new TouchSensor(SensorPort.S2);
	}
	

	/*
	isCanTargeted
	Send a ping with SonicSensor
	if distance from ping is less than the size of the circle,
		Assume a can is in front of the robot
	*/
	public boolean isCanTargeted()
	{
		s.ping();
		
		return (s.getDistance() < 200);
	}
	
	
	/*
	isTouchingCan
	If the TouchSensor is pushed,
		Assume the robot is touching a can
	*/
	public boolean isTouchingCan()
	{
		return t.isPressed();
	}
}

