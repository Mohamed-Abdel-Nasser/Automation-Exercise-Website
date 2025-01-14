package Utilities.BrowserSetUp;

import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

public classDriver {
    private static final LogManager LOGGER = LogManager.getInstance();
    public static WebDriver driver;

    public Driver(WebDriver driver) {
        try {
            if (driver == null) {
                String errorMessage = "Provided WebDriver instance is null. Initialization failed.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            if (Driver.driver == null) {
                Driver.driver = driver;
                String successMessage = "WebDriver instance initialized successfully.";
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            } else {
                String warnMessage = "WebDriver instance already exists. Overwriting is not allowed.";
                LOGGER.warn(warnMessage);
                Allure.step(warnMessage);
                throw new IllegalStateException(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error initializing WebDriver instance.";
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static WebDriver getDriver() {
        try {
            if (driver == null) {
                String errorMessage = "WebDriver is not initialized. Please call setDriver() first.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
            String successMessage = "Returning the existing WebDriver instance.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return driver;
        } catch (Exception e) {
            String errorMessage = "Error getting WebDriver instance.";
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static void setDriver(WebDriver driverInstance) {
        try {
            if (driver == null) {
                driver = driverInstance;
                String successMessage = "WebDriver instance initialized successfully.";
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            } else {
                String warnMessage = "WebDriver instance is already initialized. Ignoring the setDriver call.";
                LOGGER.warn(warnMessage);
                Allure.step(warnMessage);
                throw new IllegalStateException(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error setting WebDriver instance.";
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static void quitDriver() {
        try {
            if (driver != null) {
                LOGGER.info("Quitting the WebDriver instance.");
                Allure.step("Quitting the WebDriver instance.");
                driver.quit();
                driver = null;
                String successMessage = "WebDriver instance terminated and resources cleaned up.";
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            } else {
                String warnMessage = "Attempted to quit WebDriver, but it was already null.";
                LOGGER.warn(warnMessage);
                Allure.step(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error quitting WebDriver instance.";
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public static boolean isDriverInitialized() {
        try {
            boolean isInitialized = driver != null;
            String statusMessage = isInitialized ? "WebDriver is initialized." : "WebDriver is not initialized.";
            if (isInitialized) {
                LOGGER.info(statusMessage);
                Allure.step(statusMessage);
            } else {
                LOGGER.warn(statusMessage);
                Allure.step(statusMessage);
            }
            return isInitialized;
        } catch (Exception e) {
            String errorMessage = "Error checking WebDriver initialization status.";
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw e;
        }
    }
}

