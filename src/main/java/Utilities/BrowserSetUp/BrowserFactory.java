package Utilities.BrowserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import Utilities.LOGGER.LogManager;

public class BrowserFactory {

    private static final LogManager LOGGER = LogManager.getInstance();
    private static WebDriver driver;
    private static String browser = "chrome"; // Default browser
    private static String url = "http://your-default-url.com"; // Default URL

    public static WebDriver setBrowser() {
        try {
            // Fetch browser type and URL dynamically from configuration (could be a properties file, environment variables, etc.)
            browser = BrowserConfig.getBrowser(); // Assume a method to get the browser type
            url = BrowserConfig.getUrl(); // Assume a method to get the URL

            LOGGER.info("Initializing " + browser + " browser.");

            // Initialize WebDriver based on the browser type
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    // chromeOptions.addArguments("--headless"); // Uncomment if headless is required
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    // firefoxOptions.addArguments("--headless"); // Uncomment if headless is required
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    // edgeOptions.addArguments("--headless"); // Uncomment if headless is required
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browser);
            }

            driver.manage().window().maximize();
            driver.navigate().to(url); // Navigate to the configured URL
            LOGGER.info("Browser launched successfully. Navigated to: " + url);

            return driver;
        } catch (Exception e) {
            LOGGER.error("Error while initializing the browser: " + e.getMessage());
            throw new RuntimeException("Failed to initialize the browser.", e);
        }
    }
}
