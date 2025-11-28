package StepDefinitions;

import HooksPackage.Hooks;
import Pages.HomePage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static HooksPackage.Hooks.driver;

public class Product_stepDef {
    HomePage homePage = new HomePage(driver);
    ProductPage productPage;


    @Given("the user is on the Demoblaze home page")
    public void TheUserIsonTheDemoBlazeHomePage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoblaze.com/");
        Assert.assertTrue(homePage.getActualHomeStatment().contains(homePage.getExpectedHomeStatement()));

    }

    @When("the user clicks on a product")
    public void theUserClicksOnAProduct() {
        productPage = homePage.clickOnProduct(0);
    }

    @Then("the product details page should be displayed")
    public void theProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(productPage.checkProductDescription());
    }

    @Given("the user is on a product details page")
    public void theUserIsOnAProductDetailsPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoblaze.com/prod.html?idp_=1" );
    }

    @When("the user clicks the Add to cart button")
    public void theUserClicksTheAddToCartButton() {
        productPage.clickAddToCart();
    }

    @Then("the product should be successfully added to the cart")
    public void theProductShouldBeSuccessfullyAddedToTheCart() {
        Assert.assertEquals(productPage.getActualMess(),productPage.getAddToCartExpectedMess());
    }


}
