package tests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;
import pageObjects.ConfirmEmailPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ConfirmEmailPage confirmEmailPage;

    private void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(driver -> {
            System.out.println("Current Window State       : "
                    + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }

    @Before
    public void beforeScenario() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
    }

    @After
    public void afterScenario(Scenario scenario) {
        driver.quit();
    }

    @Given("I am on register page")
    public void getToRegisterPage() {
        driver.get("https://trello.com/signup");
        registerPage = new RegisterPage(driver);
        waitForPageLoad();
    }

    @Given("I am on login page")
    public void getToLoginPage() {
        driver.get("https://trello.com/login");
        loginPage = new LoginPage(driver);
        waitForPageLoad();
    }

    @When("I fill login form with incorrect user")
    public void fillLoginFormWithPrevious() {
        loginPage.fillForm("j1738574@nwytg.com", "wewqdaasdawfafazfsa");
    }

    @When("I submit login form")
    public void submitLoginForm() {
        loginPage.login();
        confirmEmailPage = new ConfirmEmailPage(driver);
    }

    @When("I fill register form with random email and password")
    public void fillRegisterFormWithRandomEmail() {
        String email = RandomStringUtils.randomAlphabetic(6);
        String password = RandomStringUtils.randomAlphanumeric(8);
        registerPage.setEmail(email + "@gmail.com");
        registerPage.setName(RandomStringUtils.randomAlphabetic(6));
        registerPage.setPassword(password);
    }

    @When("I submit register form")
    public void submitRegisterForm() {
        registerPage.sign();
        confirmEmailPage = new ConfirmEmailPage(driver);
    }

    @Then("I want to check if I was logged in")
    public void checkIncorrectLogin() throws InterruptedException {
        waitForPageLoad();
        Thread.sleep(5000);
        Assert.assertEquals("https://trello.com/login", driver.getCurrentUrl());
    }

    @Then("I want to check if I was registered")
    public void checkCorrectRegister() throws InterruptedException {
        waitForPageLoad();
        Thread.sleep(5000);
        Assert.assertNotEquals("https://trello.com/signup", driver.getCurrentUrl());
    }


}