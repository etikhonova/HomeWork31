import Pages.LkProfilePage;
import Pages.MainPage;
import helpers.BaseUITest;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Test;

public class OtusContactsTest extends BaseUITest {
    @Test
    public void getFirstNameText (){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(OtusContactsTest.class);
        logger.info("First name add and get Test started");
        String firstname = "Елена";
    MainPage newMainPage = new MainPage(driver);
    newMainPage
            .open()
            .openLoginForm()
            .enterLogin("hell_me@list.ru")
            .enterPassword("Ee12345!")
            .submitLogin()
            .openLkProfilePage()
            .enterFirstName(firstname)
            .submitProfile();
    String firstNameText = new LkProfilePage(driver).lkPageOpen().getFirstName();
    Assert.assertEquals(firstname,firstNameText);


    }
    @Test
    public void getLastNameText () {
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(OtusContactsTest.class);
        logger.info("Last name add and get Test started");
        String lastname = "Тихонова";
        MainPage newMainPage = new MainPage(driver);
        newMainPage
                .open()
                .openLoginForm()
                .enterLogin("hell_me@list.ru")
                .enterPassword("Ee12345!")
                .submitLogin()
                .openLkProfilePage()
                .enterLastName(lastname)
                .submitProfile();
        String lastNameText = new LkProfilePage(driver).lkPageOpen().getLastName();
        Assert.assertEquals(lastname,lastNameText);

    }
    @Test
    public void addContactsTest(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(OtusContactsTest.class);
        logger.info("Additional contact add and get Test started");
            MainPage newMainPage = new MainPage(driver);
            String contactName = "VK";
            String contactValue = "random link";
        newMainPage
                .open()
                .openLoginForm()
                .enterLogin("hell_me@list.ru")
                .enterPassword("Ee12345!")
                .submitLogin()
                .openLkProfilePage()
                .enterAdditionalContact(contactName, contactValue)
                .submitProfile();

    }
}
