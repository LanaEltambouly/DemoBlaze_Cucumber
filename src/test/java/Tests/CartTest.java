package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTestClass {

    int NumberOfProductsAddedToCart = 0;


    public void ProductToCartScenario(int i){
        productPage = homepage.clickOnProduct(i);
        productPage.clickAddToCart();
        NumberOfProductsAddedToCart ++;
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
        Assert.assertEquals(cartPage.getNumberOfRows(), NumberOfProductsAddedToCart);
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
    public void verifyDeleteProductFromCart(){
        cartPage = productPage.clickOnCart();
        cartPage.DeleteProduct(0);
        NumberOfProductsAddedToCart --;

        Assert.assertEquals(cartPage.getNumberOfRows(), NumberOfProductsAddedToCart);
    }

    @Test(priority = 0)
    public void verifyEmptyCartDisplaysNothing(){
        cartPage = homepage.clickOnCart();
        Assert.assertEquals(cartPage.getNumberOfRowsWhenCartIsEmpty(), NumberOfProductsAddedToCart);
    }


    @Test(priority = 5)
    public void verifyDeletingAllProductsCausesEmptyCart(){
        cartPage = productPage.clickOnCart();
        cartPage.DeleteAllProducts();
        Assert.assertEquals(cartPage.getNumberOfRowsWhenCartIsEmpty(), NumberOfProductsAddedToCart);
        Assert.assertTrue(cartPage.PlaceOrderButtonDisability()); //    BUGGGGG

    }


}
