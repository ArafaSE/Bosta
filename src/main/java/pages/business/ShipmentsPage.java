package pages.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShipmentsPage extends PageBase {
    public ShipmentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "Toastify__toast-body")
    public WebElement successMessage;

    @FindBy(linkText = "logout")
    WebElement logoutBtn;


    public void logout(){
        clickButton(logoutBtn);
    }
}
