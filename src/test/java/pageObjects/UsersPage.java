package pageObjects;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.SysexMessage;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsersPage extends PageObject{

    @FindBy(xpath = "//th[@alt='email']")
    private WebElement emailHeader;

    @FindBy(xpath = "//th[@alt='firstname']")
    private WebElement nameHeader;

    @FindBy(xpath = "//th[@alt='lastname']")
    private WebElement lastnameHeader;

    @FindBy(xpath = "//th[@alt='verifiedAt']")
    private WebElement verifiedAtHeader;

    @FindAll(@FindBy(xpath = "//tbody//tr"))
    private List<WebElement> tableRows;

    @FindAll(@FindBy(xpath = "//tbody//tr//td[1]"))
    private List<WebElement> listOfEmails;

    @FindAll(@FindBy(xpath = "//tbody//tr//td[2]"))
    private List<WebElement> listOfNames;

    @FindAll(@FindBy(xpath = "//tbody//tr//td[3]"))
    private List<WebElement> listOfLastNames;

    @FindAll(@FindBy(xpath = "//tbody//tr//td[4]"))
    private List<WebElement> listOfVerfiedAt;


    public UsersPage(WebDriver driver) {super(driver);}


    public WebElement getEmailHeader() {
        return emailHeader;
    }

    public WebElement getNameHeader() {
        return nameHeader;
    }

    public WebElement getLastNameHeader() {
        return lastnameHeader;
    }

    public WebElement getVerifiedAtHeader() {
        return verifiedAtHeader;
    }

    public List<WebElement> getListOfEmails() {
        return listOfEmails;
    }

    public List<WebElement> getListOfNames() {
        return listOfNames;
    }

    public List<WebElement> getListOfLastNames() {
        return listOfLastNames;
    }

    public List<WebElement> getListOfVerifiedAt() {
        return listOfVerfiedAt;
    }

    public void sortBy(WebElement header) throws InterruptedException {
        header.click();
        Thread.sleep(1000);
    }

    public boolean checkIfRowsAreSortedAscending(List<WebElement> list) {
        boolean result = true;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean checkIfRowsAreSortedDescending(List<WebElement> list) {
        boolean result = true;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                System.out.println(list.get(i).getText());
                System.out.println(list.get(i + 1).getText());
                result = false;
                break;
            }
        }
        return result;
    }
}
