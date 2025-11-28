package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;



public class OtherPagesTest extends BaseTestClass {


    @Test
    public void verifyClickingNextFromLaptops(){
        laptopsCatPage = homepage.ClickOnLaptopsCat();
        laptopsCatPage.ClickOnNextButton();
        System.out.println(laptopsCatPage.getProducts());
        System.out.println(laptopsCatPage.getExpectedPhonesAndMonitor);
        Assert.assertTrue(laptopsCatPage.getProducts().containsAll(laptopsCatPage.getExpectedPhonesAndMonitor));

    }
    @Test
    public void verifyClickingNextFromMonitors(){
        monitorsCatPage = homepage.ClickOnMonitorsCat();
        monitorsCatPage.ClickOnNextButton();
        Assert .assertTrue(monitorsCatPage.getProducts().containsAll(monitorsCatPage.expectedLaptopsAndPhones));
    }

    @Test
    public void verifyClickingNextFromPhones(){
        phonesCatPage = homepage.ClickOnPhonesCat();
        phonesCatPage.ClickOnNextButton();
        Assert.assertTrue(phonesCatPage.getProducts().containsAll(phonesCatPage.getExpectedLaptopsAndMonitor));
    }








    @Test
    public void verifyClickingPreviousFromPhones(){
        phonesCatPage = homepage.ClickOnPhonesCat();
        phonesCatPage.ClickOnPreviousButton();
        Assert.assertTrue(phonesCatPage.getProducts().containsAll(phonesCatPage.expectedPhones));
    }

    @Test
    public void verifyClickingPreviousFromLaptops(){
        laptopsCatPage = homepage.ClickOnLaptopsCat();
        laptopsCatPage.ClickOnPreviousButton();
        Assert .assertTrue(laptopsCatPage.getProducts().containsAll(laptopsCatPage.expectedLaptops));
    }



    @Test
    public void verifyClickingPreviousFromMonitors(){
        monitorsCatPage = homepage.ClickOnMonitorsCat();
        monitorsCatPage.ClickOnPreviousButton();
        Assert.assertTrue(monitorsCatPage.getProducts().containsAll(monitorsCatPage.expectedMonitors));
    }

    @Test
    public void verifyClickingNextFromCategories(){
        categoriesPage = homepage.ClickOnCategories();
        categoriesPage.ClickOnNextButton();

        Assert.assertTrue(categoriesPage.getProducts().containsAll(categoriesPage.expectedAllProducts));
    }
    @Test
    public void verifyClickingPreviousFromCategories(){
        categoriesPage = homepage.ClickOnCategories();
        categoriesPage.ClickOnPreviousButton();
        Assert.assertTrue(categoriesPage.getProducts().containsAll(categoriesPage.expectedAllProducts));
    }
}
