package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    WebDriver driver;
    WebDriverWait wait;
    By UsernameLocator = By.id("loginusername");
    By PasswordLocator = By.id("loginpassword");
    By LogInButtonLocator = By.xpath("//button[@onclick='logIn()']");
    By CloseButtonLocator = By.xpath("//button[contains(text(), 'Close')])[3]");
    String expectedAnyEmptyFieldMess = "Please fill out Username and Password.";
    String expectedWrongUsernameMess = "User does not exist.";
    String expectedWrongPasswordMess = "Wrong password.";
    String expectedWrongCredentialsMess = "User does not exist.";

    public LogInPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsernameLocator)).sendKeys(username);
    }
    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordLocator)).sendKeys(password);
    }
    public void clickOnLogIn(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LogInButtonLocator))).click();
    }
    public void clickOnClose(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CloseButtonLocator))).click();
    }

    public String getExpectedWrongCredentialsMess(){
        return expectedWrongCredentialsMess;
    }
    public String getExpectedWrongPasswordMess(){
        return expectedWrongPasswordMess;
    }
    public String getExpectedWrongUsernameMess(){
        return expectedWrongUsernameMess;
    }
    public String getExpectedAnyEmptyFieldMess(){
        return expectedAnyEmptyFieldMess;
    }
    public void clickOnOk(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public String getActualMess(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}