package Pages;

import Data.DataClass;
import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.DriverFactory;
import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Payment extends DriverFactory {

    private static final By NAME_ON_CARD_FIELD = By.xpath("//input[@name = 'name_on_card']");
    private static final By CARD_NUMBER_FIELD = By.xpath("//input[@name = 'card_number']");
    private static final By CVC_FIELD = By.xpath("//input[@name = 'cvc']");
    private static final By EXPIRY_MONTH_FIELD = By.xpath("//input[@name = 'expiry_month']");
    private static final By EXPIRY_YEAR_FIELD = By.xpath("//input[@name = 'expiry_year']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@id = 'submit']");
    private static final By PAYMENT_DONE_TEXT = By.xpath("//p[contains(text(), 'Congratulations')]");
    private static final By DOWNLOAD_INVOICE_BUTTON = By.xpath("//a[text() = 'Download Invoice']");

    private static final LogManager LOGGER = LogManager.getInstance();

    public Payment(WebDriver driver) {
        super(driver);
    }

    public Payment enterCardData() {
        ElementsActions.sendText(NAME_ON_CARD_FIELD, DataClass.CardInformation.CardName);
        ElementsActions.sendText(CARD_NUMBER_FIELD, DataClass.CardInformation.CardNumber);
        ElementsActions.sendText(CVC_FIELD, DataClass.CardInformation.CVC);
        ElementsActions.sendText(EXPIRY_MONTH_FIELD, DataClass.CardInformation.Expiry_Month);
        ElementsActions.sendText(EXPIRY_YEAR_FIELD, DataClass.CardInformation.Expiry_Year);
        return this;
    }

    public Payment clickOnSubmitButton() {
        try {
            ElementsActions.clickElementByLocator(SUBMIT_BUTTON);
            String successMessage = "Successfully clicked the 'Submit' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click the 'Submit' button. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public Payment clickOnDownloadInvoiceButton() {
        try {
            ElementsActions.clickElementByLocator(DOWNLOAD_INVOICE_BUTTON);
            String successMessage = "Successfully clicked the 'Download Invoice' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click the 'Download Invoice' button. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public String getConfirmedOrderText() {
        try {
            String confirmedText = ElementsActions.getText(PAYMENT_DONE_TEXT);
            String successMessage = String.format("Successfully retrieved the confirmed order text: %s", confirmedText);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return confirmedText;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to retrieve the confirmed order text. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

}
