package Utilities.BrowserSetUp;

import org.openqa.selenium.WebDriver;

public class FrameworkConstants {
    public FrameworkConstants(WebDriver driver) {
    }

    public static String testingLink;
    public static String browser;
    public static String executionType;

    // Static block to load the configuration
    static {
        BrowserLinkLoadProperties.loadConfig();  // Ensure the configuration is loaded before using any properties
        testingLink = BrowserLinkLoadProperties.getPropertyValue("URL");
        browser = BrowserLinkLoadProperties.getPropertyValue("browserType");
        executionType = BrowserLinkLoadProperties.getPropertyValue("executionType");

    }

}
