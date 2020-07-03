package tests.business;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.business.RegistrationPage;
import pages.business.LoginPage;
import pages.business.ShipmentsPage;

public class UserRegistrationTest extends TestBase{
    LoginPage loginPageObject;
    RegistrationPage registrationPageObject;
    ShipmentsPage shipmentsPageObject;

    // fake data from gitHub Java Faker
    Faker fakeUser = new Faker();
    String fakeFullName = fakeUser.name().fullName();
    String fakeEmail = fakeUser.internet().emailAddress();
    String fakePassword = fakeUser.number().digits(8);
    String fakeMobile = "014" + fakePassword;
    String fakeBusiness = fakeUser.company().industry();
    String fakeBostaCode = fakeUser.number().digits(4);
    String fakeAddress = fakeUser.address().streetAddress();

    // user can register as a new business
    @Test(priority = 1)
    public void newBusinessCanRegister() throws InterruptedException {
        driver.navigate().to(ENV_URL+"/signup");
        registrationPageObject = new RegistrationPage(driver);
        registrationPageObject.createNewBusinessUser(
                fakeFullName, fakeEmail, fakePassword, fakeMobile, fakeBusiness, fakeBostaCode, fakeAddress);
        Assert.assertTrue(registrationPageObject.bostaHeaderSection.isDisplayed());
    }
    // business user can login
    @Test(priority = 2)
    public void businessUserCanLogin() throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        driver.navigate().to(ENV_URL+"/signin");
        loginPageObject.businessLogin(BUSINESS_EMAIL, BUSINESS_PASSWORD);

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("shipments"));
    }
    // registered user can logout

    @Test(dependsOnMethods = "businessUserCanLogin")
    public void registeredBusinessUserCanLogout() throws InterruptedException {
        //shipmentsPageObject = new ShipmentsPage(driver);
        //shipmentsPageObject.logout();
        driver.navigate().to(ENV_URL + "/logout");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signin"));
    }

}
