package TestClass.Pages_TC;

import Data.DataClass;
import Pages.P02_Login;
import Pages.P05_HomePage;
import TestBase.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Login Page")
public class T02_Login extends TestBase {
    private P05_HomePage homePage;
    private P02_Login login;

    @BeforeMethod
    public void setObject() {
        homePage = new P05_HomePage(driver);
        login = new P02_Login(driver);
    }

    @Description("Login With Valid Credentials")
    @Step("Verify user can successfully log in with valid credentials")
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

    @Description("Login With Invalid Credentials")
    @Step("Verify system shows an error message when logging in with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/login")
    @Test(dependsOnMethods = "testLoginWithValidCredentials")
    public void testLoginWithInvalidCredentials() {
        login.logInToUserAccount(DataClass.ContactInformation.inValidEmail);
        Assert.assertEquals(login.getErrorMessageWithIncorrectEmail(), "Your email or password is incorrect!");
    }
}
