package Pages;

import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    public MainPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='header2__auth js-open-modal']")
    private WebElement loginbutton ;
    @FindBy(xpath = "//*[@class='header2-menu__item header2__right__menu__item header2-menu__item_small header2-menu__item_dropdown header2-menu__item_dropdown_no-border']")
    private WebElement menuProfileLink;
    @FindBy(xpath = "//*[@class='header2-menu__dropdown-text']")
    private WebElement menuPersonalInformationLink;
    private WebDriver driver;



    public LoginForm openLoginForm () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginButtonWait = wait
                .until(ExpectedConditions
                        .elementToBeClickable(loginbutton));
        loginButtonWait.click();
        return new LoginForm(driver);
    }

    public LkProfilePage openLkProfilePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement menuProfileLinkWait = wait.until(ExpectedConditions.visibilityOf(menuProfileLink));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuProfileLinkWait).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuPersonalInformationLink);
        return new LkProfilePage(driver);
    }

    public MainPage open (){
        PropertiesReader reader = new PropertiesReader("my.properties");
        driver.get(reader.getProperty("otus.main.link"));
        return this;
    }
}
