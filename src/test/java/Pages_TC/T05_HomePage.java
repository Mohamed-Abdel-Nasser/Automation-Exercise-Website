package Pages_TC;

import Pages.P05_HomePage;
import TestBase.Browser;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Home Page")
public class T05_HomePage extends Browser {

    private P05_HomePage homePage;

    @Description("User Subscribes to the newsletter")
    @Step("User will subscribe to the newsletter from the footer section of the home page")
    @Severity(SeverityLevel.MINOR)
    @Link("https://automationexercise.com/")
    @Owner("Mohamed Nasser")
    @Test
    public void testSubscriptionFeature() {
        homePage = new P05_HomePage(driver);
        Assert.assertTrue(homePage.getSubscriptionLabelText().equalsIgnoreCase("Subscription"), "Subscription feature at the home page");
        homePage.enterEmailForSubscription().clickSubscribeButton();
        Assert.assertTrue(homePage.getSuccessSubscriptionMessage().equalsIgnoreCase("You have been successfully subscribed!"), "Successful subscription message");
        homePage.clickSubscribeButton();
        Assert.assertEquals(homePage.getCategoryText().toLowerCase(), "Category".toLowerCase(), "Category at home page");
    }

    @Description("View Category Products")
    @Step("User will choose one category and navigate to it")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://automationexercise.com/")
    @Owner("Mohamed Nasser")
    @Test
    public void ViewCategoryProducts() {
        homePage = new P05_HomePage(driver);
        Assert.assertEquals(homePage.getCategoryText().toLowerCase(), "Category".toLowerCase(), "Category at home page");
        homePage.clickWomenCategoryButton().clickWomenCategoryDressButton();
        Assert.assertEquals(homePage.getCategoryPageText().toLowerCase(), "Women - Dress Products".toLowerCase());
    }
}
