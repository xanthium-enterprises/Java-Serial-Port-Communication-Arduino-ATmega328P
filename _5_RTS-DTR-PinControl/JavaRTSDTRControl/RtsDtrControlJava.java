// Program to Control the RTS DTR pin of FT232RL serial port
// 
// Compiled using jSerialComm-2.9.0.jar
//
//https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial
// (c) 2022 www.xanthium.in


import com.fazecast.jSerialComm.*; // Serial Port classes

import java.io.*;
import java.lang.Thread; //For Delay 

public class RtsDtrControlJava
{
	public static void main (String[] Args) throws Exception
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
      
      
        // RTS and DTR pins are active low ,if you are using FT232 
        // So setting RTS will make it 0
          
        // RTS control using Java 
      	MySerialPort.setRTS();   // Make RTS pin High 
        Thread.sleep(2000);      // Delay added to so you can see 
        MySerialPort.clearRTS(); // Make RTS pin Low 
        Thread.sleep(2000);      // Delay added to so you can see 
      
        // DTR control using Java 
        MySerialPort.setDTR();    // Make DTR pin High 
        Thread.sleep(2000);       // Delay added to so you can see 
        MySerialPort.clearDTR();  // Make DTR pin High 
        Thread.sleep(2000);       // Delay added to so you can see 


        
           
      	MySerialPort.closePort(); //Close the port

      	if (MySerialPort.isOpen())
    		System.out.println(MySerialPort.getSystemPortName() + " is Open ");
        else
   			System.out.println("\n Port is closed ");
   
	}//end of main()
}