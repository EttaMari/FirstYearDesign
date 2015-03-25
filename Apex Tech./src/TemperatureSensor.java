//collects temperature data

import java.lang.Math;

public class TemperatureSensor {
	
	public double testThermestor() {
		
		double sum = 0;
	    int readingCount = 10;
	    
	    
	    //Read the analog pin values ten times, adding to sum each time
	    for (int i = 0; i < readingCount; i++) {
	       //Refresh the analog pins so we get new readings
	        Start.r.refreshAnalogPins();
	        int reading = Start.r.getAnalogPin(0).getValue();
	        sum += reading;
	    }
	    double code = sum / readingCount;
	    return code;
	    
	}
	
	public double getTemperature(double code){
		
		double rT = 0;
		double rFixed = 1109.473;
		double tRef = 259.7281;
		double rRef = 914.337;
		double b = 4008.636;
		double temp = 0;
		
		rT = rFixed / ( (1023 / code) - 1);
		System.out.println(rT);
		
		double v = 1 / tRef;
		double w = 1 / b; 
		double x = rT / rRef;
		
		temp = (1 / (v + ( w * Math.log(x) ) ) ) - 273;
 
		return temp; 
		
	}
	
	
		
	// send out start to sensor
	// Receive temperature and set to global variable
}
