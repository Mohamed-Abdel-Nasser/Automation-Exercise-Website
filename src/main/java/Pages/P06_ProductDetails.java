package Pages;

import Data.DataClass;
import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.DriverFactory;
import Utilities.LOGGER.LogManager;
import Utilities.ScreenShotsManager.ScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ProductDetails extends DriverFactory {

    private static final By PRODUCT_INFORMATION_DIV = By.xpath("//div[@class = 'product-information']");
    private static final By PRODUCT_QUANTITY_INPUT = By.xpath("//input[@id = 'quantity']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class = 'product-information']/span/button");

    private static final LogManager LOGGER = LogManager.getInstance();

    public P06_ProductDetails(WebDriver driver) {
        super(driver);
    }

    public P06_ProductDetails checkVisibilityOfProductInformation() {
        try {
            boolean isVisible = ElementsActions.isElementDisplayed(PRODUCT_INFORMATION_DIV);
            if (!isVisible) {
                String errorMessage = "Product information section is not visible.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalStateException(errorMessage);
            }
            String successMessage = "Successfully verified the visibility of the product information section.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to verify product information visibility. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public P06_ProductDetails captureProductDetailsScreenshot() {
        try {
            ScreenShot.takeScreenShot("ProductInformation");
            String successMessage = "Successfully captured screenshot for product details page.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to capture screenshot. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public P06_ProductDetails enterProductQuantity() {
        try {
            String quantity = DataClass.ProductInformation.productQuantity;

            if (quantity == null || quantity.trim().isEmpty()) {
                String errorMessage = "Product quantity cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(PRODUCT_QUANTITY_INPUT, quantity);
            String successMessage = "Successfully entered product quantity: {0}" + quantity;
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter product quantity. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public P06_ProductDetails clickAddToCart() {
        try {
            ElementsActions.clickElementByLocator(ADD_TO_CART_BUTTON);
            String successMessage = "Successfully clicked on the 'Add to Cart' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click on the 'Add to Cart' button. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    public P06_ProductDetails completeProductSelectionProcess() {
        checkVisibilityOfProductInformation().captureProductDetailsScreenshot().enterProductQuantity().clickAddToCart();
        return this;
    }

    public void validateProductDetails() {
        checkVisibilityOfProductInformation();
        captureProductDetailsScreenshot();
        enterProductQuantity();
        clickAddToCart();
    }
}
