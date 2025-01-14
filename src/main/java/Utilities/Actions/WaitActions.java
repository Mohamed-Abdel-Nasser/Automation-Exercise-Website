package Utilities.Actions;


import Utilities.BrowserSetUp.Driver;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;

public class WaitActions extends Driver {
    public WaitActions(WebDriver driver) {
        super(driver);
    }

    public static FluentWait fluent()
    {
        return new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);
    }
}
