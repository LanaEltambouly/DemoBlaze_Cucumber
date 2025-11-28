package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderPage {
    WebDriver driver;
    WebDriverWait wait;
    By Name = By.id("name");
    By Country = By.id("country");
    By City = By.id("city");
    By CreditCard = By.id("card");
    By Month = By.id("month");
    By Year = By.id("year");
    By purchaseButtonLocator = By.xpath("//button[text()='Purchase']");
    By okButtonLocator = By.xpath("//button[text()='OK']");
    By closeButtonLocator = By.xpath("//button[text()='Close']");
    By TotalLocator = By.id("totalm");
    By ActualPurchaseMessageLocator = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
    String expectedSuccessfulResult = "Thank you for your purchase!";
    String expectedMissingInfoResult = "Please fill out Name and Creditcard.";
    By placeOrderStatementLocator = By.id("orderModalLabel");
    String expectedPlaceOrderStatement = "Place order";



    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderStatementLocator));
    }

    public void enterName(String name) {
        driver.findElement(Name).sendKeys(name);
    }

    public void enterCountry(String country) {
        driver.findElement(Country).sendKeys(country);
    }

    public void enterCity(String city) {
        driver.findElement(City).sendKeys(city);
    }

    public void enterCard(String card) {
        driver.findElement(CreditCard).sendKeys(card);
    }

    public void enterMonth(String month) {
        driver.findElement(Month).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(Year).sendKeys(year);
    }

    public void clickPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButtonLocator));
        driver.findElement(purchaseButtonLocator).click();
    }

    public CartPage clickClose() {
        driver.findElement(closeButtonLocator).click();
        return new CartPage(driver);
    }

    public HomePage clickOK() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(okButtonLocator)));
        driver.findElement(okButtonLocator).click();
        return new HomePage(driver);
    }


    public String getTotal() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(TotalLocator))).getText();
    }

    public String getActualPurchaseMessage() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualPurchaseMessageLocator))).getText();
    }

    public String getExpectedResult() {
        return expectedSuccessfulResult;
    }
    public String getExpectedMissingInfoResult(){
        return expectedMissingInfoResult;
    }



    public String getExpectedPlaceOrderStatement() {
        return expectedPlaceOrderStatement;
    }

    public String getActualPlaceOrderStatement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderStatementLocator)).getText();
    }


    public void clickOnOk() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getActualMissingInfoResult() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }
}
