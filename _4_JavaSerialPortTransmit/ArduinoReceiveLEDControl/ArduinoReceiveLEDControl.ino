// Receives 65 from JAVA Programrunning on PC and lights up LED connected to Pin 7 

void setup() 
{
  pinMode(7, OUTPUT);            // sets the digital pin 7 as output
  Serial.begin(9600,SERIAL_8N1); // set up the arduino serial 
}

void loop() 
{
  
    byte ReceivedByte = 0;
    
    if(Serial.available()>0)
    {
      ReceivedByte = Serial.read();
      
      if(ReceivedByte == 65)
      {
          digitalWrite(7, HIGH); // sets the digital pin 7 on
          delay(5000);            // waits for a second
          digitalWrite(7, LOW);  // sets the digital pin 7 off
          delay(1000);           // waits for a second
      }    
      
    }//end of serial
}//end of loop() 
