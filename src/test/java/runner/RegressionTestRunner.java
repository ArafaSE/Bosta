package runner;

import io.cucumber.testng.CucumberOptions;
import tests.business.TestBase;

@CucumberOptions(
        features = "src/test/java/features/",
        tags = "@regression",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"})
public class RegressionTestRunner extends TestBase {}
