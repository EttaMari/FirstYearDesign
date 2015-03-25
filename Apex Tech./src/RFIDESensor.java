import rxtxrobot.*;
public class RFIDESensor {
	public void runRFID()
	{
		RFIDSensor rfid = new RFIDSensor(); //Create RFIDSensor object 
		//rfid.setPort(); // Sets the port to COM5 
		rfid.connect(); 
		while (!rfid.hasTag()) 
			rfid.sleep(300); 
		System.out.println("Got tag: " + rfid.getTag());
	}

}
