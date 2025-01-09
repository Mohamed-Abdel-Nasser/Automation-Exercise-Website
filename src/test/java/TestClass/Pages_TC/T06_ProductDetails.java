package TestClass.Pages_TC;

import Pages.*;
import TestBase.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("View Product Details")
public class T06_ProductDetails extends TestBase {

    private P05_HomePage homePage;
    private P04_Products products;
    private P06_ProductDetails productDetails;

    @BeforeMethod
    public void setObject() {

        products = new P04_Products(driver);
        productDetails = new P06_ProductDetails(driver);
        homePage = new P05_HomePage(driver);
    }

    @Description("Navigate to the products page and view product details")
    @Step("Verify user can navigate to the products page and view product details")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.automationexercise.com/products")
    @Owner("Mohamed Nasser")
    @Test
    public void testNavigateToProductsPageAndViewProductDetails() {
        homePage.clickProductsButton();
        Assert.assertEquals(products.getTextFromProductsPage(), "ALL PRODUCTS", "All Products Text");
        products.verifyAllProductsVisible();
        productDetails.checkVisibilityOfProductInformation();
    }

}
