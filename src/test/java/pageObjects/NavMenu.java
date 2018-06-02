package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavMenu extends PageObject {

    @FindBy(linkText = "Strona główna")
    WebElement mainPage;

    @FindBy(linkText = "Użytkownicy")
    WebElement usersPage;

    @FindBy(linkText = "Wyloguj")
    WebElement logout;

    @FindBy(linkText = "Logowanie")
    WebElement login;

    @FindBy(linkText = "Zarejestruj się")
    WebElement register;

    public NavMenu(WebDriver driver) {
        super(driver);
    }
}
