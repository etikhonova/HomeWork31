package Pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LkSkillsPage {
    public LkSkillsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    org.apache.logging.log4j.Logger logger = LogManager.getLogger(LkSkillsPage.class);
    private WebDriver driver;

    public LkSkillsPage lkPageOpen() {
        logger.info("Open LK Skills page");
        driver.get("https://otus.ru/lk/biography/skills/");
        return this;
    }
}