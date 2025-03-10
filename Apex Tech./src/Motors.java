//controls all motor actions 
import rxtxrobot.*;
public class Motors {
	
	// connects to motors and moves specified distance and speed
	public void tickMotor(int speed1, int tickAmountM1, int speed2, int tickAmountM2)
	{	
		
		Start.r.runEncodedMotor(RXTXRobot.MOTOR1, speed1, tickAmountM1, RXTXRobot.MOTOR2, speed2, tickAmountM2); 
		
	}
	
	// connects motors and runs them indefinitely until stop statement is performed in calling class
	public void infiniteMotor()
	{
		Start.r.runMotor(RXTXRobot.MOTOR1, 100, RXTXRobot.MOTOR2, -100, 0);
		Start.r.sleep(2000); 
	}
}
