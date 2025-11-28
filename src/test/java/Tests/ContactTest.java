package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactTest extends BaseTestClass {

    @Test

    public void verifyContactFormSubmission(){
        contactPage= homepage.clickOnContact();
        contactPage.setContactEmail("test@gimail.com");
        contactPage.setContactName("Test Name");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        Assert.assertEquals(contactPage.getActualMess(), contactPage.getExpectedMess());
        contactPage.clickOnOk();
    }

    @Test(priority = 0)
    public void verifyContactFormSubmissionWithErrorName() {      //BUG
        contactPage = homepage.clickOnContact();
        contactPage.setContactEmail("Test@gimail.com");
        contactPage.setContactName("11111111111");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        Assert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForName()));
        contactPage.clickOnOk();
        //  System.out.println("Test Case Failed");


    }
    @Test(priority = 1)
    public void verifyContactFormSubmissionWithErrorEmail() { //BUG
        contactPage = homepage.clickOnContact();
        contactPage.setContactEmail("1111111111");
        contactPage.setContactName("Test Name");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        Assert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForEmail()));
        contactPage.clickOnOk();
        // System.out.println("Test Case Failed");

    }
    @Test(priority = 2)
    public void verifyContactFormSubmissionWithEmptyNameAndEmail() { //BUG
        contactPage = homepage.clickOnContact();
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        Assert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForEmptyUsernameAndPassword()));
        contactPage.clickOnOk();
        // System.out.println("Test Case Failed");
    }




}
