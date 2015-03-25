// goes and gathers remediation materials for turbidity
public class TurbidityMaterials {

	Motors m = new Motors();
	PingSensor p = new PingSensor();
	Servo s = new Servo();
	
	//get turbidity number
	public void getMaterials(double turbidity)
	{
		if (turbidity / 10 < 10 )
		{
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move to 10 balls only
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turn
			
			int tenBalls = (int) (turbidity / 10); 
			
			p.startPing(pinNum, stopDistance);
			
			for(int x = 1; x <= tenBalls; x ++)
				s.servo2(pinNum, angleOfMovement);

		}
		
		if(turbidity % 100 == 0)
		{
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move specific distance to 100 balls
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turns
			
			int hundredBalls = (int) (turbidity / 100);
			
			p.startPing(pinNum, stopDistance);
			
			for(int x = 1; x <= hundredBalls; x++)
				s.servo2(pinNum, angleOfMovement);
		}
		
		if(turbidity / 10 > 10 && turbidity % 100 != 0)
		{
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move specific distance to 10 balls
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turns
			
			int hundredBalls = (int) (turbidity / 100);
			int tenBalls = (int)(turbidity - (hundredBalls * 100)) / 10;
			
			p.startPing(pinNum, stopDistance); // for tenBalls
			
			for(int x = 1; x <= tenBalls; x++)
				s.servo2(pinNum, angleOfMovement);
			
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); //turn towards 100 ball dispenser
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move forward
			m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turn toward dispenser
			p.startPing(pinNum, stopDistance); // move forward towards dispenser if not already the specified distance
			
			for (int x = 1; x <= hundredBalls; x++)
				s.servo2(pinNum, angleOfMovement);
		}
		
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2);  // move to center of course
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // turn back ten ball line
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); // move to ten ball line
		
	}
}
