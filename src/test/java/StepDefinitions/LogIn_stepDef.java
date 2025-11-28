package StepDefinitions;

import HooksPackage.Hooks;
import Pages.HomePage;
import Pages.LogInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static HooksPackage.Hooks.driver;

public class LogIn_stepDef {         //no inheritance ashan hooks mn3mlsh mno instance tany w y7sal infinite loop
                                     //create object mn kol haga
                                     //pass el driver bel static hooks (Hooks.driver)

    HomePage homepage = new HomePage(driver);
    LogInPage loginPage;

    @Given("the user is on the Demoblaze home page")
    public void theUserIsOnTheDemoBlazeHomePage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoblaze.com/");
    }


    @When("the user clicks the Log in Page")
    public void theUserClicksTheLogInPage() {
        loginPage = homepage.clickOnLogIn();
    }

    @And("the user enters valid login credentials")
    public void theUserEntersValidLoginCredentials() {
        loginPage.setUsername("teamone1");
        loginPage.setPassword("1234");
    }

    @And("the user clicks the Log in button")
    public void theUserClicksTheLogInButton() {
        loginPage.clickOnLogIn();
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        Assert.assertTrue(homepage.getActualWelcomeMess().contains("Welcome"));
        Assert.assertTrue(homepage.checkLogout());

    }

    @And("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        loginPage.setUsername("WrongUser!!!!!!!!!!!");
        loginPage.setPassword("WrongPass");
    }

    @Then("An error message should be displayed")
    public void AnErrorMessageShouldBeDisplayed() {
        Assert.assertEquals(loginPage.getActualMess(), loginPage.getExpectedWrongCredentialsMess());
    }

    @And("the user does not enter any credentials")
    public void theUserDoesNotEnterAnyCredentials() {
        loginPage.setUsername("");
        loginPage.setPassword("");
    }

    @Then("a validation error should be displayed")
    public void aValidationErrorShouldBeDisplayed() {
        Assert.assertEquals(loginPage.getActualMess(), loginPage.getExpectedAnyEmptyFieldMess());
    }



}
