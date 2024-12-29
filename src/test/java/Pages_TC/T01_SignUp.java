package Pages_TC;

import Data.DataClass;
import Pages.P05_HomePage;
import Pages.P01_SignUp;
import TestBase.Browser;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Feature("Register Page")
public class T01_SignUp extends Browser {

    private P05_HomePage homePage;
    private P01_SignUp signUp;


    @BeforeMethod
    public void setObject() {
        homePage = new P05_HomePage(driver);
        signUp = new P01_SignUp(driver);
    }

    @Description("Register With New User")
    @Step("Verifies that a new user can successfully register by navigating to the Signup page," +
            " entering valid details, and ensuring the 'ACCOUNT CREATED!' message is displayed.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/signup")
    @Test
    public void testRegisterNewUser() {
        homePage.clickSignupAndLoginButton();
        signUp.userRegisterationSuccessfully(DataClass.ContactInformation.emailOne);
        Assert.assertEquals(signUp.getAccountCreationValidationMessage(), ("ACCOUNT CREATED!"), "validationMessageAccountCreated");
        signUp.clickOnContinueButton();
    }

    @Description("Register With Existing Email")
    @Step("Ensures that attempting to register with an existing email address shows " +
            "the appropriate validation message: 'Email Address already exist!'.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/signup")
    @Test(dependsOnMethods = "testRegisterNewUser")
    public void testRegisterWithExistingEmail() {
        homePage.clickLogoutButton();
        signUp.userRegisterationWithTheSameEmail();
        Assert.assertEquals(signUp.validationMessageForExistingEmail(), ("Email Address already exist!"), "validationMessageForExistingEmail");
    }

}
