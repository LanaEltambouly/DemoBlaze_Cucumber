package HooksPackage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Hooks {          //hya hya el BaseTestClass bs notations bta3t cucumber
    public static WebDriver driver; //for no object creation

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver() ;
        driver.get("https://demoblaze.com/");
    }


    @After
    public void tearDown(){
        driver.quit();
    }       //@Before @After da lel class, mafesh ay haga lel method
}
