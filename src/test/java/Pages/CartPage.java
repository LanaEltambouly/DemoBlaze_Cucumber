package Pages;

import io.cucumber.java.hu.De;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait ;
    By PlaceOrderButtonLocator = By.xpath("//button[text()='Place Order']");
    By DeleteLocator = By.linkText("Delete") ;
    By TitleLocator = By.xpath("//table[@class='table table-bordered table-hover table-striped']//td[2]");
    By PriceLocator = By.xpath("//table[@class='table table-bordered table-hover table-striped']//td[3]");
    By imageLocator = By.xpath("//table[@class='table table-bordered table-hover table-striped']//img");
    By TotalPriceLocator = By.id("totalp");
    By RowLocator = By.className("success");
    List<WebElement> products;
    List<WebElement> DeletedProducts;


    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public PlaceOrderPage ClickOnPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PlaceOrderButtonLocator))).click();
        return new PlaceOrderPage(driver);
    }

    public void ClickOnDelete(int i){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DeleteLocator));
            products = driver.findElements(DeleteLocator);
            products.get(i).click();
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(RowLocator)));
    }


    public boolean checkTotalPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPriceLocator)).isDisplayed();
    }

    public boolean displayedImage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imageLocator));
        products = driver.findElements(imageLocator);
        for (WebElement p : products){
        if(!p.isDisplayed()) return false;
        }
        return true;
    }


    public double getActualTotalProductPrice() {
        List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PriceLocator));
        double sum = 0.0;
        for (WebElement priceElement : priceElements) {
            sum += Double.parseDouble(priceElement.getText());
        }
        return sum;
    }


    public boolean checkTitles(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TitleLocator));
        products = driver.findElements(TitleLocator);
        for (WebElement p : products){
            if(!p.isDisplayed()) return false;
        }
        return true;
    }
    public Double getFoundTotalPrice(){
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPriceLocator)).getText());
    }
    public boolean checkPrices(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PriceLocator));
        products = driver.findElements(PriceLocator);
        for (WebElement p : products){
            if(!p.isDisplayed()) return false;
        }
        return true;
    }

    public int getProductsListSize(){
        products = driver.findElements(RowLocator);
        return products.size();
    }

    public boolean PlaceOrderButtonDisability(){
        return !driver.findElement(PlaceOrderButtonLocator).isEnabled();
    }



}
