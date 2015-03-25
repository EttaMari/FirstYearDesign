// collects all salinity data


public class SalinitySensor {
	
		
	public double testSalinity() {
			
		double sum = 0;
		
	    int readingCount = 5;
		    
		    
		    //Read the analog pin values ten times, adding to sum each time
	   for (int i = 0; i < readingCount; i++) 
	   {
		  double reading = Start.r.getConductivity();
		   //Refresh the analog pins so we get new readings
		   
		   sum += reading;
		  
		}
		   double code = sum / readingCount;
		   
		   return code;	    
	}
		
	public double getSalinity(double code){
			double distance = 2.82147839;
			double resistance = 0;
			double area = 6.96390728;
			double conductivity = 0;
			double rFixed = 812.117467; 	
			
			resistance = rFixed / ( (1023 / code) - 1);
		
			conductivity  = distance / (resistance * area) * 10000;
			
			return conductivity; 
		}
}