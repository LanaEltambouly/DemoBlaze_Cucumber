package StepDefinitions;

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


    @When("the user clicks on a product")
    public void theUserClicksOnAProduct() {
        productPage = homePage.clickOnProduct(0);
    }

    @Then("the product details page should be displayed")
    public void theProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(productPage.checkProductDescription());
        Assert.assertTrue(productPage.checkProductimg());
        Assert.assertTrue(productPage.checkProductPrice());
        Assert.assertTrue(productPage.checkProductName());

    }

    @Given("the user is on a product details page")
    public void theUserIsOnAProductDetailsPage() {
        productPage = homePage.clickOnProduct(1);
        Assert.assertTrue(driver.getCurrentUrl().contains("prod.html?idp_="));
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
