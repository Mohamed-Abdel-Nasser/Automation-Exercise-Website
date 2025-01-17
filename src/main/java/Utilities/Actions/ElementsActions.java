package Utilities.Actions;

import Utilities.BrowserSetUp.DriverFactory;
import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static Utilities.BrowserSetUp.DriverFactory.driver;

public class ElementsActions extends DriverFactory {
    private static final LogManager LOGGER = LogManager.getInstance();

    public ElementsActions(WebDriver driver) {
        super(driver);
    }

    public static void clickElementByLocator(By locator) {
        try {
            WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    element.click();
                    String successMessage = String.format("Successfully clicked on element: %s", locator);
                    LOGGER.info(successMessage);
                    Allure.step(successMessage);
                    return true;
                } else {
                    String warningMessage = String.format("Element not visible: %s", locator);
                    LOGGER.warn(warningMessage);
                    Allure.step(warningMessage);
                    return false;
                }
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while clicking on element: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static void clickElementDirectly(WebElement element) {
        try {
            WaitActions.fluent().until(d -> {
                if (element.isDisplayed()) {
                    element.click();
                    String successMessage = String.format("Successfully clicked on the element: %s", element);
                    LOGGER.info(successMessage);
                    Allure.step(successMessage);
                    return true;
                } else {
                    String warningMessage = String.format("Element not visible: %s", element);
                    LOGGER.warn(warningMessage);
                    Allure.step(warningMessage);
                    return false;
                }
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while clicking on element: %s", element);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static void clickElementByJavaScriptClicker(By locator) {
        try {
            WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                if (driver instanceof JavascriptExecutor) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    String successMessage = String.format("JavaScript click executed on element: %s", locator);
                    LOGGER.info(successMessage);
                    Allure.step(successMessage);
                    return true;
                } else {
                    String errorMessage = "Driver is not an instance of JavascriptExecutor.";
                    LOGGER.error(errorMessage);
                    Allure.step(errorMessage);
                    throw new RuntimeException(errorMessage);
                }
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while executing JavaScript click on element: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static void sendText(By locator, String value) {
        try {
            WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                element.clear();
                element.sendKeys(value);
                String successMessage = String.format("Text sent to element: %s with value: %s", locator, value);
                LOGGER.info(successMessage);
                Allure.step(successMessage);
                return true;
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while sending text to element: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            return (boolean) WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                boolean isDisplayed = element.isDisplayed();
                String message = isDisplayed ? String.format("Element is displayed: %s", locator) : String.format("Element not displayed: %s", locator);
                LOGGER.info(message);
                Allure.step(message);
                return isDisplayed;
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while checking if element is displayed: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static void selectFromDropdown(By locator, String value) {
        try {
            WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                Select select = new Select(element);
                select.selectByValue(value);
                String successMessage = String.format("Selected value: %s from dropdown: %s", value, locator);
                LOGGER.info(successMessage);
                Allure.step(successMessage);
                return true;
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while selecting value from dropdown: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static void scrollToElement(By locator) {
        try {
            WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                String successMessage = String.format("Scrolled to element: %s", locator);
                LOGGER.info(successMessage);
                Allure.step(successMessage);
                return true;
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while scrolling to element: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static void moveToElement_Hover(By locator) {
        try {
            WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                Actions actions = new Actions(driver);
                actions.moveToElement(element).build().perform();
                String successMessage = String.format("Hovered over element: %s", locator);
                LOGGER.info(successMessage);
                Allure.step(successMessage);
                return true;
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while hovering over element: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static String getText(By locator) {
        try {
            return (String) WaitActions.fluent().until(d -> {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    String text = element.getText();
                    String successMessage = String.format("Retrieved text from element: %s Text: %s", locator, text);
                    LOGGER.info(successMessage);
                    Allure.step(successMessage);
                    return text;
                } else {
                    String warningMessage = String.format("Element not displayed: %s", locator);
                    LOGGER.warn(warningMessage);
                    Allure.step(warningMessage);
                    return null;
                }
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error occurred while retrieving text from element: %s", locator);
            LOGGER.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
