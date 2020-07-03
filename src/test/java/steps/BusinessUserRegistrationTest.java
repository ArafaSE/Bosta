package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.business.LoginPage;
import pages.business.RegistrationPage;
import tests.business.TestBase;

public class BusinessUserRegistrationTest extends TestBase {
    LoginPage loginPageObject;
    RegistrationPage registrationPageObject;

    // fake data from gitHub Java Faker
    Faker fakeUser = new Faker();
    String fakeFullName = fakeUser.name().fullName();
    String fakeEmail = fakeUser.internet().emailAddress();
    String fakePassword = fakeUser.number().digits(8);
    String fakeMobile = "014" + fakePassword;
    String fakeBusiness = fakeUser.company().industry();
    String fakeBostaCode = fakeUser.number().digits(4);
    String fakeAddress = fakeUser.address().streetAddress();


    @Given("the user open sign in page")
    public void theUserOpenSignInPage() {
        driver.navigate().to(ENV_URL + "/signin");
        Assert.assertEquals(driver.getCurrentUrl(), ENV_URL + "/signin");
    }

    @When("user click on registration button")
    public void userClickOnRegistrationButton() {
        loginPageObject = new LoginPage(driver);
        loginPageObject.clickOnSignInButton();
        Assert.assertEquals(driver.getCurrentUrl(), ENV_URL + "/signup");
    }

    @And("user enter his registration data and submit")
    public void userEnterHisRegistrationDataAndSubmit() throws InterruptedException {
        registrationPageObject = new RegistrationPage(driver);
        registrationPageObject.createNewBusinessUser(
                fakeFullName, fakeEmail, fakePassword, fakeMobile, fakeBusiness, fakeBostaCode, fakeAddress);
    }

    @Then("Bosta header section is displayed")
    public void bostaHeaderSectionIsDisplayed() {
        Assert.assertTrue(registrationPageObject.bostaHeaderSection.isDisplayed());
    }
}
