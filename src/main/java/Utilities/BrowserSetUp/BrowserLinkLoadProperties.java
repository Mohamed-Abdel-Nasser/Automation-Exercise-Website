package Utilities.BrowserSetUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Utilities.LOGGER.LogManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Utilities.LOGGER.LogManager;

public class BrowserLinkLoadProperties {

    private static final LogManager LOGGER = LogManager.getInstance();
    private static final String PATH = "src/main/resources/properties/testEnvironmentConfig.json";
    protected static Properties browserProperties;
    private static JsonNode configData;

    // Method to load the JSON configuration
    public static void loadConfig() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            configData = objectMapper.readTree(new File(PATH));
            LOGGER.info("Successfully loaded configuration from JSON file.");
        } catch (IOException e) {
            LOGGER.error("Error loading configuration from JSON file");
        }
    }

    // Method to retrieve a property value from the loaded JSON
    public static String getPropertyValue(String key) {
        if (configData == null) {
            LOGGER.error("Configuration has not been loaded yet.");
            throw new IllegalStateException("Configuration has not been loaded yet.");
        }
    }
}
