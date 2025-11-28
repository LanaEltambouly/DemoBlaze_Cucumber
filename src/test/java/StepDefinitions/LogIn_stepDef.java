package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogIn_stepDef {         //no inheritance ashan hooks mn3mlsh mno instance tany w y7sal infinite loop
                                     //create object mn kol haga
                                     //pass el driver bel static hooks (Hooks.driver)
    
    @Given("the user is on the Demoblaze home page")
    public void theUserIsOnTheDemoBlazeHomePage(){

    }


    @When("the user clicks the Log in button")
    public void theUserClicksTheLogInButton() {
    }

    @And("the user enters valid login credentials and the user clicks the Log in button")
    public void theUserEntersValidLoginCredentialsAndTheUserClicksTheLogInButton() {
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
    }

    @And("the user enters invalid credentials and the user clicks the Log in button")
    public void theUserEntersInvalidCredentialsAndTheUserClicksTheLogInButton() {
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
    }

    @And("the user does not enter any credentials and the user clicks the Log in button")
    public void theUserDoesNotEnterAnyCredentialsAndTheUserClicksTheLogInButton() {
    }

    @Then("a validation error should be displayed")
    public void aValidationErrorShouldBeDisplayed() {
    }

}
