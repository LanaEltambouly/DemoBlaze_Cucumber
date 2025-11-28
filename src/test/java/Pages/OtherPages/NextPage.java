package Pages.OtherPages;


import Pages.HomePage;
import org.openqa.selenium.WebDriver;


public class NextPage extends HomePage {
    WebDriver driver;


    public NextPage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }



}
