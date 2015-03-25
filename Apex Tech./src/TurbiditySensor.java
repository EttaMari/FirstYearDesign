
public class TurbiditySensor {
	public double testTurbidity() {
		
		double sum = 0;
		
	    int readingCount = 5;
		    
		    
		    //Read the analog pin values ten times, adding to sum each time
	   for (int i = 0; i < readingCount; i++) 
	   {
		  double reading = Start.r.getAnalogPin(pinNumb).getValue();
		   //Refresh the analog pins so we get new readings
		   
		   sum += reading;
		  
	   }
	   
	   double code = sum / readingCount;   
	   return code;	    
	}
		
	public double getTurbidity(double code)
	{
		double vOut;
		double rFixed;
		
		vOut = rFixed / (1023 / code - 1);
		
		
		return turbidity; 
	}
}
