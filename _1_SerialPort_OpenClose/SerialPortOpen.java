// Program to Open a connection to Serial Port and close it 
// Check the size of the Read and Write Buffers
// Compiled using jSerialComm-2.9.0.jar
//

//javac -cp .;jSerialComm-2.9.0.jar SerialPortsAvail.java
//java  -cp .;jSerialComm-2.9.0.jar SerialPortsAvail

//https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial
// (c) 2022 www.xanthium.in


import com.fazecast.jSerialComm.*; // Serial Port classes
import java.util.Scanner;          // Import the Scanner class (Console IO)

public class SerialPortOpen
{
	public static void main (String[] Args)
	{

		SerialPort [] AvailablePorts = SerialPort.getCommPorts();
		
		// use the for loop to print the available serial ports
		System.out.println("\n\nAvailable Ports ");
		for (int i = 0; i<AvailablePorts.length ; i++)
		{
			System.out.println(i + " - " + AvailablePorts[i].getSystemPortName() + " -> " + AvailablePorts[i].getDescriptivePortName());
		}

        //Open the first Available port
        SerialPort MySerialPort = AvailablePorts[0];
        
        MySerialPort.openPort(); //open the port

        if (MySerialPort.isOpen())
    		System.out.println("\n" + MySerialPort.getSystemPortName() + " is Open ");
        else
   			System.out.println(" Port not open ");
      
      	System.out.println("Transmit buffer size -> " + MySerialPort.getDeviceWriteBufferSize());
      	System.out.println("Receiver buffer size -> " + MySerialPort.getDeviceReadBufferSize());

      	MySerialPort.closePort(); //Close the port

      	if (MySerialPort.isOpen())
    		System.out.println(MySerialPort.getSystemPortName() + " is Open ");
        else
   			System.out.println("\n Port not open ");
   
	}//end of main()
}
