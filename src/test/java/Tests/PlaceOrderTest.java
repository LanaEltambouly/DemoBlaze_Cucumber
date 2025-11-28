package Tests;

import BaseTests.BaseTestClass;
import Pages.PlaceOrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  PlaceOrderTest extends BaseTestClass {

    @Test
    public void verifyPlaceOrderWithValidCredentials(){
        productPage= homepage.clickOnProduct(1);
        productPage.clickAddToCart();
        productPage.clickOnOk();
        cartPage = homepage.clickOnCart();
        placeOrderPage = cartPage.ClickOnPlaceOrder();
        placeOrderPage.enterName("nasser");
        placeOrderPage.enterCountry("Egypt");
        placeOrderPage.enterCity("cairo");
        placeOrderPage.enterCard("5162659515495");
        placeOrderPage.enterMonth("5");
        placeOrderPage.enterYear("2005");
        placeOrderPage.clickPurchase();
        Assert.assertTrue(placeOrderPage.getActualPurchaseMessage().contains(placeOrderPage.getExpectedResult()));
        placeOrderPage.clickOK();
    }

    @Test
    public void verifyPlaceOrderWithoutAnyCredentials(){
        productPage= homepage.clickOnProduct(1);
        productPage.clickAddToCart();
        productPage.clickOnOk();
        cartPage = homepage.clickOnCart();
        placeOrderPage = cartPage.ClickOnPlaceOrder();
        placeOrderPage.enterName("");
        placeOrderPage.enterCountry("");
        placeOrderPage.enterCity("");
        placeOrderPage.enterCard("");
        placeOrderPage.enterMonth("");
        placeOrderPage.enterYear("");
        placeOrderPage.clickPurchase();
        Assert.assertTrue(placeOrderPage.getActualMissingInfoResult().contains(placeOrderPage.getExpectedMissingInfoResult()));
        placeOrderPage.clickOnOk();
    }
    @Test
    public void verifyPlaceOrderWithWrongSyntax(){       // BUUUUUGGG
        productPage= homepage.clickOnProduct(1);
        productPage.clickAddToCart();
        productPage.clickOnOk();
        cartPage = homepage.clickOnCart();
        placeOrderPage = cartPage.ClickOnPlaceOrder();
        placeOrderPage.enterName("111111");
        placeOrderPage.enterCountry("54848");
        placeOrderPage.enterCity("8878");
        placeOrderPage.enterCard("mkkjgtfrf");
        placeOrderPage.enterMonth("mnjnj");
        placeOrderPage.enterYear("kjjj");
        placeOrderPage.clickPurchase();
        Assert.assertTrue(placeOrderPage.getActualPurchaseMessage().contains("Error you should enter valid syntax"));


    }
    @Test
    public void verifyPlaceOrderWithMissingFields(){  // BUUUUUGGGGGGG
        productPage= homepage.clickOnProduct(1);
        productPage.clickAddToCart();
        productPage.clickOnOk();
        cartPage = homepage.clickOnCart();
        placeOrderPage = cartPage.ClickOnPlaceOrder();
        placeOrderPage.enterName("nasser");
        placeOrderPage.enterCountry("");
        placeOrderPage.enterCity("");
        placeOrderPage.enterCard("5162659515495");
        placeOrderPage.enterMonth("");
        placeOrderPage.enterYear("");
        placeOrderPage.clickPurchase();
        Assert.assertTrue(placeOrderPage.getActualPurchaseMessage().contains("Please enter data in empty fields"));
    }
}
