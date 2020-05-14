package WebApp;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class WebApp
{
    public void printLastMeasurementOnWeb()
    {
        String url = "http://localhost:8080/getLastMeasurement";
        RestTemplate restTemplate = new RestTemplate();
        Measurement result = restTemplate.getForObject(url, Measurement.class);
        //PRINTA TILL HEMSIDA PÅ NÅT SÄTT
        //System.out.println("Temperature: " + result.temperature + ", Humidity: " + result.humidity + ", Lighting: " + result.lighting + ".");
    }

    public void printMeasurementReportOnWeb()
    {
        String url = "http://localhost:8080/getMeasurementReport";
        RestTemplate restTemplate = new RestTemplate();
        Measurement[] resultArray = restTemplate.getForObject(url, Measurement[].class);
        List<Measurement> result = Arrays.asList(resultArray);
        for(Measurement m : result)
        {
            //PRINTA TILL HEMSIDA PÅ NÅT SÄTT
            //System.out.println("Temperature: " + result.temperature + ", Humidity: " + result.humidity + ", Lighting: " + result.lighting + ".");
        }
    }
}
