package Utilities.BrowserSetUp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Utilities.LOGGER.LogManager;

public class BrowserLoadProperties {

    private static final LogManager LOGGER = LogManager.getInstance();
    private static final String propertiesFilePath = "src/test/resources/TestData/Browser.properties"; // Corrected path
    private static Properties Propertiesconfig = new Properties();

    public static void loadProperties() {
        try (FileInputStream input = new FileInputStream(propertiesFilePath)) {
            Propertiesconfig.load(input);
            LOGGER.info("Successfully loaded configuration from properties file.");
        } catch (IOException e) {
            LOGGER.error("Error loading configuration from properties file: " + e.getMessage());
            throw new RuntimeException("Failed to load configuration file.", e);
        }
    }

    public static String getPropertyValue(String key) {
        if (Propertiesconfig.isEmpty()) {
            LOGGER.error("Configuration has not been loaded yet. Call loadProperties() first.");
            throw new IllegalStateException("Configuration has not been loaded yet.");
        }

        String value = Propertiesconfig.getProperty(key);
        if (value == null) {
            LOGGER.error("Key '" + key + "' not found in the configuration.");
            throw new IllegalArgumentException("Key '" + key + "' not found in the configuration.");
        }

        return value;
    }
}
