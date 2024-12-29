package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserLink {

    private static final Logger LOGGER = LogManager.getLogger(BrowserLink.class);
    protected static Properties browserProperties;

    static {
        try {
            browserProperties = loadBrowserProperties("src/test/java/DataForTest/Browser.properties");
        } catch (IOException e) {
            LOGGER.error("Failed to load browser properties file", e);
            throw new RuntimeException("Error loading browser properties", e);
        }
    }


    private static Properties loadBrowserProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
            String successMessage = "Successfully loaded browser properties from: " + filePath;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (IOException e) {
            String errorMessage = "Error loading browser properties from file: " + filePath;
            LOGGER.error(errorMessage, e);
            Allure.step(errorMessage);
            throw new IOException(errorMessage, e);
        }
        return properties;
    }

    public static Properties getProperties() {
        return browserProperties;
    }
}
