package Pages;

import Data.DataClass;
import Utilities.Action;
import Utilities.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class P02_Login extends Driver {

    private static final By LOGIN_TEXT = By.xpath("//div[@class = 'login-form']//h2");
    private static final By EMAIL_ADDRESS_FIELD = By.xpath("//input[@data-qa = 'login-email']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@data-qa = 'login-password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@data-qa = 'login-button']");
    private static final By ERROR_MESSAGE_INCORRECT_CREDENTIALS = By.xpath("//p[text() = 'Your email or password is incorrect!']");

    private static final Logger LOGGER = Logger.getLogger(P02_Login.class.getName());

    public P02_Login(WebDriver driver) {
        super(driver);
    }

    public P02_Login enterYourEmail(String email) {
        try {
            if (email == null || email.trim().isEmpty()) {

                String errorMessage = "Email address cannot be null or empty.";
                LOGGER.log(Level.WARNING, errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            Action.sendText(EMAIL_ADDRESS_FIELD, email);

            String successMessage = String.format("Successfully entered email address: %s", email);
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter email address: %s", e.getMessage());
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public P02_Login enterYourPassword(String password) {
        try {
            if (password == null || password.trim().isEmpty()) {
                String errorMessage = "Password cannot be null or empty.";
                LOGGER.log(Level.WARNING, errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            Action.sendText(PASSWORD_FIELD, password);
            String successMessage = "Successfully entered password.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter password: %s", e.getMessage());
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public P02_Login clickLoginButton() {
        try {
            Action.clickElementByLocator(LOGIN_BUTTON);
            String successMessage = "Successfully clicked on the login button.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click on the login button: %s", e.getMessage());
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public String getLoginText() {
        try {
            String loginText = Action.getText(LOGIN_TEXT);
            String successMessage = String.format("Successfully retrieved login text: %s", loginText);
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
            return loginText;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to retrieve login text: %s", e.getMessage());
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public String getErrorMessageWithIncorrectEmail() {
        try {
            String errorText = Action.getText(ERROR_MESSAGE_INCORRECT_CREDENTIALS);
            String successMessage = String.format("Successfully retrieved error message for incorrect email: %s", errorText);
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
            return errorText;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to retrieve error message for incorrect email: %s", e.getMessage());
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public void logInToUserAccount(String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                String errorMessage = "Email address cannot be null or empty.";
                LOGGER.log(Level.WARNING, errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            enterYourEmail(email);
            String password = DataClass.PersonalInformation.password;
            if (password == null || password.trim().isEmpty()) {
                String errorMessage = "Password cannot be null or empty.";
                LOGGER.log(Level.WARNING, errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            enterYourPassword(password);
            clickLoginButton();

            String successMessage = String.format("User successfully logged in with email: {0}", email);
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);

        } catch (Exception e) {
            String errorMessage = String.format("Failed to log in with email: %s. Error: %s", email, e.getMessage());
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

}
