package StepDefinitions;

import HooksPackage.Hooks;
import Pages.CartPage;
import Pages.HomePage;
import Pages.PlaceOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PlaceOrder_stepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    PlaceOrderPage placeOrderPage;

    @Given("user is on Place Order page")
    public void UserIsonPlaceOrderPage(){
       placeOrderPage = homePage.clickOnCart().ClickOnPlaceOrder();
       Assert.assertTrue(placeOrderPage.getActualPlaceOrderStatement().contains(placeOrderPage.getExpectedPlaceOrderStatement()));
    }


    @When("user enters place order data {string} {string} {string} {string} {string} {string}")
    public void userEntersPlaceOrderData(String name, String country, String city, String card, String month, String year) {
         placeOrderPage.enterName(name);
         placeOrderPage.enterCountry(country);
         placeOrderPage.enterCity(city);
         placeOrderPage.enterCard(card);
         placeOrderPage.enterMonth(month);
         placeOrderPage.enterYear(year);
    }

    @And("clicks Purchase")
    public void clicksPurchase() {
        placeOrderPage.clickPurchase();
    }

    @Then("a place order message should be displayed accourding to {string}")
    public void aPlaceOrderMessageShouldBeDisplayedAccourdingTo(String Input) {
        switch (Input.trim()) {
            case "Valid data": {
                Assert.assertTrue(placeOrderPage.getActualPurchaseMessage().contains(placeOrderPage.getExpectedResult()));
                break;
            }
            case "All empty": {
                Assert.assertTrue(placeOrderPage.getActualMissingInfoResult().contains(placeOrderPage.getExpectedMissingInfoResult()));
                break;
            }
            case "Invalid formats": {
                Assert.assertTrue(placeOrderPage.getActualPurchaseMessage().contains("Error you should enter valid syntax"));
                break;
            }
            case "Some fields missing": {
                Assert.assertTrue(placeOrderPage.getActualPurchaseMessage().contains("Please enter data in empty fields"));
                break;
            }
            default: Assert.fail("unexpected input");
        }
    }
}
