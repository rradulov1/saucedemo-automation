package saucedemo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static Properties loadConfigProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}


