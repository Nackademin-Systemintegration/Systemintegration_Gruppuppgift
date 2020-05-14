package WebApp;

import java.io.Serializable;
import java.util.Date;

public class Measurement implements Serializable
{
    protected int id;
    protected String temperature;
    protected Date timeStamp;

    public Measurement(){}

    public Measurement(String temperature)
    {
        this.temperature = temperature;

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTemperature()
    {
        return temperature;
    }

    public void setTemperature(String temperature)
    {
        this.temperature = temperature;
    }


    public Date getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = timeStamp;
    }
}
