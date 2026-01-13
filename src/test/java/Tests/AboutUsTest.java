package Tests;

import BaseTests.BaseTestClass;
import Pages.AboutUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsTest extends BaseTestClass {

    @Test(priority = 0)
    public void verifyVideoIsDisplayedWhenClickAboutUs(){
        AboutUsPage aboutUsPage = homepage.clickOnAboutUs();
        Assert.assertTrue(aboutUsPage.videoIsDisplayed());
    }

    @Test
    public void verifyCloseButtonOnAboutUsPage(){
        AboutUsPage aboutUsPage = homepage.clickOnAboutUs();
        aboutUsPage.clickOnCloseButton();

        Assert.assertTrue(homepage.checkImages());
    }

}
