package BaseTests;

import Pages.*;
import Pages.Categories.CategoriesPage;
import Pages.Categories.LaptopsCatPage;
import Pages.Categories.MonitorsCatPage;
import Pages.Categories.PhonesCatPage;
import Pages.OtherPages.NextPage;
import Pages.OtherPages.PreviousPage;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTestClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homepage;
    protected SignUpPage signuppage;
    protected LogInPage loginPage;
    protected CartPage cartPage;
    protected ProductPage productPage;
    protected PlaceOrderPage placeOrderPage;
    protected CategoriesPage categoriesPage;
    protected PhonesCatPage phonesCatPage;
    protected LaptopsCatPage laptopsCatPage;
    protected MonitorsCatPage monitorsCatPage;
    protected ContactPage contactPage ;
    protected NextPage nextPage;
    protected PreviousPage previousPage;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver() ;
        homepage = new HomePage(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        categoriesPage = new CategoriesPage(driver);
        phonesCatPage = new PhonesCatPage(driver);
        laptopsCatPage = new LaptopsCatPage(driver);
        monitorsCatPage = new MonitorsCatPage(driver);
    }

    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://demoblaze.com/");
    }
    @AfterMethod
    public void clearAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {}
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
