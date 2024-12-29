package Utilities;


import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;

public class Wait extends Driver{
    public Wait(WebDriver driver) {
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
