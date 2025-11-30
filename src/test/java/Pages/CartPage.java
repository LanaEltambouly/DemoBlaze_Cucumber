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



    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public PlaceOrderPage ClickOnPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PlaceOrderButtonLocator))).click();
        return new PlaceOrderPage(driver);
    }



    public boolean checkTotalPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPriceLocator)).isDisplayed();
    }


    public double getActualTotalProductPrice() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PriceLocator));
        List<WebElement> priceElements = driver.findElements(PriceLocator);
        double sum = 0.0;
        for (WebElement priceElement : priceElements) {
            String price = priceElement.getText();
            sum += Double.parseDouble(price);
        }
        return sum;
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


    public boolean displayedImage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imageLocator));
        products = driver.findElements(imageLocator);
        for (WebElement p : products){
            if(!p.isDisplayed()) return false;
        }
        return true;
    }
    public boolean checkTitles(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TitleLocator));
        products = driver.findElements(TitleLocator);
        for (WebElement p : products){
            if(!p.isDisplayed()) return false;
        }
        return true;
    }

    public boolean PlaceOrderButtonDisability(){
        return !driver.findElement(PlaceOrderButtonLocator).isEnabled();
    }


    public int getNumberOfRows(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(RowLocator));
        List<WebElement> Rows = driver.findElements(RowLocator);
        return Rows.size();
    }

    public int getNumberOfRowsWhenCartIsEmpty(){
        List<WebElement> Rows = driver.findElements(RowLocator);
        return Rows.size();
    }

    public void DeleteProduct(int i){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(RowLocator));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DeleteLocator));

        driver.findElements(RowLocator).get(i).findElement(DeleteLocator).click();
        wait.until(ExpectedConditions.stalenessOf( driver.findElements(RowLocator).get(i)));
    }

    public void DeleteAllProducts(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(RowLocator));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DeleteLocator));

        List<WebElement> deleteProducts = driver.findElements(DeleteLocator);
        for(WebElement dP : deleteProducts){
            dP.click();
        }

    }






}
