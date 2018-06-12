package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class RegisterPage extends PageObject {

    @Timeout(3)
    @FindBy(name = "name")
    private TextInput name;

    @Timeout(3)
    @FindBy(name = "email")
    private TextInput email;

    @Timeout(3)
    @FindBy(name = "password")
    private TextInput password;

    @Timeout(3)
    @FindBy(id = "signup")
    private TextInput singnupButton;

    public RegisterPage(WebDriver driver){super(driver);}

    public void setName(String name) {
        this.name.sendKeys(name);
    }
    public void setEmail(String email) {
        this.email.sendKeys(email);
    }
    public void setPassword(String password) {
        this.password.sendKeys(password);
    }
    public void sign() {
        singnupButton.click();
    }

    public TextInput getName() {
        return name;
    }

    public TextInput getEmail() {
        return email;
    }

    public TextInput getPassword() {
        return password;
    }

    public TextInput getSingnupButton() {
        return singnupButton;
    }

}
