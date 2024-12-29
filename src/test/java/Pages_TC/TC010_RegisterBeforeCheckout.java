package Pages_TC;

import Data.DataClass;
import Pages.*;
import TestBase.Browser;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Add product and pay")
public class TC010_RegisterBeforeCheckout extends Browser {

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
    @Step("1. User create account (Register)\n"
            + "2. Login with this new account\n"
            + "3. Add product to cart and complete checkout process")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Test
    public void registerAndAddProductAndPay() {
        homePage.clickSignupAndLoginButton();
        signUp.userRegisterationSuccessfully(DataClass.ContactInformation.emailTwo);
        Assert.assertEquals(signUp.getAccountCreationValidationMessage()
                .toLowerCase(), ("ACCOUNT CREATED!")
                .toLowerCase(), "validationMessageAccountCreated");
        signUp.clickOnContinueButton();
        homePage.clickLogoutButton();
        login.logInToUserAccount(DataClass.ContactInformation.emailTwo);
        homePage.clickProductsButton();
        products.addProductToCartAndViewCart();
        cart.verifyCartPageIsDisplayed().clickProceedToCheckoutButton();
        checkout.retrieveAddressDetails().enterTextAtMessageTextarea().clickOnPlaceOrderButton();
        payment.enterCardData().clickOnSubmitButton();
        Assert.assertEquals(payment.getConfirmedOrderText()
                .toLowerCase(), "Congratulations! Your order has been confirmed!"
                .toLowerCase(), "Order done successfully message");
        homePage.clickDeleteAccountButton();
    }
}
