package Tests;

import BaseTests.BaseTestClass;
import Pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTestClass {

    @Test(priority = 4)
    public void verifyLoginWithValidCredentials(){
        loginPage = homepage.clickOnLogIn();
        loginPage.setUsername("teamone1");
        loginPage.setPassword("1234");
        loginPage.clickOnLogIn();
        Assert.assertTrue(homepage.getActualWelcomeMess().contains("Welcome"));
        Assert.assertTrue(homepage.checkLogout());

    }
    @Test(priority = 0)
    public void verifyLoginWithInvalidCredentials(){
        loginPage = homepage.clickOnLogIn();
        loginPage.setUsername("teammmm");
        loginPage.setPassword("012");
        loginPage.clickOnLogIn();
        Assert.assertEquals(loginPage.getActualMess(),loginPage.getExpectedWrongCredentialsMess());
        loginPage.clickOnOk();

    }
    @Test(priority = 1)
    public void verifyLoginWithWrongUsername(){
        loginPage = homepage.clickOnLogIn();
        loginPage.setUsername("teammm");
        loginPage.setPassword("1234");
        loginPage.clickOnLogIn();
        Assert.assertEquals(loginPage.getActualMess(),loginPage.getExpectedWrongUsernameMess());
        loginPage.clickOnOk();

    }
    @Test(priority = 2)
    public void verifyLoginWithWrongPassword(){
        loginPage = homepage.clickOnLogIn();
        loginPage.setUsername("teamone1");
        loginPage.setPassword("12");
        loginPage.clickOnLogIn();
        Assert.assertEquals(loginPage.getActualMess(),loginPage.getExpectedWrongPasswordMess());
        loginPage.clickOnOk();

    }
    @Test(priority = 3)
    public void verifyLoginWithEmptyFields(){
        loginPage = homepage.clickOnLogIn();
        loginPage.clickOnLogIn();
        Assert.assertEquals(loginPage.getActualMess(),loginPage.getExpectedAnyEmptyFieldMess());
        loginPage.clickOnOk();
    }

    @Test(priority = 5)
    public void verifyLogOut(){
        homepage.ClickOnLogout();
        Assert.assertTrue(homepage.checkLogin());


    }

}
