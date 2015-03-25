//controls all servo actions
import rxtxrobot.*;
public class Servo {
	
	//move servo amount dependent on variable number 
	
	public void servo1(int pinNum, int angleOfMovement)
	{	
		Start.r.attachServo(RXTXRobot.SERVO1, pinNum); 
		Start.r.moveServo(RXTXRobot.SERVO1, angleOfMovement);
		Start.r.sleep(8000); 
	}
	
	public void servo2(int pinNum, int angleOfMovement)
	{	
		Start.r.attachServo(RXTXRobot.SERVO2, pinNum); 
		Start.r.moveServo(RXTXRobot.SERVO2, angleOfMovement);
		Start.r.sleep(8000); 
	}
	public void servo3(int pinNum, int angleOfMovement)
	{	
		Start.r.attachServo(RXTXRobot.SERVO3, pinNum); 
		Start.r.moveServo(RXTXRobot.SERVO3, angleOfMovement);
		Start.r.sleep(8000); 
	}
	
}
