package nl.han.aim.oose.dea.datasource.util;

import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

    private Properties properties;

    public DatabaseProperties() throws IOException {
        properties = new Properties();
        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            Class.forName(properties.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public String getDriver() {
        return properties.getProperty("driver");
    }

    public String getConnectionstring() {
        return properties.getProperty("connectionstring");
    }


}
