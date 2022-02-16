// Arduino Uno
// Transmits a string to PC 
// Rahul.S

// (c) www.xanthium.in 2022
// Tutorial - https://www.xanthium.in/cross-platform-serial-port-programming-tutorial-java-jdk-arduino-embedded-system-tutorial


void setup()
{
  Serial.begin(9600); // opens serial port, sets data rate to 9600 bps 8N1

}

void loop()
{
  char TextToSend[] = "Hello to Java from Arduino UNO";
  Serial.println(TextToSend); // sends a \n with text
  delay(1000);
}
      

  
