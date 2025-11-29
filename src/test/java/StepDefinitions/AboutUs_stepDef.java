package StepDefinitions;

import HooksPackage.Hooks;
import Pages.AboutUsPage;
import Pages.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static HooksPackage.Hooks.driver;

public class AboutUs_stepDef {
    HomePage homePage=new HomePage(driver);
    AboutUsPage aboutUsPage;



    @When("the user clicks the About us link")
    public void  theUserClicksTheAboutUsLink(){
        aboutUsPage=homePage.clickOnAboutUs();
    }


    @Then("the About Us popup should be displayed")
    public void theAboutUsPopupShouldBeDisplayed() {
        aboutUsPage.videoIsDisplayed();
        Assert.assertTrue(aboutUsPage.videoIsDisplayed());
    }

    @Given("the About Us popup is displayed")
    public void theAboutUsPopupIsDisplayed() {
        aboutUsPage=homePage.clickOnAboutUs();
        Assert.assertTrue(aboutUsPage.getTitle().contains( "About us"));
    }

    @When("the user clicks the Close button")
    public void theUserClicksTheCloseButton() {

        aboutUsPage.clickOnCloseButton();
    }

    @Then("the About Us popup should be closed")
    public void theAboutUsPopupShouldBeClosed() {
        Assert.assertEquals(aboutUsPage.getTitle(),( "About us"));
    }
}