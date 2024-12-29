package Pages;

import Data.DataClass;
import Utilities.Action;
import Utilities.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Checkout extends Driver {

    private static final By ADDRESS_DETAILS_LIST = By.xpath("//ul[@class = 'address item box']/li");
    private static final By MESSAGE_TEXT_AREA = By.xpath("//textarea[@name = 'message']");
    private static final By PLACE_ORDER_BUTTON = By.xpath("//a[text() = 'Place Order']");
    private static final Logger LOGGER = Logger.getLogger(Checkout.class.getName());

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public Checkout retrieveAddressDetails() {
        List<WebElement> addressDetails = driver.findElements(ADDRESS_DETAILS_LIST);

        if (addressDetails.isEmpty()) {
            String errorMessage = "No address details found.";
            LOGGER.log(Level.WARNING, errorMessage);
            Allure.step(errorMessage);
            Assert.fail(errorMessage);
        }

        String successMessage = "Address details retrieved successfully.";
        LOGGER.log(Level.INFO, successMessage);
        Allure.step(successMessage);

        for (WebElement detail : addressDetails) {
            Allure.step("Address Detail: " + detail.getText());
        }

        return this;
    }

    public Checkout enterTextAtMessageTextarea() {
        try {
            Action.sendText(MESSAGE_TEXT_AREA, DataClass.MessageInformation.userMessage);
            String successMessage = "Message entered successfully: " + DataClass.MessageInformation.userMessage;
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter message in the text area: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }

    public Checkout clickOnPlaceOrderButton() {
        try {
            Action.clickElementByLocator(PLACE_ORDER_BUTTON);
            String successMessage = "Place order button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click on place order button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }
}
