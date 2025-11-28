package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    WebDriverWait wait;
    By UsernameLocator = By.id("sign-username");
    By PasswordLocator = By.id("sign-password");
    By SignUpButtonLocator = By.xpath("//button[@onclick='register()']");
    By CloseButtonLocator = By.xpath("(//button[contains(text(), 'Close')])[2]");
    String expectedSuccessfulSignUpMess = "Sign up successful.";
    String expectedAnyEmptyFieldMess = "Please fill out Username and Password.";
    String expectedExistUsernameMess = "This user already exist.";


    public SignUpPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void setUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsernameLocator)).sendKeys(username);
    }
    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordLocator)).sendKeys(password);
    }
    public void clickOnClose(){
        wait.until(ExpectedConditions.elementToBeClickable(CloseButtonLocator)).click();
    }
    public void clickOnSignUp(){
        wait.until(ExpectedConditions.elementToBeClickable(SignUpButtonLocator)).click();
    }
    public String getExpectedSuccessfulSignUpMess(){
        return expectedSuccessfulSignUpMess;
    }
    public String getExpectedAnyEmptyFieldMess(){
        return expectedAnyEmptyFieldMess;
    }
    public String getExistUsernameMess(){
        return expectedExistUsernameMess;
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
