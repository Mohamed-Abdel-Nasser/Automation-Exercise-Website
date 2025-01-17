package Utilities.BrowserSetUp;


import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFactory {

    private final String browserType = BrowserConfiguration.selectedBrowser.trim().toLowerCase();
    private final String executionType = BrowserConfiguration.testExecutionMode.trim().toLowerCase();
    public static WebDriver driver;
    private final LogManager LOGGER = LogManager.getInstance(); // Initialize the logger instance

    public BrowserDriverFactory(WebDriver driver) {
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
    public WebDriver createDriver(String browserType, String executionType) {
        LOGGER.info("Creating WebDriver for browser: " + browserType + " with execution type: " + executionType);

        switch (this.browserType) {
            case "chrome":
                LOGGER.info("Initializing ChromeDriver...");
                return createChromeDriver();
            case "edge":
                LOGGER.info("Initializing EdgeDriver...");
                return createEdgeDriver();
            case "firefox":
                LOGGER.info("Initializing FirefoxDriver...");
                return createFirefoxDriver();
//            case "safari":
//                LOGGER.info("Initializing SafariDriver...");
//                return createSafariDriver();
            default:
                LOGGER.error("Unsupported browser type: " + this.browserType);
                throw new IllegalArgumentException("Unsupported browser type: " + this.browserType);
        }

    }


    private WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        LOGGER.info("Configuring ChromeOptions...");
        configureOptions(options);
        return new ChromeDriver(options);
    }

    private WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        LOGGER.info("Configuring EdgeOptions...");
        configureOptions(options);
        return new EdgeDriver(options);
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        LOGGER.info("Configuring FirefoxOptions...");
        configureOptions(options);
        return new FirefoxDriver(options);
    }

//    private WebDriver createSafariDriver() {
//        SafariOptions options = new SafariOptions();
//        LOGGER.info("Configuring SafariOptions...");
//        configureOptions(options);
//        return new SafariDriver(options);
//    }

    private void configureOptions(Object options) {
        LOGGER.info("Configuring browser options for execution type: " + executionType);

        if (executionType.equals("local headless")) {
            LOGGER.info("Configuring headless mode for " + options.getClass().getSimpleName());
            if (options instanceof ChromeOptions) {
                ((ChromeOptions) options).addArguments("--headless");
            } else if (options instanceof EdgeOptions) {
                ((EdgeOptions) options).addArguments("--headless");
            } else if (options instanceof FirefoxOptions) {
                ((FirefoxOptions) options).addArguments("--headless");
            }
//            else if (options instanceof SafariOptions) {
//                ((SafariOptions) options).addArguments("--headless");
//            }
        } else if (executionType.equals("local")) {
            LOGGER.info("No headless configuration for local execution.");
            // No special configurations needed for local execution (e.g., no headless mode)
        } else {
            LOGGER.error("Unsupported execution type: " + executionType);
            throw new IllegalArgumentException("Unsupported execution type: " + executionType);
        }
    }
}
