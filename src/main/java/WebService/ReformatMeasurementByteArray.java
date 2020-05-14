package WebService;
import java.awt.*;

public class ReformatMeasurementByteArray {

    static int cutoffASCII = 10; // ASCII code of the character used for cut-off between received messages
    static String measurementString = ""; // empty, but not null

    public static void parseByteArray(byte[] measurementByteArray) {
        measurementString = measurementString.concat(new String(measurementByteArray));

        String outputString = measurementString.substring(0, measurementString.indexOf(cutoffASCII) + 1);


        measurementString = measurementString.substring(measurementString.indexOf(cutoffASCII) + 1); // adjust as needed to accommodate the CRLF convention ("\n\r"), ASCII 10 & 13
        MeasurementRepository r = new MeasurementRepository();
        Measurement m = new Measurement(outputString);
        r.insertLastMeasurementToDB(m);

    }
}
