package StepDefinitions;


import Pages.ContactPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static HooksPackage.Hooks.driver;

public class Contact_stepDef {

    HomePage homePage = new HomePage(driver);
    ContactPage contactPage = new ContactPage(driver);


    @When("user clicks Contact")
    public void userClicksContact() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoblaze.com/");
        homePage.clickOnContact();

    }

    @And("user enters valid contact details")
    public void userEntersValidContactDetails() {
        contactPage.setContactEmail("test@gimail.com");
        contactPage.setContactName("Test Name");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
    }


    @Then("user should see success contact alert")
    public void userShouldSeeSuccessContactAlert() {
        Assert.assertEquals(contactPage.getActualMess(), contactPage.getExpectedMess());
        contactPage.clickOnOk();
    }

    @And("user enters invalid name contact details")
    public void userEntersInvalidNameContactDetails() {
        contactPage.setContactEmail("Test@gimail.com");
        contactPage.setContactName("11111111111");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
    }

    @Then("user should see name error alert")
    public void userShouldSeeNameErrorAlert() {
        Assert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForName()));
        contactPage.clickOnOk();
    }

    @And("user enters invalid email contact details")
    public void userEntersInvalidEmailContactDetails() {
        contactPage.setContactEmail("1111111111");
        contactPage.setContactName("Test Name");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
    }

    @Then("user should see email error alert")
    public void userShouldSeeEmailErrorAlert() {
        Assert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForEmail()));
        contactPage.clickOnOk();
    }

    @And("user enters only message in contact form")
    public void userEntersOnlyMessageInContactForm() {
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
    }

    @Then("user should see empty name and email error alert")
    public void userShouldSeeEmptyNameAndEmailErrorAlert() {
        Assert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForEmptyUsernameAndPassword()));
        contactPage.clickOnOk();
    }
}