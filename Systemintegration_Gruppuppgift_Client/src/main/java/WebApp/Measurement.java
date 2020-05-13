package WebApp;

import java.io.Serializable;
import java.util.Date;

public class Measurement implements Serializable
{
    protected int id;
    protected float temperature;
    protected float humidity;
    protected float luminosity;
    protected Date timeStamp;

    public Measurement(){}

    public Measurement(float temperature, float humidity, float luminosity, Date timeStamp)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.luminosity = luminosity;
        this.timeStamp = timeStamp;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public float getTemperature()
    {
        return temperature;
    }

    public void setTemperature(float temperature)
    {
        this.temperature = temperature;
    }

    public float getHumidity()
    {
        return humidity;
    }

    public void setHumidity(float humidity)
    {
        this.humidity = humidity;
    }

    public float getLuminosity()
    {
        return luminosity;
    }

    public void setLuminosity(float luminosity) { this.luminosity = luminosity; }

    public Date getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = timeStamp;
    }
}
