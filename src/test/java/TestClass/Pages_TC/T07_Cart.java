package TestClass.Pages_TC;

import Pages.*;
import TestBase.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Cart Page")
public class T07_Cart extends TestBase {

    private P05_HomePage homePage;
    private P04_Products products;
    private P07_Cart cart;
    private P06_ProductDetails productDetails;
    private P01_SignUp signUp;
    private Checkout checkout;
    private P02_Login login;
    private Payment payment;


    @BeforeMethod
    public void setObjects() {
        homePage = new P05_HomePage(driver);
        products = new P04_Products(driver);
        productDetails = new P06_ProductDetails(driver);
        cart = new P07_Cart(driver);
        signUp = new P01_SignUp(driver);
        checkout = new Checkout(driver);
        login = new P02_Login(driver);
        payment = new Payment(driver);

    }

    @Description("Add Single Product In Cart")
    @Step("User navigates to the products page, adds two products to the cart, and verifies cart functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://automationexercise.com/view_cart")
    @Owner("Mohamed Nasser")
    @Test
    public void testAddMultipleProductsToCart() throws InterruptedException {
        homePage.clickProductsButton();
        products.addProductToCartAndContinueShopping().addProductToCartAndViewCart();
        cart.verifyProductsInCart().quantityTextButton().clickDeleteProductButton();
//        Assert.assertEquals(cart.verifyCartIsEmpty().toString(), "Cart is empty!".toLowerCase(), "Cart is empty text");

        // Allure Step to validate the cart is empty
        Allure.step("Verify if the cart is empty", () -> {
            String cartStatus = cart.verifyCartIsEmpty().toString();
            if (!cartStatus.toLowerCase().equals("cart is empty!")) {
                Allure.attachment("Expected Cart Status", "Cart is empty!");
                Allure.attachment("Actual Cart Status", cartStatus);
                throw new RuntimeException("Cart is not empty as expected.");
            }
        });
    }

    @Description("Verify Product Quantity In Cart")
    @Step("User navigates to the products details page, add more than one to the cart, and validate the quantity at the cart is right")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://automationexercise.com/view_cart")
    @Owner("Mohamed Nasser")
    @Test
    public void verifyProductQuantityInCart() {
        products.openAndViewRandomProduct();
        productDetails.checkVisibilityOfProductInformation().enterProductQuantity().clickAddToCart();
        products.clickViewCart();
//        Assert.assertEquals(cart.getProductQuantity().toString(), "4", "Product Quantity");

        // Allure Step to validate the product quantity in the cart
        Allure.step("Verify Product Quantity in Cart", () -> {
            String quantity = String.valueOf(cart.getProductQuantity());
            if (!quantity.equals("4")) {
                Allure.attachment("Expected Quantity", "4");
                Allure.attachment("Actual Quantity", quantity);
                throw new RuntimeException("Product quantity is incorrect.");
            }
        });
    }
}
