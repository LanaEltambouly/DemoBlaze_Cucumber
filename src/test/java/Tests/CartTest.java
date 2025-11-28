package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTestClass {
    public void ProductToCartScenario(int i){
        productPage = homepage.clickOnProduct(i);
        productPage.clickAddToCart();
        productPage.clickOnOk();
    }


    @Test(priority = 1)
    public void verifyMultipleProductsAddedToCartSuccessfully(){
        ProductToCartScenario(1);
        productPage.clickOnHome();
        ProductToCartScenario(6);
        productPage.clickOnHome();
        ProductToCartScenario(2);
        productPage.clickOnHome();
        ProductToCartScenario(2);
        productPage.clickOnHome();
        ProductToCartScenario(4);
        cartPage = productPage.clickOnCart();

        Assert.assertTrue(cartPage.displayedImage());
        Assert.assertTrue(cartPage.checkPrices());
        Assert.assertTrue(cartPage.checkTitles());
        Assert.assertTrue(cartPage.checkTotalPrice());
        Assert.assertEquals(cartPage.getProductsListSize(), 5);
    }


    @Test(priority = 2)
    public void verifyCorrectTotalPrice(){
        cartPage = productPage.clickOnCart();

        Assert.assertEquals(cartPage.getActualTotalProductPrice(), cartPage.getFoundTotalPrice());
    }


    @Test(priority = 4)
    public void verifyPlaceOrderFromCart(){
        cartPage = productPage.clickOnCart();
        placeOrderPage = cartPage.ClickOnPlaceOrder();
        Assert.assertEquals(placeOrderPage.getActualPlaceOrderStatement(), placeOrderPage.getExpectedPlaceOrderStatement());
    }

    @Test(priority = 3)
    public void verifyDeleteFromCart(){
        cartPage = productPage.clickOnCart();
        cartPage.ClickOnDelete(0);
        Assert.assertEquals(cartPage.getProductsListSize(), 4);
    }

    @Test(priority = 0)
    public void verifyEmptyCartDisplaysNothing(){
        cartPage = homepage.clickOnCart();
        Assert.assertEquals(cartPage.getProductsListSize(), 0);
    }

    @Test(priority = 6)
    public void verifyEmptyCartDisablePlaceOrder(){
        cartPage = homepage.clickOnCart();
        Assert.assertEquals(cartPage.getProductsListSize(), 0);
        Assert.assertTrue(cartPage.PlaceOrderButtonDisability());  //    BUUUUUUUUUUUGGGGGGG
    }

    @Test(priority = 5)
    public void verifyDeletingAllProducts(){
        cartPage = productPage.clickOnCart();
        cartPage.ClickOnDelete(0);
        cartPage.ClickOnDelete(1);
        cartPage.ClickOnDelete(2);
        cartPage.ClickOnDelete(3);


        Assert.assertEquals(cartPage.getProductsListSize(), 0);
        Assert.assertTrue(cartPage.PlaceOrderButtonDisability());   //    BUUUUUUUUUUUGGGGGGG


    }



}
