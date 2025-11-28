package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTestClass {
    @Test
    public void verifyProductDetailsVisibility(){
        productPage = homepage.clickOnProduct(1);
        Assert.assertTrue(productPage.checkProductName());
        Assert.assertTrue(productPage.checkProductPrice());
        Assert.assertTrue(productPage.checkProductDescription());
        Assert.assertTrue(productPage.checkProductimg());
    }

    @Test
    public void verifyAddToCart(){
        productPage = homepage.clickOnProduct(5);
        productPage.clickAddToCart();
        Assert.assertEquals(productPage.getActualMess(),productPage.getAddToCartExpectedMess());
        productPage.clickOnOk();
    }
}
