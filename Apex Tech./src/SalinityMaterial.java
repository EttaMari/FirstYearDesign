// goes and gathers remediation materials for salinity
public class SalinityMaterial {
	
	Motors m = new Motors();
	PingSensor p = new PingSensor();
	Servo s = new Servo();

	//through a process of loops determines how many of each type of ball is gotten
	public void getMaterials(double salinity)
	{
		if (salinity / 10 < 10 )
		{
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move to 10 balls only
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turn
			
			int tenBalls = (int) (salinity / 10); 
			
			p.startPing(pinNum, stopDistance);
			
			for(int x = 1; x <= tenBalls; x ++) // knocks balls out
			{
				s.servo2(pinNum, angleOfMovement);
				s.servo2(pinNum, angleOfMovement);
			}
				

		}
		
		if(salinity % 100 == 0)
		{
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move specific distance to 100 balls
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turns
			
			int hundredBalls = (int) (salinity / 100);
			
			p.startPing(pinNum, stopDistance);
			
			for(int x = 1; x <= hundredBalls; x++)
			{
				s.servo2(pinNum, angleOfMovement);
				s.servo2(pinNum, angleOfMovement);
			}
		}
		
		if(salinity / 10 > 10 && salinity % 100 != 0)
		{
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move specific distance to 10 balls
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turns
			
			int hundredBalls = (int) (salinity / 100);
			int tenBalls = (int)(salinity - (hundredBalls * 100)) / 10;
			
			p.startPing(pinNum, stopDistance); // for tenBalls
			
			for(int x = 1; x <= tenBalls; x++)
			{
				s.servo2(pinNum, angleOfMovement);
				s.servo2(pinNum, angleOfMovement);
			}
			
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); //turn towards 100 ball dispenser
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move forward
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turn toward dispenser
			p.startPing(pinNum, stopDistance); // move forward towards dispenser if not already the specified distance
			
			for (int x = 1; x <= hundredBalls; x++)
			{
				s.servo2(pinNum, angleOfMovement);
				s.servo2(pinNum, angleOfMovement);
			}
		}
		
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2);  // move to center of course
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turn back ten ball line
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move to ten ball line
		
	}
	
	
}
