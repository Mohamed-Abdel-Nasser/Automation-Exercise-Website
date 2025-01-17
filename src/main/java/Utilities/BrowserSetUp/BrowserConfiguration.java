package Utilities.BrowserSetUp;

import org.openqa.selenium.WebDriver;

public class BrowserConfiguration {
    public BrowserConfiguration(WebDriver driver) {
    }

    public static String testUrl;
    public static String selectedBrowser;
    public static String testExecutionMode;

    // Static block to load the configuration
    static {
        BrowserLoadProperties.loadProperties();  // Ensure the configuration is loaded before using any properties
        testUrl = BrowserLoadProperties.getPropertyValue("URL");
        selectedBrowser = BrowserLoadProperties.getPropertyValue("browserType");
        testExecutionMode = BrowserLoadProperties.getPropertyValue("executionType");

    }
}
