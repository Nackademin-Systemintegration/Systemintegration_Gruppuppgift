package WebService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class WebService
{
    MeasurementRepository r = new MeasurementRepository();

    public WebService()
    {
    }

    @RequestMapping(value = "/getLastMeasurement", produces = "application/xml")
    public Measurement getLastMeasurement()
    {
        r = new MeasurementRepository();
        return r.getLastMeasurement();
    }

    @RequestMapping(value = "/getMeasurementReport", produces = "application/xml")
    public List<Measurement> getMeasurementReport()
    {
        r = new MeasurementRepository();
        return r.getMeasurementReport();
    }
}
