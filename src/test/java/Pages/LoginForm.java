package Pages;

import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginForm {
    public LoginForm(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    private WebDriver driver;
    @FindBy(xpath = "//form[@action='/login/']//input[@name='email']")
    private WebElement loginField ;
    @FindBy(xpath = "//form[@action='/login/']//input[@name='password']")
    private WebElement passwordField ;
    @FindBy(xpath = "//form[@action='/login/']//button[@type='submit']")
    private WebElement loginSubmitButton ;

    public LoginForm enterLogin (String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginEmailWait =wait.
                until(ExpectedConditions.visibilityOf(loginField));
        loginEmailWait.sendKeys(text);
        return new LoginForm(driver);
    }

    public LoginForm enterPassword(String text) {
        passwordField.sendKeys(text);
        return new LoginForm(driver);
    }

    public MainPage submitLogin (){
        loginSubmitButton.click();
        return new MainPage(driver);
    }

    public MainPage authorise ()  {
            String login = System.getProperty("login");
            String password = System.getProperty("password");
            LoginForm newLoginForm = new LoginForm(driver);
            newLoginForm
                    .enterLogin(login)
                    .enterPassword(password)
                    .submitLogin();
       return new MainPage(driver);
    }
}
