package Utilities.BrowserSetUp;

import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final LogManager LOGGER = LogManager.getInstance();
    public static WebDriver driver;

    public DriverFactory(WebDriver driver) {
        try {
            if (driver == null) {
                String errorMessage = "WebDriver instance is null. Initialization failed.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException("Driver cannot be null.");
            }
            this.driver = driver;
            String successMessage = String.format("BasePages initialized successfully with driver: %s", driver.toString());
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (IllegalArgumentException e) {
            String errorMessage = "Failed to initialize BasePages: " + e.getMessage();
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "Unexpected error during BasePages initialization: " + e.getMessage();
            LOGGER.error(unexpectedError + e);
            Allure.step(unexpectedError);
            throw new RuntimeException("Error initializing BasePages.", e);
        }
    }
}
