package StepDefinitions;

import HooksPackage.Hooks;
import Pages.Categories.CategoriesPage;
import Pages.Categories.LaptopsCatPage;
import Pages.Categories.MonitorsCatPage;
import Pages.Categories.PhonesCatPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static HooksPackage.Hooks.driver;  //****

public class Home_stepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    PhonesCatPage phonesCatPage;
    LaptopsCatPage laptopsCatPage;
    MonitorsCatPage monitorsCatPage;
    CategoriesPage categoriesPage;

    @Given("user is on Home Page")
    public void UserIsonHomePage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoblaze.com/");
        Assert.assertTrue(homePage.checkImages());
    }


    @When("user clicks Monitors category")
    public void userClicksMonitorsCategory() {
        monitorsCatPage = homePage.ClickOnMonitorsCat();
    }

    @Then("only monitors should be displayed")
    public void onlyMonitorsShouldBeDisplayed() {
        monitorsCatPage = homePage.ClickOnMonitorsCat();
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card-title a")));
        Assert.assertTrue(monitorsCatPage.getProducts().containsAll(monitorsCatPage.expectedMonitors));

    }

    @When("user clicks Categories")
    public void userClicksCategories() {
        categoriesPage = homePage.ClickOnCategories();
       }

    @Then("all products should be displayed")
    public void allProductsShouldBeDisplayed() {
        categoriesPage = homePage.ClickOnCategories();
        Assert.assertTrue(categoriesPage.expectedAllProducts.containsAll(categoriesPage.getProducts()));
    }

    @When("user clicks Phones category")
    public void userClicksPhonesCategory() {
        phonesCatPage = homePage.ClickOnPhonesCat();
    }

    @Then("only phones should be displayed")
    public void onlyPhonesShouldBeDisplayed() {
        Assert.assertTrue(phonesCatPage.getProducts().containsAll(phonesCatPage.expectedPhones));
    }

    @When("user clicks Laptops category")
    public void userClicksLaptopsCategory() {
        laptopsCatPage = homePage.ClickOnLaptopsCat();
       }

    @Then("only laptops should be displayed")
    public void onlyLaptopsShouldBeDisplayed() {
        laptopsCatPage = homePage.ClickOnLaptopsCat();
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card-title a")));
        Assert.assertTrue(laptopsCatPage.getProducts().containsAll(laptopsCatPage.expectedLaptops));
    }
}
