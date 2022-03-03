// Program to Control the RTS DTR pin of FT232RL serial port
// 
// Compiled using jSerialComm-2.9.0.jar
//
//https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial
// (c) 2022 www.xanthium.in


import com.fazecast.jSerialComm.*; // Serial Port classes

import java.io.*;
import java.lang.Thread; //For Delay 

public class RtsDtrControlJavaVerbose
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
        //Thread.sleep(2000); 

        if (MySerialPort.isOpen())
    		    System.out.println("\n" + MySerialPort.getSystemPortName() + " is Open ");
        else
   			    System.out.println("Port not open ");
        
        System.out.println("\nRTS/DTR pin Control using Java");
      
        // RTS and DTR pins are active low ,if you are using FT232 
        // So setting RTS will make it 0
          
        // RTS control using Java 
        System.out.println("\n Make RTS High using setRTS() [RTS pin = 1]");
        System.out.println("\n On FT232RL,Pins are Active LOW So RTS pin =0],LED OFF");
      	MySerialPort.setRTS();   // Make RTS pin High 
        Thread.sleep(2000);      // Delay added to so you can see 

        System.out.println("\n Make RTS Low using clearRTS() [RTS pin = 0]");
        System.out.println("\n On FT232RL,Pins are Active LOW So RTS pin =1],LED ON");
        MySerialPort.clearRTS(); // Make RTS pin Low 
        Thread.sleep(2000);      // Delay added to so you can see 
      
        // DTR control using Java 
        System.out.println("\n Make DTR High using setDTR() [DTR pin = 1]");
        System.out.println("\n On FT232RL,Pins are Active LOW So DTR pin =0],LED OFF");
        MySerialPort.setDTR();    // Make DTR pin High 
        Thread.sleep(2000);       // Delay added to so you can see 

        System.out.println("\n Make DTR Low using clearDTR() [DTR pin = 0]");
        System.out.println("\n On FT232RL,Pins are Active LOW So DTR pin =1],LED ON");
        MySerialPort.clearDTR();  // Make DTR pin LOW 
        Thread.sleep(2000);       // Delay added to so you can see 


        
           
      	MySerialPort.closePort(); //Close the port

      	if (MySerialPort.isOpen())
    		System.out.println(MySerialPort.getSystemPortName() + " is Open ");
        else
   			System.out.println("\n Port is closed ");
   
	}//end of main()
}