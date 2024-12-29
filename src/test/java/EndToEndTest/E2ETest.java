package EndToEndTest;

import Data.DataClass;
import Pages.*;
import TestBase.Browser;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Paths;

public class E2ETest extends Browser {

    private P05_HomePage homePage;
    private P04_Products products;
    private P07_Cart cart;
    private P01_SignUp signUp;
    private P02_Login login;
    private Checkout checkout;
    private Payment payment;
    private P03_ContactUs contactUs;
    private SoftAssert softAssert;
    private String uploadPhoto = Paths.get("ScreenShots/test.png").toAbsolutePath().toString();
    private P06_ProductDetails productDetails;

    @BeforeMethod
    public void setObject() {
        contactUs = new P03_ContactUs(driver);
        softAssert = new SoftAssert();
        cart = new P07_Cart(driver);
        signUp = new P01_SignUp(driver);
        checkout = new Checkout(driver);
        payment = new Payment(driver);
        products = new P04_Products(driver);
        productDetails = new P06_ProductDetails(driver);
        login = new P02_Login(driver);
        homePage = new P05_HomePage(driver);
    }

    @Feature("Register Page")
    @Description("Verifies that a new user can successfully register...")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/signup")
    @Test
    public void testRegisterNewUser() {
        homePage.clickSignupAndLoginButton();
        signUp.userRegisterationSuccessfully(DataClass.ContactInformation.emailOne);
        Assert.assertEquals(signUp.getAccountCreationValidationMessage(), "ACCOUNT CREATED!");
        signUp.clickOnContinueButton();
    }

    @Description("Ensures that attempting to register with an existing email...")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/signup")
    @Test(dependsOnMethods = "testRegisterNewUser")
    public void testRegisterWithExistingEmail() {
        homePage.clickLogoutButton();
        signUp.userRegisterationWithTheSameEmail();
        Assert.assertEquals(signUp.validationMessageForExistingEmail(), "Email Address already exist!");
    }


    @Feature("Login Page")
    @Description("Verify user can successfully log in with valid credentials...")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/login")
    @Test
    public void testLoginWithValidCredentials() {
        homePage.clickSignupAndLoginButton();
        Assert.assertEquals(login.getLoginText(), "Login to your account");
        login.logInToUserAccount(DataClass.ContactInformation.emailOne);
        homePage.clickLogoutButton();
    }

    @Description("Verify system shows an error message when logging in with invalid credentials...")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/login")
    @Test(dependsOnMethods = "testLoginWithValidCredentials")
    public void testLoginWithInvalidCredentials() {
        login.logInToUserAccount(DataClass.ContactInformation.inValidEmail);
        Assert.assertEquals(login.getErrorMessageWithIncorrectEmail(), "Your email or password is incorrect!");
    }


    @Feature("Contact Us Page")
    @Description("Verify user can navigate to the contact us page and successfully submit a request...")
    @Severity(SeverityLevel.MINOR)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/contact_us")
    @Test
    public void testNavigateToContactUsPageAndSubmitRequest() {
        homePage.clickContactUsButton();
        softAssert.assertEquals(contactUs.getContactUsPageHeader(), "GET IN TOUCH");
        contactUs.submitContactForm(uploadPhoto);
        softAssert.assertEquals(contactUs.getSuccessMessageAfterSubmission(), "Success! Your details have been submitted successfully.");
        contactUs.clickHomeButton();
        softAssert.assertAll();
    }


    @Feature("Products Page")
    @Description("Verify user can navigate to the products page and view product details...")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.automationexercise.com/products")
    @Owner("Mohamed Nasser")
    @Test
    public void testNavigateToProductsPageAndViewProductDetails() {
        homePage.clickProductsButton();
        Assert.assertEquals(products.getTextFromProductsPage(), "ALL PRODUCTS");
        products.verifyAllProductsVisible();
        productDetails.checkVisibilityOfProductInformation();
    }


    @Feature("Add product and pay")
    @Description("1. User adds product to cart and checkout...")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Test
    public void addProductToCartAndRegister() {
        homePage.clickProductsButton();
        products.addProductToCartAndViewCart();
        cart.verifyCartPageIsDisplayed().clickProceedToCheckoutButton().clickRegisterAndLoginButton();
        signUp.userRegisterationSuccessfully(DataClass.ContactInformation.emailTwo);
        Assert.assertEquals(signUp.getAccountCreationValidationMessage(), "ACCOUNT CREATED!");
        signUp.clickOnContinueButton();
        homePage.clickLogoutButton();
        login.logInToUserAccount(DataClass.ContactInformation.emailTwo);
        homePage.clickCartButton();
        cart.clickProceedToCheckoutButton();
        checkout.retrieveAddressDetails().enterTextAtMessageTextarea().clickOnPlaceOrderButton();
        payment.enterCardData().clickOnSubmitButton();
        Assert.assertEquals(payment.getConfirmedOrderText(), "Congratulations! Your order has been confirmed!");
        payment.clickOnDownloadInvoiceButton();
        signUp.clickOnContinueButton();
        homePage.clickDeleteAccountButton();
    }

}




