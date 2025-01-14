package Pages;

import Data.DataClass;
import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.Driver;
import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_ContactUs extends Driver {

    private static final By CONTACT_US_HEADER = By.xpath("//h2[text() = 'Get In Touch']");
    private static final By NAME_FIELD = By.xpath("//input[@data-qa='name']");
    private static final By EMAIL_FIELD = By.xpath("//input[@data-qa='email']");
    private static final By SUBJECT_FIELD = By.xpath("//input[@data-qa='subject']");
    private static final By MESSAGE_FIELD = By.xpath("//textarea[@data-qa='message']");
    private static final By UPLOAD_FILE_FIELD = By.xpath("//input[@name='upload_file']");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@name='submit']");
    private static final By SUCCESS_MESSAGE = By.cssSelector("div.status.alert.alert-success");
    private static final By HOME_BUTTON = By.xpath("//span[text() = ' Home']");

    private static final LogManager LOGGER = LogManager.getInstance();

    public P03_ContactUs(WebDriver driver) {
        super(driver);
    }

    public P03_ContactUs enterName(String name) {
        try {
            ElementsActions.sendText(NAME_FIELD, name);
            String successMessage = "Name entered successfully: " + name;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter name: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_ContactUs enterEmail(String email) {
        try {
            ElementsActions.sendText(EMAIL_FIELD, email);
            String successMessage = "Email entered successfully: " + email;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter email: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_ContactUs enterSubject(String subject) {
        try {
            ElementsActions.sendText(SUBJECT_FIELD, subject);
            String successMessage = "Subject entered successfully: " + subject;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter subject: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_ContactUs enterMessage(String message) {
        try {
            ElementsActions.sendText(MESSAGE_FIELD, message);
            String successMessage = "Message entered successfully: " + message;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter message: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_ContactUs uploadFile(String filePath) {
        try {
            ElementsActions.scrollToElement(UPLOAD_FILE_FIELD);
            ElementsActions.sendText(UPLOAD_FILE_FIELD, filePath);
            String successMessage = "File uploaded successfully: " + filePath;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to upload file: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_ContactUs clickSubmitButton() {
        try {
            ElementsActions.scrollToElement(SUBMIT_BUTTON);
            ElementsActions.clickElementByLocator(SUBMIT_BUTTON);
            driver.switchTo().alert().accept();
            String successMessage = "Submit button clicked successfully.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click submit button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_ContactUs clickHomeButton() {
        try {
            ElementsActions.clickElementByLocator(HOME_BUTTON);
            String successMessage = "Home button clicked successfully.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click home button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public String getContactUsPageHeader() {
        try {
            String headerText = ElementsActions.getText(CONTACT_US_HEADER);
            String successMessage = "Contact Us page header retrieved: " + headerText;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return headerText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve Contact Us page header: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public String getSuccessMessageAfterSubmission() {
        try {
            String successMessageText = ElementsActions.getText(SUCCESS_MESSAGE);
            String successMessage = "Success message retrieved: " + successMessageText;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return successMessageText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve success message: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public P03_ContactUs submitContactForm(String filePath) {
        try {
            enterName(DataClass.PersonalInformation.userName);
            enterEmail(DataClass.ContactInformation.emailOne);
            enterSubject(DataClass.MessageInformation.subject);
            enterMessage(DataClass.MessageInformation.userMessage);
            uploadFile(filePath);
            clickSubmitButton();
            String successMessage = "User successfully submitted contact form.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to submit contact form: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }
}

