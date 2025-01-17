package Pages;

import Data.DataClass;
import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.BrowserDriverFactory;
import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Checkout extends BrowserDriverFactory {

    private static final By ADDRESS_DETAILS_LIST = By.xpath("//ul[@class = 'address item box']/li");
    private static final By MESSAGE_TEXT_AREA = By.xpath("//textarea[@name = 'message']");
    private static final By PLACE_ORDER_BUTTON = By.xpath("//a[text() = 'Place Order']");
    private static final LogManager LOGGER = LogManager.getInstance();

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public Checkout retrieveAddressDetails() {
        List<WebElement> addressDetails = driver.findElements(ADDRESS_DETAILS_LIST);

        if (addressDetails.isEmpty()) {
            String errorMessage = "No address details found.";
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            Assert.fail(errorMessage);
        }

        String successMessage = "Address details retrieved successfully.";
        LOGGER.info(successMessage);
        Allure.step(successMessage);

        for (WebElement detail : addressDetails) {
            Allure.step("Address Detail: " + detail.getText());
        }

        return this;
    }

    public Checkout enterTextAtMessageTextarea() {
        try {
            ElementsActions.sendText(MESSAGE_TEXT_AREA, DataClass.MessageInformation.userMessage);
            String successMessage = "Message entered successfully: " + DataClass.MessageInformation.userMessage;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter message in the text area: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }

    public Checkout clickOnPlaceOrderButton() {
        try {
            ElementsActions.clickElementByLocator(PLACE_ORDER_BUTTON);
            String successMessage = "Place order button clicked successfully.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click on place order button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }
}
