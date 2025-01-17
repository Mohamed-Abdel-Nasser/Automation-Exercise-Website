package TestBase;


import Utilities.BrowserSetUp.BrowserDriverFactory;
import Utilities.BrowserSetUp.BrowserConfiguration;
import Utilities.LOGGER.LogManager;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public WebDriver driver;
    private final LogManager LOGGER = LogManager.getInstance(); // Initialize the logger instance


    @BeforeSuite
    public void initDriver() {
        if (driver == null) {
            LOGGER.info("Initializing browser driver...");
            // Initialize the WebDriver instance here
            driver = new ChromeDriver();

            BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(driver);
            LOGGER.info("Creating WebDriver for browser type: " + BrowserConfiguration.selectedBrowser + " as specified in the JSON configuration file.");
            driver = browserDriverFactory.createDriver(BrowserConfiguration.selectedBrowser, BrowserConfiguration.testExecutionMode);
            if (driver != null) {
                LOGGER.info("Driver initialized successfully for browser: " + BrowserConfiguration.selectedBrowser);
            } else {
                LOGGER.error("Failed to initialize the driver.");
            }
        }
    }


    @BeforeMethod
    public void deleteAllCookies() {
        if (driver != null) {
            LOGGER.info("Deleting all cookies before test execution.");
            driver.manage().deleteAllCookies();
        } else {
            LOGGER.error("Driver is not initialized. Unable to delete cookies.");
        }
    }

    @AfterMethod
    public void refreshBrowser() {
        if (driver != null) {
            LOGGER.info("Refreshing the browser after test.");
            try {
                driver.navigate().refresh();
            } catch (NoSuchWindowException e) {
                LOGGER.error("Window already closed. Unable to refresh the browser."+e);
            }
        } else {
            LOGGER.error("Driver is not initialized. Unable to refresh the browser.");
        }
    }

    @AfterSuite
    public void closeDriver() {
        if (driver != null) {
            LOGGER.info("Closing the browser after all tests.");
            driver.quit();
            LOGGER.info("Browser closed successfully.");
        } else {
            LOGGER.error("Driver is not initialized. Unable to close the browser.");
        }
    }
}
