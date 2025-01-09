package Utilities.BrowserSetUp;

import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browser extends Driver {
    private static final LogManager LOGGER = LogManager.getInstance();
    private static final String URL = BrowserLinkLoadProperties.getProperties().getProperty("URL");

    public Browser(WebDriver driver) {
        super(driver);
    }

    @BeforeMethod
    public static WebDriver setBrowser() {
        if (URL == null || URL.isEmpty()) {
            String errorMessage = "URL is not provided in the properties file.";
            LOGGER.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.navigate().to(URL);

            String successMessage = "Browser initialized successfully and navigated to the URL: " + URL;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return driver;
        } catch (Exception e) {
            String errorMessage = "Error occurred while setting up the browser: ";
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage + e.getMessage());
            throw new RuntimeException("Failed to initialize the browser.", e);
        }
    }

    @AfterMethod
    public static void quit() {
        if (driver != null) {
            try {
                driver.quit();
                String successMessage = "Browser closed and resources released.";
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            } catch (Exception e) {
                String errorMessage = "Error occurred while closing the browser: ";
                LOGGER.error(errorMessage + e);
                Allure.step(errorMessage + e.getMessage());
            } finally {
                driver = null;
            }
        } else {
            String warningMessage = "No browser instance to quit.";
            LOGGER.warn(warningMessage);
            Allure.step(warningMessage);
        }
    }
}
