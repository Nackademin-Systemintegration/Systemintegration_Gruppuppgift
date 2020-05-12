package WebService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        this.hostName = "your_server.database.windows.net"; // update me
        this.dbName = "your_database"; // update me
        this.userName = "your_username"; // update me
        this.password = "your_password"; // update me
        this.url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, userName, password);
    }

    public Measurement getLastMeasurement()
    {
        ResultSet rs = null;
        Measurement m = new Measurement();
        String query = "select * from measurements " +
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
                float lighting = rs.getFloat("Lighting");
                m = new Measurement(temperature, humidity, lighting);
                m.setId(id);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return m;
    }

    public List<Measurement> getMeasurementReport()
    {
        ResultSet rs = null;
        Measurement m = new Measurement();
        List<Measurement> measurementReport = new ArrayList<Measurement>();
        String query = "select * from measurements " +
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
                float lighting = rs.getFloat("Lighting");
                m = new Measurement(temperature, humidity, lighting);
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
