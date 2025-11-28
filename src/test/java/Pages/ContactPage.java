package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    WebDriver driver;
    WebDriverWait wait;
    By contactEmailLocator = By.id("recipient-email");
    By contactNameLocator = By.id("recipient-name");
    By contactMessageLocator = By.id("message-text");
    By sendMessageButtonLocator = By.xpath("//button[text()='Send message']");
    By closeButtonLocator = By.xpath("//button[text()='Close']");
    String expectedMess = "Thanks for the message!!";
    String expectedAnErrorMsgForName = "Please fill out Name and Message.";
    String expectedAnErrorMsgForEmail = "Please fill out Email and Message.";
    String expectedAnErrorMsgForEmptyUsernameAndPassword = "Please fill out Name and Email.";


    public ContactPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
   public void setContactEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactEmailLocator)).sendKeys(email);
    }

    public void setContactName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNameLocator)).sendKeys(name);

    }
    public void setContactMessage(String message){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactMessageLocator)).sendKeys(message);

    }
    public void clickOnSendMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(sendMessageButtonLocator))).click();

    }
    public void clickOnClose(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(closeButtonLocator))).click();

    }
    public void clickOnOk(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getExpectedAnErrorMsgForEmail() {
        return expectedAnErrorMsgForEmail;
    }
    public String getExpectedAnErrorMsgForEmptyUsernameAndPassword() {
        return expectedAnErrorMsgForEmptyUsernameAndPassword;
    }
    public String getExpectedAnErrorMsgForName() {
        return expectedAnErrorMsgForName;
    }
    public String getExpectedMess(){
        return expectedMess;
    }

    public String getActualMess(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }





}
