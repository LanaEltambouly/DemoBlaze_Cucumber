package Tests;

import BaseTests.BaseTestClass;
import Pages.Categories.CategoriesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class OtherPagesTest extends BaseTestClass {

    public List<String> expectedAllProducts = Arrays.asList( "Sony vaio i5", "Sony vaio i7", "MacBook air",
            "Dell i7 8gb","2017 Dell 15.6 Inch","MacBook Pro","Apple monitor 24", "ASUS Full HD",
            "Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7",
            "Iphone 6 32gb", "Sony xperia z5", "HTC One M9"
    );

    @Test
    public void verifyClickingNextFromLaptops(){
        laptopsCatPage = homepage.ClickOnLaptopsCat();
        nextPage = laptopsCatPage.ClickOnNextButton();

        Assert.assertTrue(nextPage.getProducts().containsAll(laptopsCatPage.expectedLaptops));

    }
    @Test
    public void verifyClickingNextFromMonitors(){ //BUG
        monitorsCatPage = homepage.ClickOnMonitorsCat();
        nextPage = monitorsCatPage.ClickOnNextButton();
        Assert.assertEquals(nextPage.getProducts().size(),0);
    }

    @Test
    public void verifyClickingNextFromPhones(){ //BUG
        phonesCatPage = homepage.ClickOnPhonesCat();
        nextPage = phonesCatPage.ClickOnNextButton();
        Assert.assertEquals(nextPage.getProducts().size(),0);
    }




    @Test
    public void verifyClickingPreviousFromPhones(){
        phonesCatPage = homepage.ClickOnPhonesCat();
        previousPage = phonesCatPage.ClickOnPreviousButton();
        Assert.assertTrue(expectedAllProducts.containsAll(previousPage.getProducts()));
    }

    @Test
    public void verifyClickingPreviousFromLaptops(){
        laptopsCatPage = homepage.ClickOnLaptopsCat();
        previousPage = laptopsCatPage.ClickOnPreviousButton();
        Assert.assertTrue(expectedAllProducts.containsAll(previousPage.getProducts()));
    }


    @Test
    public void verifyClickingPreviousFromMonitors(){
        monitorsCatPage = homepage.ClickOnMonitorsCat();
        previousPage = monitorsCatPage.ClickOnPreviousButton();
        Assert.assertTrue(expectedAllProducts.containsAll(previousPage.getProducts()));
    }

    @Test
    public void verifyClickingNextFromCategories(){
        categoriesPage = homepage.ClickOnCategories();
        nextPage = categoriesPage.ClickOnNextButton();

        Assert.assertTrue(categoriesPage.expectedAllProducts.containsAll(nextPage.getProducts()));
    }

    @Test
    public void verifyClickingPreviousFromCategories(){
        categoriesPage = homepage.ClickOnCategories();
        previousPage = categoriesPage.ClickOnPreviousButton();
        Assert.assertTrue(categoriesPage.expectedAllProducts.containsAll(previousPage.getProducts()));
    }
}
