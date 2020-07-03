package tests.business;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.business.CreateNewShipmentPage;
import pages.business.LoginPage;
import pages.business.ShipmentsPage;

public class CreateNewShipmentTest extends TestBase {
    /* ************************ page objects *************************** */
    CreateNewShipmentPage newShipmentObject;
    ShipmentsPage shipmentsPageObject;
    LoginPage loginPageObject;

    // 1. login
    @Test(priority = 1)
    public void businessUserCanLogin() throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        driver.navigate().to(ENV_URL);
        Thread.sleep(2000);
        loginPageObject.businessLogin(BUSINESS_EMAIL, BUSINESS_PASSWORD);
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("shipments"));
    }

    // 2. create forward/ send delivery
    @Test(dependsOnMethods = "businessUserCanLogin", priority = 2)
    public void businessUserCanCreateSendShipments() throws InterruptedException {
        newShipmentObject = new CreateNewShipmentPage(driver);
        driver.navigate().to(ENV_URL + "/shipments/create");
        Thread.sleep(2000);

        newShipmentObject.createNewSendShipment();
        // check success message
        shipmentsPageObject = new ShipmentsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(shipmentsPageObject.successMessage.getText()
                .contains("Your shipment has been created. Tracking No"));
    }

    // 3. create Cash collection delivery
    @Test(dependsOnMethods = "businessUserCanLogin", priority = 3)
    public void businessUserCanCreateCashCollectionOrder() throws InterruptedException {
        newShipmentObject = new CreateNewShipmentPage(driver);
        driver.navigate().to(ENV_URL + "/shipments/create");
        Thread.sleep(2000);

        newShipmentObject.createNewCashCollection();
        // check success message
        shipmentsPageObject = new ShipmentsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(shipmentsPageObject.successMessage.getText()
                .contains("Your shipment has been created. Tracking No"));
    }

    // 4. create CRP delivery
    @Test(dependsOnMethods = "businessUserCanLogin", priority = 4)
    public void businessUserCanCreateNewCrpOrder() throws InterruptedException {
        newShipmentObject = new CreateNewShipmentPage(driver);
        driver.navigate().to(ENV_URL + "/shipments/create");
        Thread.sleep(2000);

        newShipmentObject.createNewCRPShipment();
        // check success message
        shipmentsPageObject = new ShipmentsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(shipmentsPageObject.successMessage.getText()
                .contains("Your shipment has been created. Tracking No"));
    }

    // 5. create Exchange delivery
    @Test(dependsOnMethods = "businessUserCanLogin", priority = 5)
    public void businessUserCanCreateExchangeOrder() throws InterruptedException {
        newShipmentObject = new CreateNewShipmentPage(driver);
        driver.navigate().to(ENV_URL + "/shipments/create");
        Thread.sleep(2000);

       newShipmentObject.createNewExchangeShipment();
        // check success message
        shipmentsPageObject = new ShipmentsPage(driver);
        Thread.sleep(2000);

        Assert.assertTrue(shipmentsPageObject.successMessage.getText()
                .contains("Your shipment has been created. Tracking No"));
    }

    // 6. logout
    @Test(dependsOnMethods = "businessUserCanLogin", priority = 6)
    public void businessUserCanLogout() throws InterruptedException {
        //shipmentsPageObject = new ShipmentsPage(driver);
        //shipmentsPageObject.logout();
        driver.navigate().to(ENV_URL + "/logout");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signin"));
    }
}
