package Pages_TC;

import Pages.P06_ProductDetails;
import TestBase.Browser;
import Pages.P05_HomePage;
import Pages.P04_Products;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Products Page")
public class T04_Products extends Browser {
    private P05_HomePage homePage;
    private P04_Products products;
    private P06_ProductDetails productDetails;

    @BeforeMethod
    public void setObject() {
        homePage = new P05_HomePage(driver);
        products = new P04_Products(driver);
        productDetails = new P06_ProductDetails(driver);
    }


    @Description("search for product ")
    @Step("Verify user can search for a product from the products page")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.automationexercise.com/products")
    @Owner("Mohamed Nasser")
    @Test
    public void testSearchForProduct() {
        homePage.clickProductsButton();
        Assert.assertEquals(products.getTextFromProductsPage().toLowerCase(), "All Products".toLowerCase(), "All Products Text");
        products.verifyAllProductsVisible().searchForProduct().submitSearch();
        Assert.assertEquals(products.getSearchedProductText().toLowerCase(), "Searched Products".toLowerCase(), "SEARCHED PRODUCTS text");
        products.verifyAllProductsVisible();
    }
}
