import Pages.LkProfilePage;
import Pages.MainPage;
import helpers.BaseUITest;
import helpers.ContactWayList;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Test;
import java.util.Locale;
import java.util.Random;

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
            .authorise()
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
                .authorise()
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
        newMainPage
                .open()
                .openLoginForm()
                .authorise()
                .openLkProfilePage();
         ContactWayList [] contactWays= ContactWayList.values();

        for (ContactWayList contactWay : contactWays){
            Random random = new Random();
            String contactValue = random.ints(97, 123)
                    .limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            LkProfilePage newLkProfilePage = new LkProfilePage(driver);
            logger.info("Add contact way {} contact name {}",contactWay.name().toLowerCase(Locale.ROOT),contactValue);
            newLkProfilePage.lkPageOpen().enterAdditionalContact(contactWay.name().toLowerCase(Locale.ROOT),contactValue).submitProfile();

            Assert.assertEquals(contactValue,newLkProfilePage.lkPageOpen().getAdditionalContactValue(contactWay.name().toLowerCase(Locale.ROOT)));
        }
        }



}
