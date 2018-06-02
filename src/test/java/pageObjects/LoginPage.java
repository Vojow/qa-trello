package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-email")
    private WebElement email;

    @FindBy(id = "user-password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }

    public void login() {
        this.submit.click();
    }

}
