package pages.business;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "business-control")
    WebElement businessNameTxt;

    @FindBy(id = "category-control")
    WebElement categoryList;

    @FindBy(id = "promoCode-control")
    WebElement bostaCodeTxt;

    @FindBy(id = "heardAboutUsFrom-control")
    WebElement hearAboutUsList;

    @FindBy(id = "address-control")
    WebElement addressLineTxt;

    @FindBy(id = "city-control")
    WebElement citiesList;

    @FindBy(id = "zone-control")
    WebElement zonesList;

    @FindBy(id = "building-control")
    WebElement buildingTxt;

    @FindBy(id = "floor-control")
    WebElement floorTxt;

    @FindBy(id = "apt-control")
    WebElement aptTxt;

    @FindBy(css = "a.login-submit")
    WebElement continueBtn;

    @FindBy(id = "name-control")
    WebElement nameTxt;

    @FindBy(id = "email-control")
    WebElement emailTxt;

    @FindBy(id = "phone-control")
    WebElement phoneTxt;

    @FindBy(id = "password-control")
    WebElement passwordTxt;

    @FindBy(id = "confirm-password-control")
    WebElement confirmPasswordTxt;

    @FindBy(css = "button.login-submit.btn.btn-primary")
    WebElement saveAndContinueBtn;

    @FindBy(css = "div.header-sign")
    public WebElement bostaHeaderSection;

    public void createNewBusinessUser(
            String fakeFullName, String fakeEmail, String fakePassword,
            String fakeMobile, String fakeBusiness, String fakeBostaCode, String fakeAddress)
            throws InterruptedException {

        /* registration steps  */
        setTextElement(businessNameTxt, fakeBusiness);
        Select selectCategory = new Select(categoryList);
        selectCategory.selectByVisibleText("Facebook Seller");
        setTextElement(bostaCodeTxt, fakeBostaCode);
        Select selectHearAboutUs = new Select(hearAboutUsList);
        selectHearAboutUs.selectByVisibleText("Google");
        setTextElement(addressLineTxt, fakeAddress);
        Select selectCity = new Select(citiesList);
        selectCity.selectByVisibleText("Cairo");
        Thread.sleep(2000);
        Select selectZone = new Select(zonesList);
        selectZone.selectByVisibleText("Nasr City");
        setTextElement(buildingTxt, "2");
        setTextElement(floorTxt, "2");
        setTextElement(aptTxt, "2");
        clickButton(continueBtn);

        setTextElement(nameTxt, fakeFullName);
        setTextElement(emailTxt, fakeEmail);
        setTextElement(phoneTxt, fakeMobile);
        setTextElement(passwordTxt, "12345678");
        setTextElement(confirmPasswordTxt, "12345678");

        clickButton(saveAndContinueBtn);
    }

}
