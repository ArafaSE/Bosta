package pages.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RegistrationPage extends PageBase{

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

    public void createNewBusinessUser() throws InterruptedException {
        /* generate random business number */
        int rand_business_num = ThreadLocalRandom.current().nextInt(5000);
        /* generate random phone number */
        Random rand = new Random();
        int num1 = rand.nextInt(9999);
        int num2 = rand.nextInt(9999);
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        String randPhoneNumber = "011" + df4.format(num1) + df4.format(num2);

        /* registration steps  */
        setTextElement(businessNameTxt, "Auto " + rand_business_num);
        Select selectCategory = new Select(categoryList);
        selectCategory.selectByVisibleText("Facebook Seller");
        setTextElement(bostaCodeTxt, "2354");
        Select selectHearAboutUs = new Select(hearAboutUsList);
        selectHearAboutUs.selectByVisibleText("Google");
        setTextElement(addressLineTxt, "Makram");
        Select selectCity = new Select(citiesList);
        selectCity.selectByVisibleText("Cairo");
        Thread.sleep(2000);
        Select selectZone = new Select(zonesList);
        selectZone.selectByVisibleText("Nasr City");
        setTextElement(buildingTxt, "2");
        setTextElement(floorTxt, "2");
        setTextElement(aptTxt, "2");
        clickButton(continueBtn);

        setTextElement(nameTxt, "Auto " + rand_business_num);
        setTextElement(emailTxt, "selenium."+rand_business_num+"@gmail.com");
        setTextElement(phoneTxt, randPhoneNumber);
        setTextElement(passwordTxt, "12345678");
        setTextElement(confirmPasswordTxt, "12345678");

        clickButton(saveAndContinueBtn);
    }

}
