package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    By AddToCartLocator = By.linkText("Add to cart");
    By ProductNameLocator = By.className("name");
    By ProductPriceLocator = By.className("price-container");
    By Productimg = By.xpath("//div[@id='imgp']");
    By ProductDescriptionLocator = By.id("more-information");
    String AddToCartExpectedMess = "Product added";
    By CartLocator = By.id("cartur");
    By HomeLocator = By.xpath("(//a[@class = 'nav-link'])[1]");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void clickAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(AddToCartLocator)).click();
    }
    public boolean checkProductName(){
         return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductNameLocator)).isDisplayed();
    }
    public boolean checkProductimg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Productimg)).isDisplayed();
    }
    public boolean checkProductPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPriceLocator)).isDisplayed();
    }
    public boolean checkProductDescription(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDescriptionLocator)).isDisplayed();
    }
    public String getAddToCartExpectedMess(){
        return AddToCartExpectedMess;
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

    public CartPage clickOnCart(){
        driver.findElement(CartLocator).click();
        return new CartPage(driver);
    }
    public HomePage clickOnHome(){
        driver.findElement(HomeLocator).click();
        return new HomePage(driver);
    }


}
