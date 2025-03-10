import rxtxrobot.RXTXRobot;

public class PingSensor {
	
	Motors m = new Motors(); // Instantiates motor
	
	public void startPing(int pinNum, int stopDistance)
	{
		m.infiniteMotor(); // runs motor indefinitely
		
		boolean stop = false;
		while(stop == false)
		{
			
			double distance = Start.r.getPing(pinNum);
			System.out.println("Response: " + distance + " cm");
			Start.r.sleep (900);
			
			if(distance <= stopDistance)
			{
				Start.r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0);
				stop = true;
			}	
		}	
	}
}
