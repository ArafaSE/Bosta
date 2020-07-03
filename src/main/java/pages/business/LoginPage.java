package pages.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "email-control")
    WebElement userEmailTxt;

    @FindBy(id = "password-control")
    WebElement userPasswordTxt;

    @FindBy(css = "button.login-submit.btn.btn-primary")
    WebElement loginBtn;

    @FindBy(css = "button.button-sign.btn.btn-secondary")
    WebElement signInButton;

    public void businessLogin(String email, String password){
        setTextElement(userEmailTxt, email);
        setTextElement(userPasswordTxt, password);
        clickButton(loginBtn);
    }
    public void clickOnSignInButton(){
        clickButton(signInButton);
    }
}
