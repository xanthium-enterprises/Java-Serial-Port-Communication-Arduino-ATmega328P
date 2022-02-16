// Program to list the available serial ports on your system
// Compiled using jSerialComm-2.9.0.jar
//

//javac -cp .;jSerialComm-2.9.0.jar SerialPortsAvail.java
//java  -cp .;jSerialComm-2.9.0.jar SerialPortsAvail

//https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial
// (c) 2022 www.xanthium.in

import com.fazecast.jSerialComm.*;

public class SerialPortsAvail
{
	public static void main (String[] Args)
	{
		
		System.out.println("\n" + "jSerialComm Version ->" + SerialPort.getVersion()+"\n\n");          


		SerialPort [] AvailablePorts = SerialPort.getCommPorts();
		
		// use the for loop to print the available serial ports
		for(SerialPort S : AvailablePorts)
		{
			System.out.println("Port Number                                -> .getSystemPortName()     -> " + S.getSystemPortName()); //Gives the number of com port,Eg COM9
			System.out.println("Port Physical Location (OS)                -> .getSystemPortPath()     -> " + S.getSystemPortPath());
		    System.out.println("Port Physical Location (USB hub)           -> .getSystemPortLocation() -> " + S.getPortLocation());
		    System.out.println("Port Description as reported by the device -> .getDescriptivePortName()-> " + S.getDescriptivePortName());
            System.out.println("Port Description  .toString()              ->  .toString()             -> " + S.toString() + "\n");
		    
		}//end of loop
	}//end of main()
}
