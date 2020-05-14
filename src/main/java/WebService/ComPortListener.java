package WebService;

import com.fazecast.jSerialComm.*;

public class ComPortListener implements SerialPortDataListener {

    public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }


    public void serialEvent(SerialPortEvent event)
    {

        byte[] measurementByteArray = new byte[event.getSerialPort().bytesAvailable()];
        int i = event.getSerialPort().readBytes(measurementByteArray, measurementByteArray.length);
        ReformatMeasurementByteArray.parseByteArray(measurementByteArray);
    }
}
