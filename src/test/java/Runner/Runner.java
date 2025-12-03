package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "DemoBlaze_Cucumber/src/main/resources/Features",
        glue = {"StepDefinitions", "HooksPackage"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"} ,
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}
