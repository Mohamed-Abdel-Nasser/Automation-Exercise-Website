package Pages;

import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.Driver;
import Utilities.LOGGER.LogManager;
import Utilities.ScreenShotsManager.ScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class P07_Cart extends Driver {

    private static final By CART_PRODUCTS_LIST = By.xpath("//tbody/tr");
    private static final By PRODUCT_QUANTITY_BUTTON = By.xpath("//td[@class = 'cart_quantity']/button");
    private static final By PRODUCT_QUANTITY_FIELD = By.xpath("//tbody/tr[1]/td[@class = 'cart_quantity']/button");
    private static final By CART_INFO_CONTAINER = By.xpath("//div[@id = 'cart_info']");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[text() = 'Proceed To Checkout']");
    private static final By REGISTER_AND_LOGIN_LINK = By.xpath("//u[text() = 'Register / Login']");
    private static final By DELETE_PRODUCT_BUTTON = By.xpath("//a[@class = 'cart_quantity_delete']");
    private static final By CART_EMPTY_MESSAGE = By.xpath("//b[text() = 'Cart is empty!']");

    private static final LogManager LOGGER = LogManager.getInstance();

    public P07_Cart(WebDriver driver) {
        super(driver);
    }

    public P07_Cart verifyProductsInCart() {
        List<WebElement> elements = driver.findElements(CART_PRODUCTS_LIST);

        if (elements.isEmpty()) {
            String errorMessage = "No products found in the cart.";
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            Assert.fail(errorMessage);
        }

        String successMessage = "Products added to the cart successfully.";
        LOGGER.info(successMessage);
        Allure.step(successMessage);
        ScreenShot.takeScreenShot("Cart");

        return this;
    }

    public P07_Cart quantityTextButton() {
        List<WebElement> quantityText = driver.findElements(PRODUCT_QUANTITY_BUTTON);

        if (quantityText.isEmpty()) {
            String errorMessage = "No quantity buttons found in the cart.";
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            Assert.fail(errorMessage);
        }

        for (WebElement quantity : quantityText) {
            String quantityTextValue = quantity.getText();
            if (quantityTextValue.isEmpty()) {
                String errorMessage = "Cart is empty. No products to display.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                Assert.fail(errorMessage);
            }
        }

        String successMessage = "Product quantities are properly displayed.";
        LOGGER.info(successMessage);
        Allure.step(successMessage);

        return this;
    }

    public P07_Cart getProductQuantity() {
        try {
            String productQuantity = ElementsActions.getText(PRODUCT_QUANTITY_FIELD);
            String successMessage = "Retrieved product quantity: " + productQuantity;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve product quantity: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }

    public P07_Cart verifyCartPageIsDisplayed() {
        try {
            ElementsActions.isElementDisplayed(CART_INFO_CONTAINER);
            String successMessage = "Cart page is displayed successfully.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Cart page is not displayed: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }

    public P07_Cart clickProceedToCheckoutButton() {
        try {
            ElementsActions.clickElementByLocator(PROCEED_TO_CHECKOUT_BUTTON);
            String successMessage = "Proceed to checkout button clicked successfully.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click on proceed to checkout button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }

    public P07_Cart clickRegisterAndLoginButton() {
        try {
            ElementsActions.clickElementByLocator(REGISTER_AND_LOGIN_LINK);
            String successMessage = "Register/Login button clicked successfully.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click on Register/Login button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }

        return this;
    }

    public P07_Cart clickDeleteProductButton() {
        List<WebElement> deleteButtons = driver.findElements(DELETE_PRODUCT_BUTTON);

        if (deleteButtons.isEmpty()) {
            String errorMessage = "No delete buttons found in the cart.";
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            Assert.fail(errorMessage);
        }

        for (WebElement button : deleteButtons) {
            try {
                ElementsActions.clickElementDirectly(button);
            } catch (Exception e) {
                String errorMessage = "Failed to delete product from the cart: " + e.getMessage();
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new RuntimeException(errorMessage, e);
            }
        }

        String successMessage = "All products deleted from the cart successfully.";
        LOGGER.info(successMessage);
        Allure.step(successMessage);

        return this;
    }

    public P07_Cart verifyCartIsEmpty() {
        try {
            String cartEmptyText = ElementsActions.getText(CART_EMPTY_MESSAGE);
            if (cartEmptyText.isEmpty()) {
                String errorMessage = "Cart empty message is not displayed.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                Assert.fail(errorMessage);
            }
            String successMessage = String.format("Cart empty message displayed: %s", cartEmptyText);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve cart empty message: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }
}
