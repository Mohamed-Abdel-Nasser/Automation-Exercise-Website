package TestBase;

import io.qameta.allure.Epic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Epic("Automation Exercise")
public class Browser {

    private static final Logger logger = LogManager.getLogger(Browser.class);
    public static WebDriver driver;

    @BeforeClass
    public void browser() {
        logger.info("Initializing the browser setup.");
        driver = Utilities.Browser.setBrowser();
        if (driver == null) {
            logger.error("Browser setup failed.");
            throw new RuntimeException("Browser setup failed.");
        }
        logger.info("Browser initialized successfully.");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            logger.info("Quitting the browser.");
            Utilities.Browser.quit();
            driver = null;
            logger.info("Browser quit successfully.");
        } else {
            logger.warn("Browser is already null, no action taken.");
        }
    }
}
