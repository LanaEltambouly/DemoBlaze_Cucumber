package HooksPackage;

import Pages.*;
import Pages.Categories.CategoriesPage;
import Pages.Categories.LaptopsCatPage;
import Pages.Categories.MonitorsCatPage;
import Pages.Categories.PhonesCatPage;
import Pages.OtherPages.NextPage;
import Pages.OtherPages.PreviousPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Hooks {          //hya hya el BaseTestClass bs notations bta3t cucumber
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homepage;


    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver() ;
        homepage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://demoblaze.com/");
    }



    public void clearAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {}
    }


    @After
    public void tearDown(){
        driver.quit();
    }       //@Before @After da lel class, mafesh ay haga lel method
}
