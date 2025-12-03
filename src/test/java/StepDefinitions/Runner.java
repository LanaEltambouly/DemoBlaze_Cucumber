package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\ahmed khaled\\OneDrive\\Desktop\\DemoBlaze_Cucumber\\DemoBlaze_Cucumber",
        glue = {"StepDefinitions", "HooksPackage"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"} ,
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}
