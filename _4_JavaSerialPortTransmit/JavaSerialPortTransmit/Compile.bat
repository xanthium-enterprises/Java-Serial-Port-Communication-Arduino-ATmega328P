DEL *.class
javac -Xdiags:verbose -cp .;jSerialComm-2.9.0.jar SerialPortTransmit.java
java  -cp .;jSerialComm-2.9.0.jar SerialPortTransmit

PAUSE
