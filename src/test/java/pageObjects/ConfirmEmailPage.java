package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class ConfirmEmailPage extends PageObject{

    public TextArea getConfirm() {
        return confirm;
    }

    @FindBy(className = "confirm-email-content")
    TextArea confirm;

    public ConfirmEmailPage(WebDriver driver){super(driver);}
}
