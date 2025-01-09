package TestClass.Pages_TC;

import Data.DataClass;
import Pages.*;
import TestBase.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Add product and pay")
public class TC009_RegisterWhileCheckout extends TestBase {

    private P05_HomePage homePage;
    private P04_Products products;
    private P07_Cart cart;
    private P01_SignUp signUp;
    private P02_Login login;
    private Checkout checkout;
    private Payment payment;

    @BeforeMethod
    public void setObject() {
        homePage = new P05_HomePage(driver);
        products = new P04_Products(driver);
        cart = new P07_Cart(driver);
        signUp = new P01_SignUp(driver);
        login = new P02_Login(driver);
        checkout = new Checkout(driver);
        payment = new Payment(driver);
    }

    @Description("Add product to cart and register")
    @Step("1. User add product to cart and checkout\n" +
            "2. Create new account\n" +
            "3. Complete The checkout and payment cycle ")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Test
    public void addProductToCartAndRegister() {
        homePage.clickProductsButton();
        products.addProductToCartAndViewCart();
        cart.verifyCartPageIsDisplayed().clickProceedToCheckoutButton().clickRegisterAndLoginButton();
        signUp.userRegisterationSuccessfully(DataClass.ContactInformation.emailTwo);
        Assert.assertEquals(signUp.getAccountCreationValidationMessage()
                .toLowerCase(), ("ACCOUNT CREATED!")
                .toLowerCase(), "validationMessageAccountCreated");
        signUp.clickOnContinueButton();
        homePage.clickLogoutButton();
        login.logInToUserAccount(DataClass.ContactInformation.emailTwo);
        homePage.clickCartButton();
        cart.clickProceedToCheckoutButton();
        checkout.retrieveAddressDetails().enterTextAtMessageTextarea().clickOnPlaceOrderButton();
        payment.enterCardData().clickOnSubmitButton();
        Assert.assertEquals(payment.getConfirmedOrderText()
                .toLowerCase(), "Congratulations! Your order has been confirmed!"
                .toLowerCase(), "Order done successfully message");
        payment.clickOnDownloadInvoiceButton();
        signUp.clickOnContinueButton();
        homePage.clickDeleteAccountButton();
    }
}
