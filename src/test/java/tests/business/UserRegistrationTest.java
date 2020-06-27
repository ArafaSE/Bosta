package tests.business;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.business.RegistrationPage;
import pages.business.LoginPage;
import pages.business.ShipmentsPage;

public class UserRegistrationTest extends TestBase{
    LoginPage loginPageObject;
    RegistrationPage registrationPageObject;
    ShipmentsPage shipmentsPageObject;
    // user can register as a new business
    @Test(priority = 1)
    public void newBusinessCanRegister() throws InterruptedException {
        driver.navigate().to(envURL+"/signup");
        registrationPageObject = new RegistrationPage(driver);
        registrationPageObject.createNewBusinessUser();
        Assert.assertTrue(registrationPageObject.bostaHeaderSection.isDisplayed());
    }
    // business user can login
    @Test(priority = 2)
    public void businessUserCanLogin() throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        driver.navigate().to(envURL+"/signin");
        loginPageObject.businessLogin(businessEmail, businessPassword);

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("shipments"));
    }
    // registered user can logout

    @Test(dependsOnMethods = "businessUserCanLogin")
    public void registeredBusinessUserCanLogout() throws InterruptedException {
        //shipmentsPageObject = new ShipmentsPage(driver);
        //shipmentsPageObject.logout();
        driver.navigate().to(envURL + "/logout");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signin"));
    }


}
