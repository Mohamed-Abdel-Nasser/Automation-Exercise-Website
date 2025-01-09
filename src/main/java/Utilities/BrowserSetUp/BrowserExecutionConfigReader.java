package Utilities.BrowserSetUp;

import Utilities.LOGGER.LogManager;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BrowserExecutionConfigReader {

    private static final LogManager LOGGER = LogManager.getInstance();
    private static final String CONFIG_PATH = "src/test/resources/TestData/browserExecutionConfig.json";
    private Gson gson;

    public BrowserExecutionConfigReader() {
        this.gson = new Gson();
    }

    /**
     * Reads browser execution configuration from the JSON file.
     *
     * @return Browser object containing configuration data.
     */
    public Browser readConfigData() {
        try (FileReader reader = new FileReader(CONFIG_PATH)) {
            // Read the JSON data and convert it into a Browser object
            Browser browserConfig = gson.fromJson(reader, Browser.class);

            if (browserConfig != null) {
                LOGGER.info("Configuration loaded successfully.");
                return browserConfig;
            } else {
                LOGGER.warn("Configuration is empty or invalid.");
                return null;
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Configuration file not found at: " + CONFIG_PATH + e);
            throw new RuntimeException("Configuration file not found.", e);
        } catch (IOException e) {
            LOGGER.error("Error reading configuration file." + e);
            throw new RuntimeException("Error reading configuration file.", e);
        }
    }

    /**
     * Inner class representing the structure of the configuration data.
     */
    public static class Browser {
        public String URL;
        public String browserType;
        public String executionType;

}
