// Program to Receive tha data send from a  Arduino UNO over Serial Port
// 
// Compiled using jSerialComm-2.9.0.jar
//
// Tutorial -> https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial



// (c) 2022 www.xanthium.in


import com.fazecast.jSerialComm.*; // Serial Port classes

public class SerialPortReception
{
	public static void main (String[] Args)
	{

		int BaudRate = 9600;
		int DataBits = 8;
		int StopBits = SerialPort.ONE_STOP_BIT;
		int Parity   = SerialPort.NO_PARITY;

		SerialPort [] AvailablePorts = SerialPort.getCommPorts();
		
		System.out.println("\n\n SerialPort Data Reception");

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

        MySerialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0); //Set Read Time outs
                  //.setComPortTimeouts(TIMEOUT_Mode, READ_TIMEOUT_milliSec, WRITE_TIMEOUT_milliSec);
        
        MySerialPort.openPort(); //open the port

        if (MySerialPort.isOpen())
    		System.out.println("\n" + MySerialPort.getSystemPortName() + " is Open ");
        else
   			System.out.println(" Port not open ");
      
      	

      	//Display the Serial Port parameters
      	System.out.println("\n Selected Port               = " + MySerialPort.getSystemPortName());
      	System.out.println(" Selected Baud rate          = " + MySerialPort.getBaudRate());
        System.out.println(" Selected Number of DataBits = " + MySerialPort.getNumDataBits());
      	System.out.println(" Selected Number of StopBits = " + MySerialPort.getNumStopBits());
      	System.out.println(" Selected Parity             = " + MySerialPort.getParity());
      	System.out.println(" Selected Read Time Out      = " + MySerialPort.getReadTimeout() + "mS");

      	MySerialPort.flushIOBuffers();

      	try 
      	{
   			while (true)
   			{
      			byte[] readBuffer = new byte[100];
      			int numRead = MySerialPort.readBytes(readBuffer, readBuffer.length);
      			System.out.print("Read " + numRead + " bytes -");
      			//System.out.println(readBuffer);
      			String S = new String(readBuffer, "UTF-8"); //convert bytes to String
      			System.out.println("Received -> "+ S);
   			}
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
