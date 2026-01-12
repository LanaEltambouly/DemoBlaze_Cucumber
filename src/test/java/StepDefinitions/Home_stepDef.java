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
import org.testng.Assert;

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
        Assert.assertTrue(laptopsCatPage.getProducts().containsAll(laptopsCatPage.expectedLaptops));
    }

        @When("user clicks Monitors category")
    public void userClicksMonitorsCategory() {
        monitorsCatPage = homePage.ClickOnMonitorsCat();
    }

    @Then("only monitors should be displayed")
    public void onlyMonitorsShouldBeDisplayed() {
        Assert.assertTrue(monitorsCatPage.getProducts().containsAll(monitorsCatPage.expectedMonitors));
    }

    @When("user clicks Categories")
    public void userClicksCategories() {
        categoriesPage = homePage.ClickOnCategories();
    }

    @Then("all products should be displayed")
    public void allProductsShouldBeDisplayed() {
        Assert.assertTrue(categoriesPage.expectedAllProducts.containsAll(categoriesPage.getProducts()));
    }
}
