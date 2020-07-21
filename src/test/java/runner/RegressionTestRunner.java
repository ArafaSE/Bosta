package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features = "src/test/java/features/",
        tags = "@regression",
        glue = {"steps"},
        plugin = {"pretty", "html:cucumber-test-results-report.html"})
public class RegressionTestRunner extends TestBase {}
