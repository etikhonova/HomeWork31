package helpers;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesReader {
    private Properties properties;

    public PropertiesReader(String propertyFileName) {
        try (InputStream input = new FileInputStream(propertyFileName)) {
            this.properties = new Properties();
            // load a properties file
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {

        return this.properties.getProperty(propertyName);
    }

}

