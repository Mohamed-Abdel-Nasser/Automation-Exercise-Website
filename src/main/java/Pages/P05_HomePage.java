package Pages;

import Data.DataClass;
import Utilities.Action;
import Utilities.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class P05_HomePage extends Driver {

    private static final By SIGNUP_LOGIN_BUTTON = By.xpath("//a[text() = ' Signup / Login']");
    private static final By LOGOUT_BUTTON = By.xpath("//a[text() = ' Logout']");
    private static final By CONTACT_US_BUTTON = By.xpath("//a[text() = ' Contact us']");
    private static final By PRODUCTS_BUTTON = By.xpath("//a[text() = ' Products']");
    private static final By SUBSCRIPTION_LABEL = By.xpath("//h2[text() = 'Subscription']");
    private static final By SUBSCRIPTION_FIELD = By.xpath("//input[@id = 'susbscribe_email']");
    private static final By SUBSCRIBE_BUTTON = By.xpath("//button[@id = 'subscribe']");
    private static final By SUCCESS_SUBSCRIPTION_MESSAGE = By.xpath("//div[@class = 'alert-success alert']");
    private static final By CART_BUTTON = By.xpath("//a[text() = ' Cart']");
    private static final By DELETE_ACCOUNT_BUTTON = By.xpath("//a[text() = ' Delete Account']");
    private static final By CATEGORY_TEXT = By.xpath("//h2[text() = 'Category']");
    private static final By WOMEN_CATEGORY = By.xpath("//div[@id = 'accordian']/div[1]/div[1]/h4/a");
    private static final By WOMEN_CATEGORY_DRESS = By.xpath("//div[@id = 'Women']//a[text() = 'Dress ']");
    private static final By CATEGORY_PAGE_TEXT = By.xpath("//div[@class = 'features_items']/h2");
    private static final By SCROLL_UP_BUTTON = By.xpath("//a[@id = 'scrollUp']");

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(P07_Cart.class.getName());
    public P05_HomePage(WebDriver driver) {
        super(driver);
    }

    public P05_HomePage clickSignupAndLoginButton() {
        try {
            Action.clickElementByLocator(SIGNUP_LOGIN_BUTTON);
            String successMessage = "Signup and Login button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Signup and Login button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickLogoutButton() {
        try {
            Action.clickElementByLocator(LOGOUT_BUTTON);
            String successMessage = "Logout button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Logout button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickContactUsButton() {
        try {
            Action.clickElementByLocator(CONTACT_US_BUTTON);
            String successMessage = "Contact Us button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Contact Us button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickProductsButton() {
        try {
            Action.clickElementByLocator(PRODUCTS_BUTTON);
            String successMessage = "Products button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Products button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public String getSubscriptionLabelText() {
        try {
            Action.scrollToElement(SUBSCRIPTION_LABEL);
            String labelText = Action.getText(SUBSCRIPTION_LABEL);
            String successMessage = "Subscription label retrieved: " + labelText;
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
            return labelText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve Subscription label: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public P05_HomePage enterEmailForSubscription() {
        try {
            Action.sendText(SUBSCRIPTION_FIELD, DataClass.ContactInformation.emailOne);
            String successMessage = "Email entered for subscription successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to enter email for subscription: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickSubscribeButton() {
        try {
            Action.clickElementByLocator(SUBSCRIBE_BUTTON);
            String successMessage = "Subscribe button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Subscribe button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickCartButton() {
        try {
            Action.clickElementByLocator(CART_BUTTON);
            String successMessage = "Cart button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Cart button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickDeleteAccountButton() {
        try {
            Action.clickElementByLocator(DELETE_ACCOUNT_BUTTON);
            String successMessage = "Delete Account button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Delete Account button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public String getSuccessSubscriptionMessage() {
        try {
            String message = Action.getText(SUCCESS_SUBSCRIPTION_MESSAGE);
            String successMessage = "Success subscription message retrieved: " + message;
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
            return message;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve success subscription message: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public String getCategoryText() {
        try {
            Action.scrollToElement(CATEGORY_TEXT);
            String categoryText = Action.getText(CATEGORY_TEXT);
            String successMessage = "Category text retrieved: " + categoryText;
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
            return categoryText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve category text: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public P05_HomePage clickWomenCategoryButton() {
        try {
            Action.clickElementByLocator(WOMEN_CATEGORY);
            String successMessage = "Women category button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Women category button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P05_HomePage clickWomenCategoryDressButton() {
        try {
            Action.clickElementByLocator(WOMEN_CATEGORY_DRESS);
            String successMessage = "Women category Dress button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Women category Dress button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public String getCategoryPageText() {
        try {
            String categoryPageText = Action.getText(CATEGORY_PAGE_TEXT);
            String successMessage = "Category page text retrieved: " + categoryPageText;
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
            return categoryPageText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve category page text: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public P05_HomePage clickScrollUpButton() {
        try {
            Action.clickElementByLocator(SCROLL_UP_BUTTON);
            String successMessage = "Scroll Up button clicked successfully.";
            LOGGER.log(Level.INFO, successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click Scroll Up button: " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }
}


