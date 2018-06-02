package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.NavMenu;
import pageObjects.UsersPage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private UsersPage usersPage;
    private NavMenu navMenu;

    @Before
    public void beforeScenario() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

    @Given("I am on login page")
    public void loginPageInit() {
        driver.get("http://qa-test.programa.pl/user/login");
        navMenu = new NavMenu(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("I am logged in")
    public void loggedIN() {
        loginPageInit();
        enterCorrectCredentials();
        submitCredentials();
    }

    @Given("I am on users page")
    public void usersPageInit() {
        loggedIN();
        driver.get("http://qa-test.programa.pl/users");
        usersPage = new UsersPage(driver);
    }

    @When("I sort by \"([^\"]*)\" ascending")
    public void sortAscending(String header) throws InterruptedException {
        switch (header) {
            case "email":
                usersPage.sortBy(usersPage.getEmailHeader());
                break;
            case "name":
                usersPage.sortBy(usersPage.getNameHeader());
                break;
            case "last name":
                usersPage.sortBy(usersPage.getLastNameHeader());
                break;
            case "verified at":
                usersPage.sortBy(usersPage.getVerifiedAtHeader());
                break;
        }
    }

    @When("I sort by \"([^\"]*)\" descending")
    public void sortDescending(String header) throws InterruptedException {
        switch (header) {
            case "email":
                usersPage.sortBy(usersPage.getEmailHeader());
                usersPage.sortBy(usersPage.getEmailHeader());
                break;
            case "name":
                usersPage.sortBy(usersPage.getNameHeader());
                usersPage.sortBy(usersPage.getNameHeader());
                break;
            case "last name":
                usersPage.sortBy(usersPage.getLastNameHeader());
                usersPage.sortBy(usersPage.getLastNameHeader());
                break;
            case "verified at":
                usersPage.sortBy(usersPage.getVerifiedAtHeader());
                usersPage.sortBy(usersPage.getVerifiedAtHeader());
                break;
        }
    }

    @When("I enter correct credentials")
    public void enterCorrectCredentials() {
        loginPage.fillForm("i1167774@nwytg.com", "Q1w2e3r4");
    }

    @When("I submit credentials")
    public void submitCredentials() {
        loginPage.login();
    }

    @When("I filter by email with \"([^\"]*)\"")
    public void filterByEmailWithValue(String value) throws InterruptedException {
        usersPage.filterEmailByString(value);
    }

    @Then("I want to check filtering by email with \"([^\"]*)\"")
    public void checkFilteringByEmailWithValue(String value) {
        Assert.assertTrue(usersPage.chekcIfRowWithEmailIsVisibleAndIsOne(value));
    }

    @Then("I check if I was logged in")
    public void checkIfIWasLoggedIn() {
        Assert.assertEquals("http://qa-test.programa.pl/", driver.getCurrentUrl());
    }

    @Then("I want to check sorting by \"([^\"]*)\" ascending was correct")
    public void checkSortingAscending(String header) {
        switch (header) {
            case "email":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedAscending(usersPage.getListOfEmails()));
                break;
            case "name":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedAscending(usersPage.getListOfNames()));
                break;
            case "last name":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedAscending(usersPage.getListOfLastNames()));
                break;
            case "verified at":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedAscending(usersPage.getListOfVerifiedAt()));
                break;
        }
    }

    @Then("I want to check sorting by \"([^\"]*)\" descending was correct")
    public void checkSortingDescending(String header) {
        switch (header) {
            case "email":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedDescending(usersPage.getListOfEmails()));
                break;
            case "name":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedDescending(usersPage.getListOfNames()));
                break;
            case "last name":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedDescending(usersPage.getListOfLastNames()));
                break;
            case "verified at":
                Assert.assertTrue(usersPage.checkIfRowsAreSortedDescending(usersPage.getListOfVerifiedAt()));
                break;
        }
    }

}