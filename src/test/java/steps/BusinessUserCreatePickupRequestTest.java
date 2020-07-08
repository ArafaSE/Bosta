package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.business.CreatePickupRequestPage;
import tests.business.TestBase;

public class BusinessUserCreatePickupRequestTest extends TestBase {

    CreatePickupRequestPage createPickupPageObject;

    @Given("user redirect to create pickups page")
    public void userRedirectToCreatePickupsPage() throws InterruptedException {
        driver.navigate().to(ENV_URL + "/pickups/create");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("create"));
    }

    @When("user enter pickup request data and submit")
    public void userEnterPickupRequestDataAndSubmit() throws InterruptedException {
        createPickupPageObject = new CreatePickupRequestPage(driver);
        createPickupPageObject.createPickupRequest();
        Thread.sleep(1000);
    }

    @Then("pickup created successfully message appears")
    public void pickupCreatedSuccessfullyMessageAppears() {
        Assert.assertEquals(driver.getCurrentUrl(), ENV_URL + "/pickups");
    }

    @Given("user in the pickups page")
    public void userInThePickupsPage() throws InterruptedException {
        driver.navigate().to(ENV_URL + "/pickups");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), ENV_URL + "/pickups");
    }
}
