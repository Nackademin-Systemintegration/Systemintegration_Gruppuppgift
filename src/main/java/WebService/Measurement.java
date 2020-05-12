package WebService;

import java.io.Serializable;
import java.util.Date;

public class Measurement implements Serializable
{
    protected int id;
    protected float temperature;
    protected float humidity;
    protected float lighting;

    public Measurement(){}

    public Measurement(float temperature, float humidity, float lighting)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.lighting = lighting;
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

    public float getLighting()
    {
        return lighting;
    }

    public void setLighting(float lighting)
    {
        this.lighting = lighting;
    }
}
