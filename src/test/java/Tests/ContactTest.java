package Tests;

import BaseTests.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ContactTest extends BaseTestClass {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyContactFormSubmission(){
        contactPage= homepage.clickOnContact();
        contactPage.setContactEmail("test@gimail.com");
        contactPage.setContactName("Test Name");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        softAssert.assertEquals(contactPage.getActualMess(), contactPage.getExpectedMess());
        contactPage.clickOnOk();
        softAssert.assertAll();
    }

    @Test
    public void verifyContactFormSubmissionWithErrorName() {      //BUG
        contactPage = homepage.clickOnContact();
        contactPage.setContactEmail("Test@gimail.com");
        contactPage.setContactName("11111111111");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        softAssert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForName()));
        contactPage.clickOnOk();
        softAssert.assertAll();
    }

    @Test
    public void verifyContactFormSubmissionWithErrorEmail() { //BUG
        contactPage = homepage.clickOnContact();
        contactPage.setContactEmail("1111111111");
        contactPage.setContactName("Test Name");
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        softAssert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForEmail()));
        contactPage.clickOnOk();
        softAssert.assertAll();
    }

    @Test
    public void verifyContactFormSubmissionWithEmptyNameAndEmail() { //BUG
        contactPage = homepage.clickOnContact();
        contactPage.setContactMessage("This is a test message.");
        contactPage.clickOnSendMessage();
        softAssert.assertTrue(contactPage.getActualMess().contains(contactPage.getExpectedAnErrorMsgForEmptyUsernameAndPassword()));
        contactPage.clickOnOk();
        softAssert.assertAll();
        }




}
