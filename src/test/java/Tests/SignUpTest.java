package Tests;

import BaseTests.BaseTestClass;
import Pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTestClass{
    @Test
    public void verifyValidSignUp(){
        signuppage = homepage.clickOnSignUp();
        signuppage.setUsername("LANAAAAAAA");
        signuppage.setPassword("LANA20_9!!!");
        signuppage.clickOnSignUp();
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExpectedSuccessfulSignUpMess());
        signuppage.clickOnOk();
    }
    @Test
    public void verifyExistingSignUp(){
        signuppage = homepage.clickOnSignUp();
        signuppage.setUsername("TeamOne_1");
        signuppage.setPassword("TEAMONE1");
        signuppage.clickOnSignUp();
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExistUsernameMess());
        signuppage.clickOnOk();
    }

    @Test
    public void verifyEmptySignUp(){
        signuppage = homepage.clickOnSignUp();
        signuppage.clickOnSignUp();
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExpectedAnyEmptyFieldMess());
        signuppage.clickOnOk();

    }

    @Test
    public void verifyEmptyUsernameSignUp(){
        signuppage = homepage.clickOnSignUp();
        signuppage.setUsername("Team One 1");
        signuppage.clickOnSignUp();
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExpectedAnyEmptyFieldMess());
        signuppage.clickOnOk();
    }

    @Test
    public void verifyEmptyPasswordSignUp(){
        signuppage = homepage.clickOnSignUp();
        signuppage.setPassword("11111");
        signuppage.clickOnSignUp();
        Assert.assertEquals(signuppage.getActualMess(),signuppage.getExpectedAnyEmptyFieldMess());
        signuppage.clickOnOk();
    }
    @Test
    public void verifyCloseButtonSignUp(){
        signuppage = homepage.clickOnSignUp();
        signuppage.clickOnClose();
        Assert.assertTrue(homepage.checkSignUp());

    }

}
