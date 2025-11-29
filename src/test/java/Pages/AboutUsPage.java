package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutUsPage {
    WebDriver driver;
    WebDriverWait wait;
    By VideoLocator = By.xpath("//div[contains(@class,'vjs-poster')]");
    By CloseButtonLocator = By.xpath("(//button[contains(text(),'Close')])[4]");
    By TitleLocator = By.id("videoModalLabel");
    String expectedTitle = "About us";

    public AboutUsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public boolean videoIsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(VideoLocator)).isDisplayed();
    }
    public void clickOnCloseButton(){
        wait.until(ExpectedConditions.elementToBeClickable(CloseButtonLocator)).click();
    }
    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TitleLocator)).getText();
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }
}