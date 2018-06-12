package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.awt.*;

public class LoginPage extends PageObject {

    @Timeout(3)
    @FindBy(id = "user")
    private TextInput email;

    @Timeout(3)
    @FindBy(id = "password")
    private TextInput password;

    @Timeout(3)
    @FindBy(xpath = ".//input[contains(@type, 'submit')]")
    private TextInput submit;

    public TextArea getErrorMessage() {
        return errorMessage;
    }

    @FindBy(className = "error-message")
    private TextArea errorMessage;

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
