package Pages.OtherPages;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class PreviousPage extends HomePage {
    WebDriver driver;

    public PreviousPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public List<String> expectedAllProducts = Arrays.asList( "Sony vaio i5", "Sony vaio i7", "MacBook air",
            "Dell i7 8gb","2017 Dell 15.6 Inch","MacBook Pro","Apple monitor 24", "ASUS Full HD",
            "Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7",
            "Iphone 6 32gb", "Sony xperia z5", "HTC One M9");

    public List<String> expectedLaptops = Arrays.asList("Sony vaio i5", "Sony vaio i7",
            "MacBook air", "Dell i7 8gb", "2017 Dell 15.6 Inch", "MacBook Pro");

    public List<String> expectedMonitors = Arrays.asList( "Apple monitor 24", "ASUS Full HD");

    public List<String> expectedPhones = Arrays.asList("Samsung galaxy s6",
            "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7", "Iphone 6 32gb",
            "Sony xperia z5", "HTC One M9");
}
