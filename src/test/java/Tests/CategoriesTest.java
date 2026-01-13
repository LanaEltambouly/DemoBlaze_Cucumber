package Tests;

import BaseTests.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static HooksPackage.Hooks.driver;


public class CategoriesTest extends BaseTestClass {

    @Test
    public void verifyOnlyPhonesAreDisplayedWhenClickOnPhones() {
        phonesCatPage = homepage.ClickOnPhonesCat();
        Assert.assertTrue(phonesCatPage.getProducts().containsAll(phonesCatPage.expectedPhones));

    }


    @Test
    public void verifyOnlyLaptopsAreDisplayedWhenClickOnLaptops() {
        laptopsCatPage = homepage.ClickOnLaptopsCat();
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card-title a")));
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
