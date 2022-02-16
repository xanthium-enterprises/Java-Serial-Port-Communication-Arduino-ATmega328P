// Program to Transmit tha data to Arduino UNO over Serial Port from PC 
// 
// Compiled using jSerialComm-2.9.0.jar
//
// Tutorial -> https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial



// (c) 2022 www.xanthium.in


import com.fazecast.jSerialComm.*; // Serial Port classes

import java.io.*;
import java.lang.Thread; //For Delay 

public class SerialPortTransmit 
{
	public static void main (String[] Args) throws Exception
	{

		int BaudRate = 9600;
		int DataBits = 8;
		int StopBits = SerialPort.ONE_STOP_BIT;
		int Parity   = SerialPort.NO_PARITY;

		SerialPort [] AvailablePorts = SerialPort.getCommPorts();
		
		System.out.println("\n\n SerialPort Data Transmission");

		// use the for loop to print the available serial ports
		System.out.print("\n\n Available Ports ");
		for (int i = 0; i<AvailablePorts.length ; i++)
		{
			System.out.println(i + " - " + AvailablePorts[i].getSystemPortName() + " -> " + AvailablePorts[i].getDescriptivePortName());
		}

        //Open the first Available port
        SerialPort MySerialPort = AvailablePorts[0];
        

        // Set Serial port Parameters
        MySerialPort.setComPortParameters(BaudRate,DataBits,StopBits,Parity);//Sets all serial port parameters at one time

               
        MySerialPort.openPort(); //open the port
        //Arduino Will Reset 
        System.out.println(" Watch Arduino for Reset ");
        Thread.sleep(5000);//Delay added to so you can see the Arduino getting Resetted


        if (MySerialPort.isOpen())
    		System.out.println("\n" + MySerialPort.getSystemPortName() + "  is Open ");
        else
   			System.out.println(" Port not open ");
      
      	

      	//Display the Serial Port parameters
      	System.out.println("\n Selected Port               = " + MySerialPort.getSystemPortName());
      	System.out.println(" Selected Baud rate          = " + MySerialPort.getBaudRate());
        System.out.println(" Selected Number of DataBits = " + MySerialPort.getNumDataBits());
      	System.out.println(" Selected Number of StopBits = " + MySerialPort.getNumStopBits());
      	System.out.println(" Selected Parity             = " + MySerialPort.getParity());
      	
      	Thread.sleep(2000); //Delay introduced because when the SerialPort is opened ,Arduino gets resetted
      						// Time for the code in Arduino to rerun after Reset

      	try 
      	{
      			byte[] WriteByte = new byte[1];
      			WriteByte[0] = 65; //send A
      			

      			int bytesTxed  = 0;

      			bytesTxed  = MySerialPort.writeBytes(WriteByte,1);

      			System.out.print(" Bytes Transmitted -> " + bytesTxed );
      			   			
		} 
		catch (Exception e) 
		{
			 e.printStackTrace(); 
		}


      	MySerialPort.closePort(); //Close the port

      	if (MySerialPort.isOpen())
    		System.out.println(MySerialPort.getSystemPortName() + " is Open ");
        else
   			System.out.println("\n Port not open ");
   
	}//end of main()
}
