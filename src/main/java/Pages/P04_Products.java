package Pages;

import Data.DataClass;
import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.DriverFactory;
import Utilities.LOGGER.LogManager;
import Utilities.ScreenShotsManager.ScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class P04_Products extends DriverFactory {

    private static final By PRODUCTS_PAGE_TEXT = By.xpath("//h2[text() = 'All Products']");
    private static final By ALL_PRODUCTS = By.xpath("//div[@class = 'features_items']/div[@class = 'col-sm-4']");
    private static final By VIEW_PRODUCT_BUTTON = By.xpath("//a[text() = 'View Product']");
    private static final By SEARCH_FIELD = By.xpath("//input[@id = 'search_product']");
    private static final By SUBMIT_SEARCH_BUTTON = By.xpath("//button[@id = 'submit_search']");
    private static final By SEARCHED_PRODUCT_TEXT = By.xpath("//h2[text() = 'Searched Products']");
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[text() = 'Continue Shopping']");
    private static final By VIEW_CART_LINK = By.xpath("//u[text() = 'View Cart']");

    private static final LogManager LOGGER = LogManager.getInstance();

    public P04_Products(WebDriver driver) {
        super(driver);
    }


    //TODO: Retrieve text from the products page
    public String getTextFromProductsPage() {
        try {
            String productsPageText = ElementsActions.getText(PRODUCTS_PAGE_TEXT);
            String successMessage = String.format("Retrieved text from products page: %s", productsPageText);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return productsPageText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve text from the products page: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    //TODO: Verify if all products are visible on the page
    public P04_Products verifyAllProductsVisible() {
        try {
            List<WebElement> products = driver.findElements(ALL_PRODUCTS);
            if (products.isEmpty()) {
                String errorMessage = "Products list is not visible or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                Assert.fail(errorMessage);
            } else {
                String successMessage = String.format("Products list is visible with %d products.", products.size());
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Failed to verify products visibility: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Click a random "View Product" button from the list of products
    public P04_Products clickOnRandomViewProductButton() {
        try {
            List<WebElement> productButtons = driver.findElements(VIEW_PRODUCT_BUTTON);
            if (!productButtons.isEmpty()) {
                int randomIndex = new Random().nextInt(productButtons.size());
                ElementsActions.clickElementDirectly(productButtons.get(randomIndex));
                String successMessage = String.format("Clicked on 'View Product' button at index %d.", randomIndex);
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            } else {
                String errorMessage = "'View Product' button not found.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                Assert.fail(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Failed to click on random 'View Product' button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Enter product name in the search field
    public P04_Products searchForProduct() {
        try {
            String productName = DataClass.ProductInformation.productName;
            if (productName == null || productName.trim().isEmpty()) {
                String errorMessage = "Product name cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(SEARCH_FIELD, productName);
            String successMessage = String.format("Entered product name: %s", productName);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to search for product: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Submit the search form
    public P04_Products submitSearch() {
        try {
            ElementsActions.clickElementByLocator(SUBMIT_SEARCH_BUTTON);
            String successMessage = "Search submitted.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to submit the search form: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Get the text of the searched product section
    public String getSearchedProductText() {
        try {
            ElementsActions.scrollToElement(SEARCHED_PRODUCT_TEXT);
            ScreenShot.takeScreenShot("searchedProduct");
            String searchedText = ElementsActions.getText(SEARCHED_PRODUCT_TEXT);

            String successMessage = String.format("Searched product text: %s", searchedText);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return searchedText;
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve the searched product text: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    //TODO: Add a random product to the cart
    public P04_Products addRandomProductToCart() {
        try {
            List<WebElement> products = driver.findElements(ALL_PRODUCTS);
            if (products.isEmpty()) {
                String errorMessage = "No products found to add to cart.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                Assert.fail(errorMessage);
            } else {
                Random random = new Random();
                int randomIndex = random.nextInt(products.size());
                By productElement = By.xpath("//div[@class = 'features_items']/div[" + (randomIndex + 1) + "]/div[1]");
                By addToCartButton = By.xpath("//div[@class = 'features_items']/div[" + (randomIndex + 1) + "]/div[1]/div[1]/div[2]/div[1]/a");

                ElementsActions.scrollToElement(productElement);
                ElementsActions.moveToElement_Hover(productElement);
                ElementsActions.clickElementByJavaScriptClicker(addToCartButton);

                String successMessage = String.format("Successfully added product at index %d to the cart.", randomIndex);
                LOGGER.info(successMessage);
                Allure.step(successMessage);
            }
        } catch (Exception e) {
            String errorMessage = String.format("Failed to add a random product to the cart: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Click the 'Continue Shopping' button
    public P04_Products clickContinueShoppingButton() {
        try {
            ElementsActions.clickElementByLocator(CONTINUE_SHOPPING_BUTTON);
            String successMessage = "Successfully clicked on the 'Continue Shopping' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click on the 'Continue Shopping' button. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Click the 'View Cart' link
    public P04_Products clickViewCart() {
        try {
            ElementsActions.clickElementByLocator(VIEW_CART_LINK);
            String successMessage = "Successfully clicked on the 'View Cart' link.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click on the 'View Cart' link. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
        return this;
    }

    //TODO: Sequence to open the products page, check visibility, and click a random product
    public P04_Products openAndViewRandomProduct() {
        try {
            // Verify all products are visible on the page
            String visibilityCheckMessage = "Verifying that all products are visible.";
            LOGGER.info(visibilityCheckMessage);
            Allure.step(visibilityCheckMessage);
            verifyAllProductsVisible();

            // Click on a random product to view
            String randomProductMessage = "Clicking on a random product.";
            LOGGER.info(randomProductMessage);
            Allure.step(randomProductMessage);
            clickOnRandomViewProductButton();

            return this;
        } catch (Exception e) {
            // Log failure and rethrow exception
            String errorMessage = "Failed to open and view a random product: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    //TODO: Add a random product to the cart and continue shopping
    public P04_Products addProductToCartAndContinueShopping() {
        try {
            // Add a random product to the cart
            String addToCartMessage = "Adding a random product to the cart.";
            LOGGER.info(addToCartMessage);
            Allure.step(addToCartMessage);
            addRandomProductToCart();

            // Click continue shopping
            String continueShoppingMessage = "Clicking continue shopping button.";
            LOGGER.info(continueShoppingMessage);
            Allure.step(continueShoppingMessage);
            clickContinueShoppingButton();

            return this;
        } catch (Exception e) {
            // Log failure and rethrow exception
            String errorMessage = "Failed to add product to cart and continue shopping: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    //TODO: Add a random product to the cart and view the cart
    public P04_Products addProductToCartAndViewCart() {
        try {
            // Add a random product to the cart
            String addToCartMessage = "Adding a random product to the cart.";
            LOGGER.info(addToCartMessage);
            Allure.step(addToCartMessage);
            addRandomProductToCart();

            // Click view cart
            String viewCartMessage = "Clicking to view the cart.";
            LOGGER.info(viewCartMessage);
            Allure.step(viewCartMessage);
            clickViewCart();

            return this;
        } catch (Exception e) {
            // Log failure and rethrow exception
            String errorMessage = "Failed to add product to cart and view the cart: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

}
