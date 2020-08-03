package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.business.CreateNewShipmentPage;
import pages.business.LoginPage;
import pages.business.ShipmentsPage;
import tests.TestBase;

public class BusinessUserCreateNewShipmentsTest extends TestBase{
    LoginPage loginPageObject;
    CreateNewShipmentPage newShipmentPageObject;
    ShipmentsPage shipmentsPageObject;

    @Given("user redirect to login page")
    public void userRedirectToLoginPage() throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        driver.navigate().to(ENV_URL);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("signin"));
    }

    @When("user enter valid login credentials and submit")
    public void userEnterValidLoginCredentialsAndSubmit() throws InterruptedException {
        loginPageObject.businessLogin(BUSINESS_EMAIL, BUSINESS_PASSWORD);
        Thread.sleep(2000);
    }

    @Then("user access shipments page")
    public void userAccessShipmentsPage() throws InterruptedException {
        driver.navigate().to(ENV_URL + "/shipments");
        Thread.sleep(4000);
        Assert.assertTrue(driver.getCurrentUrl().contains("shipments"));
    }

    @When("user click on create new shipment button")
    public void userClickOnCreateNewShipmentButton() throws InterruptedException {
        driver.navigate().to(ENV_URL + "/shipments/create");
        Thread.sleep(2000);
    }

    @And("user enter Forward shipment data and submit")
    public void userEnterForwardShipmentDataAndSubmit() throws InterruptedException {
        newShipmentPageObject = new CreateNewShipmentPage(driver);
        newShipmentPageObject.createNewSendShipment();
    }

    @And("user enter Exchange shipment data and submit")
    public void userEnterExchangeShipmentDataAndSubmit() throws InterruptedException {
        newShipmentPageObject = new CreateNewShipmentPage(driver);
        newShipmentPageObject.createNewExchangeShipment();
    }

    @And("user enter CRP shipment data and submit")
    public void userEnterCRPShipmentDataAndSubmit() throws InterruptedException {
        newShipmentPageObject = new CreateNewShipmentPage(driver);
        newShipmentPageObject.createNewCRPShipment();
    }

    @And("user enter Cash Collection shipment data and submit")
    public void userEnterCashCollectionShipmentDataAndSubmit() throws InterruptedException {
        newShipmentPageObject = new CreateNewShipmentPage(driver);
        newShipmentPageObject.createNewCashCollection();
    }

    @And("user redirect to shipments page with success message")
    public void userRedirectToShipmentsPageWithSuccessMessage() throws InterruptedException {
        shipmentsPageObject = new ShipmentsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(shipmentsPageObject.successMessage.getText()
                .contains("Your shipment has been created. Tracking No"));
    }

    @When("user click on logout button")
    public void userClickOnLogoutButton() throws InterruptedException {
        driver.navigate().to(ENV_URL + "/logout");
        Thread.sleep(1000);
    }

    @Then("user redirected to login page")
    public void userRedirectedToLoginPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signin"));
    }

}
