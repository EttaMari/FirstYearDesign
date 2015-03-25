import rxtxrobot.*;

public class BumpSensor {
	Motors m = new Motors();
	
	public void callBumpSensor(int pinNum){
		
		m.infiniteMotor(); 
		
		boolean stop = false;
		while (stop == false) // runs and returns values while bump sensor is not touched 
		{
			Start.r.refreshAnalogPins();
			AnalogPin bump = Start.r.getAnalogPin(pinNum); // connects to the sensor
			System.out.println("Sensor " + pinNum + " has value: " + bump.getValue()); // prints out the distance
			
			if (bump.getValue() > 512 )
			{
				Start.r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors 	
				stop = true; // stops while loop
				
			}
				
		} 
	}
	
}
