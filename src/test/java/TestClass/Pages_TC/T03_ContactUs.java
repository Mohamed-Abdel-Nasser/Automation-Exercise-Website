package TestClass.Pages_TC;

import Pages.P03_ContactUs;
import Pages.P05_HomePage;
import TestBase.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Paths;

@Feature("Contact Us Page")
public class T03_ContactUs extends TestBase {

    private P05_HomePage homePage;
    private P03_ContactUs contactUs;
    private SoftAssert softAssert;
    private String uploadPhoto = Paths.get("ScreenShots/test.png").toAbsolutePath().toString();

    @BeforeMethod
    public void setObject() {
        homePage = new P05_HomePage(driver);
        contactUs = new P03_ContactUs(driver);
        softAssert = new SoftAssert();
    }

    @Description("Navigate to the contact us page and submit a request")
    @Step("Verify user can navigate to the contact us page and successfully submit a request")
    @Severity(SeverityLevel.MINOR)
    @Owner("Mohamed Nasser")
    @Link("https://www.automationexercise.com/contact_us")
    @Test
    public void testNavigateToContactUsPageAndSubmitRequest() {
        homePage.clickContactUsButton();
        softAssert.assertEquals(contactUs.getContactUsPageHeader(), "GET IN TOUCH", "get in touch message");
        contactUs.submitContactForm(uploadPhoto);
        softAssert.assertEquals(contactUs.getSuccessMessageAfterSubmission(), "Success! Your details have been submitted successfully.", "successSubmittedMessage");
        contactUs.clickHomeButton();
        softAssert.assertAll();
    }

}
