package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.PlaceOrderPage;
import Pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Cart_stepDef {
    HomePage homepage = new HomePage(Hooks.driver);
    ProductPage productPage;
    CartPage cartPage;
    PlaceOrderPage placeOrderPage;

    int NumberOfProductsAddedToCart = 0;

    public void ProductToCartScenario(int i){
        productPage = homepage.clickOnProduct(i);
        productPage.clickAddToCart();
        NumberOfProductsAddedToCart ++;
        productPage.clickOnOk();
        productPage.clickOnHome();
    }

    @When("the user adds multiple products to the cart")
    public void TheUserAddsMultipleProductsToTheCart(){
        ProductToCartScenario(0);
        ProductToCartScenario(8);
        ProductToCartScenario(3);
    }


    @And("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        cartPage = productPage.clickOnCart();
    }

    @Then("all items should be displayed in the cart")
    public void allItemsShouldBeDisplayedInTheCart() {
        Assert.assertEquals(cartPage.getNumberOfRows(), NumberOfProductsAddedToCart);
    }

    @And("each item should have a visible image")
    public void eachItemShouldHaveAVisibleImage() {
        Assert.assertTrue(cartPage.displayedImage());
    }

    @And("each item should have a correct title")
    public void eachItemShouldHaveACorrectTitle() {
        Assert.assertTrue(cartPage.checkTitles());
        Assert.assertTrue(cartPage.checkTotalPrice());
    }

    @And("each item should have a correct price")
    public void eachItemShouldHaveACorrectPrice() {
        Assert.assertTrue(cartPage.checkPrices());
    }

    @Then("the total price should equal the sum of all product prices")
    public void theTotalPriceShouldEqualTheSumOfAllProductPrices() {
        Assert.assertEquals(cartPage.getActualTotalProductPrice(), cartPage.getFoundTotalPrice());
    }

    @When("the user deletes a product from the cart")
    public void theUserDeletesAProductFromTheCart() {
        cartPage.DeleteProduct(0);
        NumberOfProductsAddedToCart --;
    }

    @Then("the number of products in the cart should decrease by one")
    public void theNumberOfProductsInTheCartShouldDecreaseByOne() {
        Assert.assertEquals(cartPage.getNumberOfRows(), NumberOfProductsAddedToCart);
    }

    @When("the user clicks the Place Order button")
    public void theUserClicksThePlaceOrderButton() {
        placeOrderPage = cartPage.ClickOnPlaceOrder();
    }

    @Then("the place order popup should appear")
    public void thePlaceOrderPopupShouldAppear() {
        Assert.assertEquals(placeOrderPage.getActualPlaceOrderStatement(), placeOrderPage.getExpectedPlaceOrderStatement());
    }

    @When("the user deletes all products from the cart")
    public void theUserDeletesAllProductsFromTheCart() {
        cartPage.DeleteAllProducts();
    }

    @Then("the cart should display no products")
    public void theCartShouldDisplayNoProducts() {
        Assert.assertEquals(cartPage.getNumberOfRowsWhenCartIsEmpty(), NumberOfProductsAddedToCart);
    }


    @And("the Place Order button should be disabled")
    public void thePlaceOrderButtonShouldBeDisabled() {
        Assert.assertTrue(cartPage.PlaceOrderButtonDisability());
    }

    @When("the user navigates to the cart with no products added")
    public void theUserNavigatesToTheCartWithNoProductsAdded() {
        cartPage = homepage.clickOnCart();
    }
}
