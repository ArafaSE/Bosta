package pages.business;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePickupRequestPage extends PageBase {
    public CreatePickupRequestPage(WebDriver driver) {
        super(driver);
    }

    // Page elements
    @FindBy(id = "name")
    WebElement contactPersonNameTxt;

    @FindBy(id = "phone")
    WebElement contactPersonPhoneTxt;

    @FindBy(id = "email")
    WebElement contactPersonEmailTxt;

    @FindBy(id = "notes")
    WebElement pickupNoteTxt;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/main/div/div/div[2]/div/form/button")
    WebElement pickupSubmitBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/main/div/div/div[2]/div/form/div[2]/button[3]")
    WebElement setDateBtn;

    // variables
    protected String fContactPersonName, fContactPersonPhone, fContactPersonEmail, fPickupNote;

    private void setFakePickupData(){
        // fake data from gitHub Java Faker
        Faker fakeUser = new Faker();

        fContactPersonName = fakeUser.name().fullName();
        fContactPersonPhone = "014" + fakeUser.number().digits(8);
        fContactPersonEmail = fakeUser.internet().emailAddress();
        fPickupNote = "Automated pickup request by Selenium web-driver";
    }

    public void createPickupRequest(){
        setFakePickupData();

        setTextElement(contactPersonNameTxt, fContactPersonName);
        setTextElement(contactPersonPhoneTxt, fContactPersonPhone);
        setTextElement(contactPersonEmailTxt, fContactPersonEmail);
        setTextElement(pickupNoteTxt, fPickupNote);

        clickButton(pickupSubmitBtn);
    }
}
