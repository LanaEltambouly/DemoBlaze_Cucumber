package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CategoriesTest extends BaseTestClass {

    @Test
    public void verifyOnlyPhonesAreDisplayedWhenClickOnPhones() {
        phonesCatPage = homepage.ClickOnPhonesCat();
        Assert.assertTrue(phonesCatPage.getProducts().containsAll(phonesCatPage.expectedPhones));

    }


    @Test
    public void verifyOnlyLaptopsAreDisplayedWhenClickOnLaptops() {
        laptopsCatPage = homepage.ClickOnLaptopsCat();
        Assert.assertTrue(laptopsCatPage.getProducts().containsAll(laptopsCatPage.expectedLaptops));
    }

    @Test
    public void verifyOnlyMonitorsAreDisplayedWhenClickOnMonitors(){

        monitorsCatPage = homepage.ClickOnMonitorsCat();
        Assert.assertTrue(monitorsCatPage.getProducts().containsAll(monitorsCatPage.expectedMonitors));
    }

    @Test(priority = 3)
    public void verifyAllProductsAreDisplayedWhenClickOnCategories() {
        categoriesPage = homepage.ClickOnCategories();
        Assert.assertTrue(categoriesPage.expectedAllProducts.containsAll(categoriesPage.getProducts()));
    }
}
