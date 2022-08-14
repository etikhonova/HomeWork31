package Pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LkProfilePage {

    public LkProfilePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    org.apache.logging.log4j.Logger logger = LogManager.getLogger(LkProfilePage.class);
    @FindBy(xpath = "//input[@name='fname']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lname']")
    private WebElement lastNameField;
    @FindBy(xpath = "//button[@name='continue']")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@class='lk-cv-block__action lk-cv-block__action_md-no-spacing js-formset-add js-lk-cv-custom-select-add']")
    private WebElement addLink;
    @FindBy(xpath = "//*[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']")
    private WebElement contactNameList;
    @FindBy(xpath = "//div[@class='container__row js-formset-row']//input[@type='text']")
    private WebElement contactValueTextArea;
    private WebDriver driver;

  public LkProfilePage lkPageOpen (){
      logger.info("Open LK profile page");
      driver.get("https://otus.ru/lk/biography/personal/");
      return this;
  }
  public LkProfilePage enterFirstName (String firstName){
      logger.info("Enter Fist Name %s", firstName);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      WebElement enterFirstNameWait = wait.until(ExpectedConditions.visibilityOf(firstNameField));
      enterFirstNameWait.clear();
      enterFirstNameWait.sendKeys(firstName);
      return this;
  }
  public LkProfilePage enterLastName (String lastName){
      logger.info("Enter Last Name " + lastName);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      WebElement enterLastNameWait = wait.until(ExpectedConditions.visibilityOf(lastNameField));
      enterLastNameWait.clear();
      enterLastNameWait.sendKeys(lastName);
      return this;
  }
  public String getFirstName (){
      logger.info("Get First Name");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      WebElement enterFirstNameWait = wait.until(ExpectedConditions.visibilityOf(firstNameField));
      return enterFirstNameWait.getAttribute("value");
  }
  public String getLastName (){
      logger.info("Get Last Name");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      WebElement enterLastNameWait = wait.until(ExpectedConditions.visibilityOf(lastNameField));
      return enterLastNameWait.getAttribute("value");
  }
  public LkSkillsPage submitProfile () {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement submitButtonWait = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
      submitButtonWait.click();
      logger.info("Submit Profile");
      return new LkSkillsPage(driver);
  }
  public LkProfilePage enterAdditionalContact (String contactName, String contactValue) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement addLinkWait = wait.until(ExpectedConditions.elementToBeClickable(addLink));
      addLinkWait.click();
      Actions actions = new Actions(driver);
      actions.moveToElement(contactNameList).perform();
      try
      {
          Thread.sleep(1000);
      } catch (InterruptedException e)
      {
          e.printStackTrace();
      }
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", contactNameList);
      try
      {
          Thread.sleep(1000);
      } catch (InterruptedException e)
      {
          e.printStackTrace();
      }
      actions.moveToElement(driver.findElement(By.xpath("//button[@data-value='facebook']"))).perform();
      try
      {
          Thread.sleep(1000);
      } catch (InterruptedException e)
      {
          e.printStackTrace();
      }
      WebElement contactValueTextAreaWait = wait.until(ExpectedConditions.visibilityOf(contactValueTextArea));
      contactValueTextAreaWait.clear();
      contactValueTextAreaWait.sendKeys(contactValue);
    logger.info("Enter new Contact");
    return new LkProfilePage(driver);
  }

}

