package WebService;

import com.fazecast.jSerialComm.*;

public class ComPortInitializer {

    public SerialPort firstAvailableComPort;

    public void ComPortInit() {

        SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();

        for(SerialPort eachComPort:allAvailableComPorts)
            System.out.println("List of all available serial ports: " + eachComPort.getDescriptivePortName());

        firstAvailableComPort = allAvailableComPorts[0];

        firstAvailableComPort.openPort();

        System.out.println("Opened the first available serial port: " + firstAvailableComPort.getDescriptivePortName());

        ComPortListener listenerObject = new ComPortListener();

        firstAvailableComPort.addDataListener(listenerObject);
    }

}


