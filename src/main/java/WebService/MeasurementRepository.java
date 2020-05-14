package WebService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeasurementRepository
{
    protected String hostName;
    protected String dbName;
    protected String userName;
    protected String password;
    protected String url;

    public MeasurementRepository()
    {
        this.hostName = "elviras-sql-server.database.windows.net"; // update me
        this.dbName = "elviras-sql-server"; // update me
        this.userName = "dreamteam"; // update me
        this.password = "S0ckerlönn!"; // update me
        this.url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, userName, password);
    }

    public Measurement getLastMeasurementFromArduino()
    {
        ResultSet rs = null;
        Measurement m = new Measurement();
        String query = "select Temperature, Humidity, Luminosity, TimeStamp from measurements " +
                "order by Id desc " +
                "limit 1";

        try (Connection con = DriverManager.getConnection(url);
            PreparedStatement stmt = con.prepareStatement(query))
        {
            rs = stmt.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("Id");
                float temperature = rs.getFloat("Temperature");
                float humidity = rs.getFloat("Humidity");
                float luminosity = rs.getFloat("Luminosity");
                Date timeStamp = rs.getDate("TimeStamp");
                m = new Measurement(temperature, humidity, luminosity, timeStamp);
                m.setId(id);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        insertLastMeasurementToDB(m);
        return m;
    }

    public void insertLastMeasurementToDB(Measurement lastMeasurement)
    {
        String query = "insert into measurements (Temperature, Humidity, Luminosity, TimeStamp)" +
                "values (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(query))
        {
            stmt.setFloat(1, lastMeasurement.temperature);
            stmt.setFloat(2, lastMeasurement.humidity);
            stmt.setFloat(3, lastMeasurement.luminosity);
            stmt.setDate(4, (java.sql.Date)lastMeasurement.timeStamp);
            int numberOfUpdates = stmt.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Measurement> getMeasurementReport()
    {
        ResultSet rs = null;
        Measurement m = new Measurement();
        List<Measurement> measurementReport = new ArrayList<Measurement>();
        String query = "select Temperature, Humidity, Luminosity, TimeStamp from measurements " +
                "order by Id desc " +
                "limit 7";

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(query))
        {
            rs = stmt.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("Id");
                float temperature = rs.getFloat("Temperature");
                float humidity = rs.getFloat("Humidity");
                float luminosity = rs.getFloat("Luminosity");
                Date timeStamp = rs.getDate("TimeStamp");
                m = new Measurement(temperature, humidity, luminosity, timeStamp);
                m.setId(id);

                measurementReport.add(m);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return measurementReport;
    }
}
