package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features = "src/test/java/features/BusinessUserCreateNewShipments.feature",
        glue = {"steps"},
        plugin = {"pretty", "html:cucumber-test-results-report.html"})
public class CreateNewShipmentsTestRunner extends TestBase {
}
