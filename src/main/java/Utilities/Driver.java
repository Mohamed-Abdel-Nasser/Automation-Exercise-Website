package Utilities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.Allure;

public class Driver {
    public static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Driver.class);

    public Driver(WebDriver driverInstance) {
        try {
            if (driverInstance == null) {
                String errorMessage = "Provided WebDriver instance is null. Initialization failed.";
                logger.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            if (Driver.driver == null) {
                Driver.driver = driverInstance;
                String successMessage = "WebDriver instance initialized successfully.";
                logger.info(successMessage);
                Allure.step(successMessage);
            } else {
                String warnMessage = "WebDriver instance already exists. Overwriting is not allowed.";
                logger.warn(warnMessage);
                Allure.step(warnMessage);
                throw new IllegalStateException(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error initializing WebDriver instance.";
            logger.error(errorMessage, e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static WebDriver getDriver() {
        try {
            if (driver == null) {
                String errorMessage = "WebDriver is not initialized. Please call setDriver() first.";
                logger.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
            String successMessage = "Returning the existing WebDriver instance.";
            logger.info(successMessage);
            Allure.step(successMessage);
            return driver;
        } catch (Exception e) {
            String errorMessage = "Error getting WebDriver instance.";
            logger.error(errorMessage, e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static void setDriver(WebDriver driverInstance) {
        try {
            if (driver == null) {
                driver = driverInstance;
                String successMessage = "WebDriver instance initialized successfully.";
                logger.info(successMessage);
                Allure.step(successMessage);
            } else {
                String warnMessage = "WebDriver instance is already initialized. Ignoring the setDriver call.";
                logger.warn(warnMessage);
                Allure.step(warnMessage);
                throw new IllegalStateException(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error setting WebDriver instance.";
            logger.error(errorMessage, e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static void quitDriver() {
        try {
            if (driver != null) {
                logger.info("Quitting the WebDriver instance.");
                Allure.step("Quitting the WebDriver instance.");
                driver.quit();
                driver = null;
                String successMessage = "WebDriver instance terminated and resources cleaned up.";
                logger.info(successMessage);
                Allure.step(successMessage);
            } else {
                String warnMessage = "Attempted to quit WebDriver, but it was already null.";
                logger.warn(warnMessage);
                Allure.step(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error quitting WebDriver instance.";
            logger.error(errorMessage, e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static boolean isDriverInitialized() {
        try {
            boolean isInitialized = driver != null;
            String statusMessage = isInitialized ? "WebDriver is initialized." : "WebDriver is not initialized.";
            if (isInitialized) {
                logger.info(statusMessage);
                Allure.step(statusMessage);
            } else {
                logger.warn(statusMessage);
                Allure.step(statusMessage);
            }
            return isInitialized;
        } catch (Exception e) {
            String errorMessage = "Error checking WebDriver initialization status.";
            logger.error(errorMessage, e);
            Allure.step(errorMessage);
            throw e;
        }
    }
}
