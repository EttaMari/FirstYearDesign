import rxtxrobot.*;

import java.lang.Math;
// calls all functions

public class Start {
	
	public static RXTXRobot r; 
	
	public static void main(String[] args) {
		r = new ArduinoNano(); 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1420"); 
		r.connect(); 
		
		
		Motors m = new Motors();
		m.tickMotor(speed1, tickAmountM1, speed2, tickAmountM2); //move towards water container
		
		Servo sTesting = new Servo();
		sTesting.servo1(pinNum, angleOfMovement); // drop servo with sensors
		
		TemperatureSensor temp = new TemperatureSensor();
		double thermestorCode = temp.testThermestor(); 
		double temperature = temp.getTemperature(thermestorCode); 
		System.out.println ("The ACD Code is " + thermestorCode + " and the temperature is " + temperature + "."); 
		
		SalinitySensor saln = new SalinitySensor();
		double salinityCode = saln.testSalinity();
		double salinity = saln.getSalinity(salinityCode);
		System.out.println("The ACD Code is " + salinityCode + " and the salinity is " + salinity+ ".");
		
		TurbiditySensor turb = new TurbiditySensor();
		double turbidityCode = turb.testTurbidity();
		double turbidity = turb.getTurbidity(turbidityCode);
		System.out.println("The ACD Code is " + turbidityCode + " and the turbidity is " + turbidity + ".");
		
		sTesting.servo1(pinNum, angleOfMovement); // move sensors out of water
		
		SalinityMaterial sM = new SalinityMaterial(); 
		sM.getMaterials(salinity); //retrieve salinity materials
		
		TurbidityMaterials tM = new TurbidityMaterials();
		tM.getMaterials(turbidity); // retrieve turbidity materials
		
		Servo sDrop = new Servo();
		sDrop.servo3(pinNum, angleOfMovement);
		r.sleep(30000);
		
		//call FindBridge
		//call FindRemediationDropOff
		//call Teater-Totter
		r.close();
	}	
		
}		