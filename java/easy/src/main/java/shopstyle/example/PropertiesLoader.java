package shopstyle.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The properties loader loads all properties from integerstack.properties.
 */
public class PropertiesLoader {
    private BufferedReader br = null;
    private Map<String, String> properties;

    public PropertiesLoader(String propertiesFileName) {
        properties = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(propertiesFileName));
            String line = br.readLine();
            while (line != null) {
                String[] values = line.split("=");
                properties.put(values[0].toLowerCase(),
                               values[1].toLowerCase());
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + propertiesFileName);
            System.out.println(e.getStackTrace());
        } catch (IOException e) {
            System.out.println("Error while reading properties file.");
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Returns the property associated with the key.
     *
     * @param key - The key we are querying properties by.
     * @return The property associated with the key.
     */
    public String getProperty(String key) {
        if (!properties.containsKey(key.toLowerCase())) {
            throw new RuntimeException(key + " cannot be found in properties.");
        }
        return properties.get(key.toLowerCase());
    }
}
