package helpers;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import webDriverFactory.WebDriverFactory;

public class BaseUITest {
    protected WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseUITest.class);
    @Before
    public void setUp(){
        driver = WebDriverFactory.getDriver();
        logger.info("Driver set up");
    }


    @After
    public void setDown(){
        if(driver!=null) {
            driver.quit();
            logger.info("Driver set down");
        }
    }
}
