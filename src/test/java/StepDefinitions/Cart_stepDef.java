package StepDefinitions;

import HooksPackage.Hooks;
import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static HooksPackage.Hooks.driver;

public class Cart_stepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    CartPage cartPage;

    @Given("user is on Home Page with no any products added  to the cart")
    public void userIsOnHomePageWithNoAnyProductsAddedToTheCart() {
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        cartPage = homePage.clickOnCart();
    }

    @Then("the cart should display no products")
    public void theCartShouldDisplayNoProducts() {

    }

    @And("the number of items should be {int}")
    public void theNumberOfItemsShouldBe(int arg0) {
    }

    @When("the user adds multiple products to the cart")
    public void theUserAddsMultipleProductsToTheCart() {
    }

    @Then("all items should be displayed in the cart")
    public void allItemsShouldBeDisplayedInTheCart() {
    }

    @And("each item should have a visible image")
    public void eachItemShouldHaveAVisibleImage() {
    }

    @And("each item should have a correct title")
    public void eachItemShouldHaveACorrectTitle() {
    }

    @And("each item should have a correct price")
    public void eachItemShouldHaveACorrectPrice() {
    }

    @Given("the user has products added to the cart")
    public void theUserHasProductsAddedToTheCart() {
    }

    @When("the user opens the cart page")
    public void theUserOpensTheCartPage() {
    }

    @Then("the total price should equal the sum of all product prices")
    public void theTotalPriceShouldEqualTheSumOfAllProductPrices() {
    }

    @Given("the user has multiple products in the cart")
    public void theUserHasMultipleProductsInTheCart() {
    }

    @When("the user deletes a product from the cart")
    public void theUserDeletesAProductFromTheCart() {
    }

    @Then("the number of products in the cart should decrease by {int}")
    public void theNumberOfProductsInTheCartShouldDecreaseBy(int arg0) {
    }

    @Given("the user is on the cart page with products added")
    public void theUserIsOnTheCartPageWithProductsAdded() {
    }

    @When("the user clicks the Place Order button")
    public void theUserClicksThePlaceOrderButton() {
    }

    @Then("the place order popup should appear")
    public void thePlaceOrderPopupShouldAppear() {
    }

    @And("the popup title text should match the expected statement")
    public void thePopupTitleTextShouldMatchTheExpectedStatement() {
    }

    @When("the user deletes all products from the cart")
    public void theUserDeletesAllProductsFromTheCart() {
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
    }

    @And("the Place Order button should be disabled")
    public void thePlaceOrderButtonShouldBeDisabled() {
    }


}
