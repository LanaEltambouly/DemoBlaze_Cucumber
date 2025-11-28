package StepDefinitions;

import Pages.HomePage;
import Pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static HooksPackage.Hooks.driver;

public class SignUp_stepDef {
    HomePage homePage = new HomePage(driver);
    SignUpPage signuppage ;

    String validUsername = "TeamOne_1_6!!" ;
    String validPassword = "TEAMONE16!!";
    String existingUsername = "Test";

    @Given("the user is on the Demoblaze home page")
    public void theUserIsonTheDemoBlazeHomePage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoblaze.com/");
    }

    @When("the user clicks the Sign up Page")
    public void theUserClicksTheSignUpPage() {
        signuppage = homePage.clickOnSignUp();
    }

    @And("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        signuppage.setUsername(validUsername);
        signuppage.setPassword(validPassword);
    }

    @And("the user clicks the Sign up button")
    public void theUserClicksTheSignUpButton() {
        signuppage.clickOnSignUp();
    }

    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExpectedSuccessfulSignUpMess());
    }

    @And("the user enters an existing username")
    public void theUserEntersAnExistingUsername() {
        signuppage.setUsername(existingUsername);
    }

    @And("the user enters a password")
    public void theUserEntersAPassword() {
        signuppage.setPassword("TEAMONE16!!");
    }
    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed(){
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExistUsernameMess());


    }

    // Scenario 3: User signs up with empty fields

    @And("the user leaves all fields empty")
    public void theUserLeavesAllFieldsEmpty(){


    }

    @Then("a validation message should be displayed")
    public void aValidationMessageShouldBeDisplayed(){
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExpectedAnyEmptyFieldMess());
        // signuppage.clickOnOk();

    }



}
