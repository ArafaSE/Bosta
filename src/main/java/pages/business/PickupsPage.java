package pages.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PickupsPage extends PageBase {
    public PickupsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "Toastify__toast-body")
    public WebElement alertMessage;

}
